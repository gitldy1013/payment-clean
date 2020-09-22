package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.*;
import com.cmcc.paymentclean.entity.PcacRiskInfo;
import com.cmcc.paymentclean.entity.SysLan;
import com.cmcc.paymentclean.entity.dto.PcacRiskInfoDTO;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.*;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.entity.dto.response.PcacRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.PcacRiskInfoReq;
import com.cmcc.paymentclean.entity.dto.resquest.ReissueRiskInfoReq;
import com.cmcc.paymentclean.exception.SubmitPCACException;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.PcacRiskInfoMapper;
import com.cmcc.paymentclean.service.PcacRiskInfoService;
import com.cmcc.paymentclean.service.SysLanService;
import com.cmcc.paymentclean.utils.BeanUtilsEx;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.InnerCipherUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * <p>
 * 商户黑名单提示信息表 服务实现类
 * </p>
 *
 * @author cmcc
 * @since 2020-09-08
 */
@Slf4j
@Service
public class PcacRiskInfoServiceImpl extends ServiceImpl<PcacRiskInfoMapper, PcacRiskInfo> implements PcacRiskInfoService {

    @Autowired
    private PcacConfig pcacConfig;

    @Autowired
    private PcacRiskInfoService pcacRiskInfoService;

    @Autowired
    private PcacRiskInfoMapper pcacRiskInfoMapper;

    @Autowired
    private SysLanService sysLanService;

    @Override
    public ResultBean<Page<PcacRiskInfoResp>> pagePcacRiskInfo(PcacRiskInfoReq riskInfoReq) {
        log.info("pagePcacRiskInfo req={}", com.alibaba.fastjson.JSON.toJSON(riskInfoReq));
        ResultBean<Page<PcacRiskInfoResp>> resultBean = new ResultBean();
        Page<PcacRiskInfoResp> page = new Page<>(riskInfoReq.getPageNo(), riskInfoReq.getPageSize());
        Page<PcacRiskInfoResp> pcacPersonRiskSubmitInfoPage = pcacRiskInfoMapper.pagePcacRiskInfo(page, riskInfoReq);
        List<PcacRiskInfoResp> riskPersonResps = pcacPersonRiskSubmitInfoPage.getRecords();
        if (!CollectionUtils.isEmpty(riskPersonResps)) {
            for (PcacRiskInfoResp riskPersonResp : riskPersonResps) {
                String validStatus = (new Date().before(riskPersonResp.getValidDate())) ? CommonConst.VALIDSTATUS_01 : CommonConst.VALIDSTATUS_02;
                riskPersonResp.setValidStatus(validStatus);
                riskPersonResp.setLegDocType(LegDocTypeEnum.getLegDocTypeDesc(riskPersonResp.getLegDocType()));
                riskPersonResp.setDocType(DocTypeEnum.getDocTypeDesc(riskPersonResp.getDocType()));
                riskPersonResp.setCusType(CusTypeEnum.getCusTypeEnum(riskPersonResp.getCusType()));
                riskPersonResp.setRiskType(RiskTypeEnum.getRiskTypeDesc(riskPersonResp.getRiskType()));
                riskPersonResp.setLevel(LevelCodeEnum.getLevelDesc(riskPersonResp.getLevel()));
                riskPersonResp.setPushListType(PushListTypeEnum.getPushListTypeDesc(riskPersonResp.getPushListType()));
                SysLan sysLan = sysLanService.getLanInfoById(riskPersonResp.getOccurarea());
                if(null != sysLan){
                    riskPersonResp.setOccurarea(sysLan.getLanName());
                }
            }
        }
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        resultBean.setData(pcacPersonRiskSubmitInfoPage);
        log.info("pagePcacRiskInfo resp={}", com.alibaba.fastjson.JSON.toJSON(pcacPersonRiskSubmitInfoPage));
        return resultBean;
    }

    @Override
    public List<PcacRiskInfoDTO> listByIsBlack(String pushListType) {
        List<PcacRiskInfoDTO> pcacRiskInfoDTOs = new ArrayList<>();
        if (StringUtils.isEmpty(pushListType)) {
            pushListType = IsBlackEnum.ISBLACKE_01.getCode();
        }
        QueryWrapper<PcacRiskInfo> queryWrapper = new QueryWrapper();
        queryWrapper.eq("push_List_Type", pushListType);
        queryWrapper.eq("push_status", "0");
        List<PcacRiskInfo> pcacRiskInfos = this.list(queryWrapper);
        if (!CollectionUtils.isEmpty(pcacRiskInfos)) {
            for (PcacRiskInfo pcacRiskInfo : pcacRiskInfos) {
                PcacRiskInfoDTO pcacRiskInfoDTO = new PcacRiskInfoDTO();
                BeanUtils.copyProperties(pcacRiskInfo, pcacRiskInfoDTO);
                try {
                    String regName = new String(pcacRiskInfo.getRegName(), "UTF-8");
                    pcacRiskInfoDTO.setRegName(regName);
                    pcacRiskInfoDTO.setPcacRiskInfoId(pcacRiskInfo.getPcacRiskInfoId().toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                pcacRiskInfoDTOs.add(pcacRiskInfoDTO);
            }
        }

        return pcacRiskInfoDTOs;
    }

    @Override
    public String insertBatchPcacRiskInfo(ArrayList<PcacRiskInfo> pcacRiskInfoList) {
        pcacRiskInfoMapper.insertBatchPcacRiskInfo(pcacRiskInfoList);

        Body body = new Body();
        RespInfo respInfo = new RespInfo();
        //返回成功的状态码
        respInfo.setResultStatus("01");
        respInfo.setResultCode("S00000");
        body.setRespInfo(respInfo);
        Document document = new Document();
        Respone respone = new Respone();
        respone.setBody(body);
        String trnxCode = "";
        Head head = getRespHead(trnxCode);
        respone.setHead(head);
        document.setRespone(respone);
        String noSignXml = XmlJsonUtils.convertObjectToXmlStr(document);
        String signature = CFCACipherUtils.doSignature(noSignXml);
        document.setSignature(signature);
        String doXml = XmlJsonUtils.convertObjectToXmlStr(document);
        return doXml;

    }

    @Override
    public void updatePushStatus(List<String> ids) {
        pcacRiskInfoMapper.updatePushStatus(ids);
    }

    @Override
    public ResultBean reissueRiskInfo(ReissueRiskInfoReq reissueRiskInfoReq) {
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Head head = getResqHead(TrnxCodeEnum.RISK_INFO_REISSUE.getCode());
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac029.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac029.Body();
        BeanUtilsEx.copyProperties(body, reissueRiskInfoReq);
        log.info("请求体body参数：{}", body);
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document document = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document();
        Request request = new Request();
        request.setHead(head);
        request.setBody(body);
        document.setRequest(request);
        String noSignXml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("没加签名xml串：{}", noSignXml);
        String signature = CFCACipherUtils.doSignature(noSignXml);
        document.setSignature(signature);
        String doXml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("信息补发申请请求清算协会报文：{}", doXml);
        boolean validate = ValidateUtils.validateXMLByXSD(doXml, "pcac.ries.029");
        if (validate) {
            //String result = HttpClientUtils.sendHttpsPost("http://210.12.239.161:10001/ries_interface/httpServlet", doXml);
            String result = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), doXml);
            ResultBean resultBean = doReissueRiskInfo(result);


        } else {
            log.info("----------xsd文件校验xml格式失败-------");
            throw new SubmitPCACException(ResultCodeEnum.XSD_FILE_VALID_FALSE.getCode(), ResultCodeEnum.XSD_FILE_VALID_FALSE.getDesc());
        }

        return null;
    }

    @Override
    public List<PcacRiskInfoDTO> listAll() {
        List<PcacRiskInfoDTO> pcacRiskInfoDTOs = new ArrayList<>();
        QueryWrapper<PcacRiskInfo> queryWrapper = new QueryWrapper();
        queryWrapper.eq("push_status", "0");
        List<PcacRiskInfo> pcacRiskInfos = this.list(queryWrapper);
        if (!CollectionUtils.isEmpty(pcacRiskInfos)) {
            for (PcacRiskInfo pcacRiskInfo : pcacRiskInfos) {
                PcacRiskInfoDTO pcacRiskInfoDTO = new PcacRiskInfoDTO();
                BeanUtils.copyProperties(pcacRiskInfo, pcacRiskInfoDTO);
                try {
                    String regName = new String(pcacRiskInfo.getRegName(), "UTF-8");
                    pcacRiskInfoDTO.setRegName(regName);
                    pcacRiskInfoDTO.setPcacRiskInfoId(pcacRiskInfo.getPcacRiskInfoId().toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                pcacRiskInfoDTOs.add(pcacRiskInfoDTO);
            }
        }

        return pcacRiskInfoDTOs;
    }

    private ResultBean doReissueRiskInfo(String result) {
        log.info("信息补发申请清算协会响应xml报文：{}", result);
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document documentResp =
                (com.cmcc.paymentclean.entity.dto.pcac.resp.Document) com.cmcc.paymentclean.utils.XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class, result);
        String signatureResp = documentResp.getSignature();
        log.info("响应报文的签名串signature：{}", signatureResp);
        documentResp.setSignature(null);
        String noSignXmlResp = XmlJsonUtils.convertObjectToXmlStr(documentResp);
        log.info("不加签名信息的响应报文xml串：{}", noSignXmlResp);
        boolean isSign = CFCACipherUtils.verifySignature(noSignXmlResp, signatureResp);
        log.info("-------信息补发验证签名结果为：{}", isSign);
        Respone respone = documentResp.getRespone();
        Head respHead = respone.getHead();
        String secretKey = respHead.getSecretKey();
        Body respBody = respone.getBody();

        RespInfo respInfo = respBody.getRespInfo();
        if ("S00000".equals(respInfo.getResultCode()) && "01".equals(respInfo.getResultStatus())) {
            PcacList pcacList = respBody.getPcacList();



                if (null == pcacList || pcacList.getRiskInfo().size() == 0) {
                    return new ResultBean("该日期无需要补发数据",ResultBean.SUCCESS_CODE);
                } else {
                    QueryInfo queryInfo = respBody.getQueryInfo();
                    //这里的RiskType为申请补发类型， 01 黑名单 02 风险提示信息
                    String pushListType = queryInfo.getRiskType();

                    //补发申请成功后，为确保库里存储数据不重复，需要先将库里与补发数据相同日期的数据删除，并且还需要确认补发数据的类型相同
                    HashMap<String, String> deleteMap = new HashMap<>();
                    deleteMap.put("pushListType", pushListType);
                    deleteMap.put("reqDate", queryInfo.getReqDate());
                    if (null !=queryInfo.getReqDateEnd()) {
                        deleteMap.put("reqDateEnd", queryInfo.getReqDateEnd());
                        pcacRiskInfoMapper.deleteByDelMap(deleteMap);
                    }else
                        pcacRiskInfoMapper.deleteByDayMap(deleteMap);
                    ArrayList<PcacRiskInfo> pcacRiskInfoList = new ArrayList<>();
                    for (RiskInfo riskInfo : pcacList.getRiskInfo()) {
                        log.debug("协会补发风险信息：{}", riskInfo);
                        //对关键字进行解密，证件号码和银行卡号加密
                        //商户简称
                        String decryptCusName = CFCACipherUtils.decrypt(secretKey, riskInfo.getCusName());
                        riskInfo.setCusName(decryptCusName);
                        //商户名称
                        String decryptRegName = CFCACipherUtils.decrypt(secretKey, riskInfo.getRegName());
                        riskInfo.setRegName(decryptRegName);
                        //法人证件号码
                        String decryptDocCode = CFCACipherUtils.decrypt(secretKey, riskInfo.getDocCode());
                        riskInfo.setCusCode(decryptDocCode);
                        //法定代表人姓名
                        String decryptLegDocName = CFCACipherUtils.decrypt(secretKey, riskInfo.getLegDocName());
                        riskInfo.setLegDocName(decryptLegDocName);
                        //法定代表人证件号码
                        String decryptLegDocCode = CFCACipherUtils.decrypt(secretKey, riskInfo.getLegDocCode());
                        String encryptLegDocCode = null;
                        //判断证件类型是身份证就进行内部加密
                        if (!StringUtils.isEmpty(riskInfo.getLegDocCode()) && LegDocTypeEnum.LEGDOCTYPEENUM_01.getCode().equals(riskInfo.getLegDocType())) {
                            encryptLegDocCode = InnerCipherUtils.encryptUserData(decryptLegDocCode);
                        }
                        riskInfo.setLegDocCode(encryptLegDocCode);
                        String encryptBankNo = InnerCipherUtils.encryptBankData(riskInfo.getBankNo());
                        riskInfo.setBankNo(encryptBankNo);
                        PcacRiskInfo pcacRiskInfo = new PcacRiskInfo();
                        BeanUtilsEx.copyProperties(pcacRiskInfo, riskInfo);
                        log.debug("BeanUtilsEx.copyProperties方法封装进对象后风险信息：{}", pcacRiskInfo);
                        pcacRiskInfo.setUpDate(riskInfo.getPushDate());
                        //设置类型01为黑名单,02为风险提示信息
                        pcacRiskInfo.setPushListType(pushListType);
                        pcacRiskInfoList.add(pcacRiskInfo);


                    }
                    log.info("需要入库风险信息：{}", pcacRiskInfoList);
                    pcacRiskInfoMapper.insertBatchPcacRiskInfo(pcacRiskInfoList);
                    return new ResultBean("信息补发成功",ResultBean.SUCCESS_CODE);
                }

            }
             else {
            return new ResultBean("风险信息补发失败",ResultBean.UNSPECIFIED_CODE);
        }


    }

    /**
     * 组装响应报文头的信息
     */
    private Head getRespHead(String trnxCode) {
        Date date = new Date();
        Head head = new Head();
        head.setVersion(pcacConfig.getVersion());
        //报文唯一标识（8 位日期+10 顺序号）
        int random = new Random().nextInt(1000) + 1000;
        String identification = DateUtils.formatTime(date, "yyyyMMdd") + "100000" + random;
        head.setIdentification(identification);
        //收单机构收单机构机构号（字母、数字、下划线）
        head.setOrigSender(pcacConfig.getOrigSender());
        //收单机构收单机构发送系统号（字母、数字、下划线）
        head.setOrigSenderSID(pcacConfig.getOrigSenderSid());
        //协会系统编号， 特约商户信息上报和删除请求时填 SECB01，其余均为 R0001
        head.setRecSystemId("R0001");
        //交易码，见 5.1 报文分类列表（数字、字母）-----黑名单推送响应TrnxCode为空
        head.setTrnxCode(trnxCode);
        String trnxTime = DateUtils.formatTime(date, "yyyyMMddHHmmss");
        head.setTrnxTime(trnxTime);
        head.setSecretKey("");
        return head;
    }

    /**
     * 组装请求报文头的信息
     */
    private com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Head getResqHead(String trnxCode) {
        //没有需要加密的字段，但是xsd文件校验secretKey长度必须大于1
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        String secretKey = CFCACipherUtils.getSecretKey(symmetricKeyEncoded);
        Date date = new Date();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Head head = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Head();
        head.setVersion(pcacConfig.getVersion());
        //报文唯一标识（8 位日期+10 顺序号）
        int random = new Random().nextInt(1000) + 1000;
        String identification = DateUtils.formatTime(date, "yyyyMMdd") + "100000" + random;
        head.setIdentification(identification);
        //收单机构收单机构机构号（字母、数字、下划线）
        head.setOrigSender(pcacConfig.getOrigSender());
        //收单机构收单机构发送系统号（字母、数字、下划线）
        head.setOrigSenderSID(pcacConfig.getOrigSenderSid());
        //协会系统编号， 特约商户信息上报和删除请求时填 SECB01，其余均为 R0001
        head.setRecSystemId("R0001");
        //交易码，见 5.1 报文分类列表（数字、字母）-----黑名单推送响应TrnxCode为空
        head.setTrnxCode(trnxCode);
        String trnxTime = DateUtils.formatTime(date, "yyyyMMddHHmmss");
        head.setTrnxTime(trnxTime);
        head.setUserToken(pcacConfig.getUserToken());
        //head.setSecretKey("");
        head.setSecretKey(secretKey);
        return head;
    }

}
