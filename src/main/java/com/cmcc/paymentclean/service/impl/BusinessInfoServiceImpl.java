package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.config.SftpConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.BusinessInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resp.RespInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Respone;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac025.BaseInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac025.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.BlackList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.Condition;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.ConditionList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.CurSignList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.HisSignList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.LegBlackList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.LegWarningList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.ResultCondition;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.ResultInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.WarningList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.entity.dto.response.BusinessInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.BusinessInfoReq;
import com.cmcc.paymentclean.mapper.BusinessInfoMapper;
import com.cmcc.paymentclean.service.BusinessInfoService;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.ExcelUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.SFTPUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 企业商户信息表  服务实现类
 * </p>
 *
 * @author cmcc
 * @since 2020-09-15
 */
@Slf4j
@Service
public class BusinessInfoServiceImpl extends ServiceImpl<BusinessInfoMapper, BusinessInfo> implements BusinessInfoService {

    @Autowired
    private SftpConfig sftpConfig;

    @Autowired
    private PcacConfig pcacConfig;

    @Autowired
    private BusinessInfoMapper businessInfoMapper;

    @Override
    public ResultBean<Body> exportExcel() {
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        //查出未推送数据
        List<BusinessInfoResp> businessInfoResps = businessInfoMapper.qryByPushStatus("0");
        if (CollectionUtils.isEmpty(businessInfoResps)) {
            return resultBean;
        }
        List<String> stringList = new ArrayList<>();
        for (BusinessInfoResp businessInfoResp : businessInfoResps) {
            stringList.add(businessInfoResp.getBusinessInfoId());
        }

        //生成excel文件
        ExcelUtils excelUtils = new ExcelUtils();
        String fileName = sftpConfig.getBusinessInfoFileNamePrefix() + System.currentTimeMillis() + CommonConst.SFTP_FILE_NAME_SUFFIX;
        try {
            //文件名
            SXSSFWorkbook sxssfWorkbook = excelUtils.exportExcel(businessInfoResps, BusinessInfoResp.class);
            FileOutputStream fos = new FileOutputStream(sftpConfig.getModDir() + fileName);
            sxssfWorkbook.write(fos);
            // dispose of temporary files backing this workbook on disk -> 处理SXSSFWorkbook导出excel时，产生的临时文件
            sxssfWorkbook.dispose();
            fos.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        //上传文件
        SFTPUtils.operateSFTP(sftpConfig.getUsername(), sftpConfig.getHost(), sftpConfig.getPort(), sftpConfig.getPassword(),
                sftpConfig.getRemotePathUpload(), fileName, sftpConfig.getModDir(), fileName, SFTPUtils.OPERATE_UPLOAD);
        //更新状态为推送
        businessInfoMapper.updatePushStatus(stringList);
        return resultBean;
    }

    @Override
    public void queryBusinessInfoAndPushPcac() {
        //获取未上报的数据
        QueryWrapper<BusinessInfo> queryWrapper = new QueryWrapper<BusinessInfo>().like("submit_status", "0");
        List<BusinessInfo> businessInfos = businessInfoMapper.selectList(queryWrapper);
        if (businessInfos.size() == 0) {
            log.info("当前没有可上报的企业商户信息");
            return;
        }
        Document document = getDocument(businessInfos);
        //报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("获取到的xml数据:{}", xml);
        if (StringUtils.isEmpty(xml)) {
            log.info("xml报文转换失败");
            return;
        }
        //校验xml报文  企业商户信息上报请求
        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries.025");
        if (!validate) {
            log.info("XML校验失败");
            return;
        }
        pushToPcac(businessInfos, xml);
    }

    @Override
    public ResultBean batchQuery(List<BusinessInfoReq> businessInfoReqs) {
        ResultBean resultBean = new ResultBean();
        if (CollectionUtils.isEmpty(businessInfoReqs)) {
            resultBean.setResCode(ResultCodeEnum.ERROR.getCode());
            resultBean.setResMsg(ResultCodeEnum.ERROR.getDesc());
            resultBean.setData("入参为空");
            return resultBean;
        }
        for (BusinessInfoReq businessInfoReq : businessInfoReqs) {
            if ((StringUtils.isNotEmpty(businessInfoReq.getDocCode()) && StringUtils.isNotEmpty(businessInfoReq.getRegName()))) {
                continue;
            } else if (StringUtils.isNotEmpty(businessInfoReq.getLegDocCode()) && StringUtils.isNotEmpty(businessInfoReq.getLegDocType())) {
                continue;
            } else {
                resultBean.setResCode(ResultCodeEnum.ERROR.getCode());
                resultBean.setResMsg(ResultCodeEnum.ERROR.getDesc());
                resultBean.setData("查询条件组合中选择一种进行查询：企业商户法人名称;法人证件号码;法定代表人（负责人）证件号码+法定代表人姓名");
                return resultBean;
            }
        }
        Document document = this.getDocumentByQuery(businessInfoReqs);
        //报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("获取到的xml数据:{}", xml);
        if (StringUtils.isEmpty(xml)) {
            log.info("xml报文转换失败");
            resultBean.setResCode(ResultCodeEnum.ERROR.getCode());
            resultBean.setResMsg(ResultCodeEnum.ERROR.getDesc());
            resultBean.setData("xml报文转换失败");
            return resultBean;
        }
        //校验xml报文  企业商户信息上报请求
        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries.044");
        if (!validate) {
            log.info("XML校验失败");
            resultBean.setResCode(ResultCodeEnum.ERROR.getCode());
            resultBean.setResMsg(ResultCodeEnum.ERROR.getDesc());
            resultBean.setData("XML校验失败");
            return resultBean;
        }
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document resDoc = this.pushToPcacByQuery(xml);
        Respone respone = resDoc.getRespone();
        Body resBody = respone.getBody();
        resultBean.setData(resBody);
        resultBean.setResCode(resBody.getRespInfo().getResultCode());
        if (resBody.getRespInfo().getMsgDetail().isEmpty()) {
            resultBean.setResMsg(resBody.getRespInfo().getResultStatus());
        } else {
            resultBean.setResMsg(resBody.getRespInfo().getMsgDetail());
        }
        return resultBean;
    }

    private void pushToPcac(List<BusinessInfo> businessInfos, String xml) {
        //上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("url:{}", pcacConfig.getUrl());
            /*String post = "<Body>\n" +
                    "    <RespInfo>\n" +
                    "        <ResultStatus>已上报</ResultStatus>\n" +
                    "        <ResultCode>01</ResultCode>\n" +
                    "    </RespInfo>\n" +
                    "</Body>";*/
        com.cmcc.paymentclean.entity.dto.pcac.resp.Body resBody = (com.cmcc.paymentclean.entity.dto.pcac.resp.Body) XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resp.Body.class, post);
        log.info("协会返回数据对象:{}", resBody);
        for (BusinessInfo pcacMerchantRiskSubmitInfo : businessInfos) {
            UpdateWrapper<BusinessInfo> updateWrapper = new UpdateWrapper<BusinessInfo>();
            updateWrapper.eq("submit_status", "1");
            updateWrapper.eq("rep_date", new Date());
            updateWrapper.eq("result_status", resBody.getRespInfo().getResultStatus());
            updateWrapper.eq("result_code", resBody.getRespInfo().getResultCode());
            businessInfoMapper.update(pcacMerchantRiskSubmitInfo, updateWrapper);
        }
    }

    private Document getDocument(List<BusinessInfo> businessInfos) {
        //拼装报文
        Document document = new Document();
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        //设置报文头
        Request request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig, "");
        //设置报文体
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac025.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac025.Body();
        PcacList pcacList = new PcacList();
        for (int i = 0; i < businessInfos.size(); i++) {
            pcacList.setCount(businessInfos.size() + "");
            ArrayList<BaseInfo> baseInfos = new ArrayList<BaseInfo>();
            BaseInfo baseInfo = new BaseInfo();
            BusinessInfo businessInfo = businessInfos.get(i);
            BeanUtils.copyProperties(businessInfo, baseInfo);
            baseInfo.setRepDate(DateUtils.formatTime(new Date(System.currentTimeMillis()), null));
            baseInfo.setBankNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, businessInfo.getBankNo()));

            //解密风控加密协会 商户上报：
            //商户名称
            baseInfo.setRegName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getRegName()));
            //商户简称
            baseInfo.setCusName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getCusName()));
            //商户代码
            baseInfo.setCusCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getCusCode()));
            //法人证件号码
            baseInfo.setDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getDocCode()));
            //法定代表人姓名/负责人姓名
            baseInfo.setLegDocName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getLegDocName()));
            //法定代表人（负责人）证件号码
            baseInfo.setLegDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getLegDocCode()));
            //外包服务机构法定代表人证件号码"
            baseInfo.setOutServiceLegCardCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getOutServiceLegCardCode()));
            //外包服务机构法人证件号码
            baseInfo.setOutServiceCardCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getOutServiceCardCode()));
            //商户联系人
            baseInfo.setContName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getContName()));
            //商户联系电话
            baseInfo.setContPhone(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getContPhone()));
            //网址
            baseInfo.setUrl(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getUrl()));
            //服务器 ip
            baseInfo.setServerIp(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getServerIp()));
            //ICP 备案编号
            baseInfo.setIcp(CFCACipherUtils.encrypt(symmetricKeyEncoded, businessInfo.getRegName()));
            baseInfo.setDocCode(CFCACipherUtils.getInnerToCFCA(businessInfo.getDocType(), businessInfo.getDocCode(), symmetricKeyEncoded));
            baseInfos.add(baseInfo);
            pcacList.setBaseInfo(baseInfos);
        }
        body.setPcacList(pcacList);
        request.setBody(body);
        document.setRequest(request);
        return document;
    }

    private Document getDocumentByQuery(List<BusinessInfoReq> businessInfoReqs) {
        //拼装报文
        Document document = new Document();
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        //设置报文头
        Request request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig, "");
        //设置报文体
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.Body body = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.Body();
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.PcacList pcacList = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.PcacList();
        for (int i = 0; i < businessInfoReqs.size(); i++) {
            pcacList.setCount(businessInfoReqs.size() + "");
            ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.BaseInfo> baseInfos = new ArrayList<com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.BaseInfo>();
            com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.BaseInfo baseInfo = new com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac044.BaseInfo();
            BusinessInfoReq businessInfo = businessInfoReqs.get(i);
            BeanUtils.copyProperties(businessInfo, baseInfo);
            if (StringUtils.isNotEmpty(businessInfo.getDocCode())) {
                //法人证件号码
                baseInfo.setDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getDocCode()));
            } else if (StringUtils.isNotEmpty(businessInfo.getRegName())) {
                //商户名称
                baseInfo.setRegName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getRegName()));
            } else {
                //法定代表人姓名/负责人姓名
                baseInfo.setLegDocName(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getLegDocName()));
                //法定代表人（负责人）证件号码
                baseInfo.setLegDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, baseInfo.getLegDocCode()));
            }

            baseInfos.add(baseInfo);
            pcacList.setBaseInfo(baseInfos);
        }
        body.setPcacList(pcacList);
        request.setBody(body);
        document.setRequest(request);
        return document;
    }

    private com.cmcc.paymentclean.entity.dto.pcac.resp.Document pushToPcacByQuery(String xml) {
        //上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("url:{}", pcacConfig.getUrl());
            /*String post = "<Body>\n" +
                    "    <RespInfo>\n" +
                    "        <ResultStatus>已上报</ResultStatus>\n" +
                    "        <ResultCode>01</ResultCode>\n" +
                    "    </RespInfo>\n" +
                    "</Body>";*/
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document resDoc = (com.cmcc.paymentclean.entity.dto.pcac.resp.Document) XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resp.Body.class, post);
        log.info("协会返回数据对象:{}", resDoc);
        return resDoc;
    }

    @Override
    public ResultBean<?> getBusinessInfoXML(String xml) {
        log.info("接收的xml:{}", xml);
        com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.Body resBody = (com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.Body) XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.Body.class, xml);
        ConditionList conditionLists = resBody.getConditionList();
        if (conditionLists != null) {
            List<Condition> conditions = conditionLists.getCondition();
            for (int i = 0; i < conditions.size(); i++) {
                Condition condition = conditions.get(i);
                //返回记录总数
                int count = Integer.valueOf(condition.getCount());
                ResultCondition resultCondition = condition.getResultCondition();
                List<ResultInfo> resultInfos = resultCondition.getResultInfo();
                ResultInfo resultInfo = resultInfos.get(i);
                com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.BaseInfo baseInfo = resultInfo.getBaseInfo();
                //待补充落表逻辑
                List<HisSignList> hisSignList = resultInfo.getHisSignList();
                List<CurSignList> curSignList = resultInfo.getCurSignList();
                List<BlackList> blackList = resultInfo.getBlackList();
                List<WarningList> warningList = resultInfo.getWarningList();
                List<LegBlackList> legBlackList = resultInfo.getLegBlackList();
                List<LegWarningList> legWarningList = resultInfo.getLegWarningList();
                SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
                String fileName = sftpConfig.getBusinessInfoFileNamePrefix() + "Back_" + System.currentTimeMillis() + CommonConst.SFTP_FILE_NAME_SUFFIX;
                try {
                    //文件名
                    sxssfWorkbook = this.getSxssfWorkbook(sxssfWorkbook, "BaseInfo", Lists.newArrayList(baseInfo), BaseInfo.class);
                    sxssfWorkbook = this.getSxssfWorkbook(sxssfWorkbook, "HisSignList", hisSignList, HisSignList.class);
                    sxssfWorkbook = this.getSxssfWorkbook(sxssfWorkbook, "HisSignList", curSignList, CurSignList.class);
                    sxssfWorkbook = this.getSxssfWorkbook(sxssfWorkbook, "HisSignList", blackList, BlackList.class);
                    sxssfWorkbook = this.getSxssfWorkbook(sxssfWorkbook, "HisSignList", warningList, WarningList.class);
                    sxssfWorkbook = this.getSxssfWorkbook(sxssfWorkbook, "HisSignList", legBlackList, LegBlackList.class);
                    sxssfWorkbook = this.getSxssfWorkbook(sxssfWorkbook, "LegWarningList", legWarningList, LegWarningList.class);
                    FileOutputStream fos = new FileOutputStream(sftpConfig.getModDir() + fileName);
                    sxssfWorkbook.write(fos);
                    sxssfWorkbook.dispose();
                    fos.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        ResultBean resultBean = new ResultBean();

        com.cmcc.paymentclean.entity.dto.pcac.resp.Body respBody = new com.cmcc.paymentclean.entity.dto.pcac.resp.Body();
        RespInfo respInfo = new RespInfo();
        respInfo.setResultCode("01");
        respInfo.setResultStatus("已接收");
        respBody.setRespInfo(respInfo);
        return resultBean;
    }

    private SXSSFWorkbook getSxssfWorkbook(SXSSFWorkbook sxssfWorkbook, String sheetName, List list, Class c) {
        ExcelUtils excelUtils = new ExcelUtils();
        Sheet sheet = sxssfWorkbook.createSheet(sheetName);
        try {
            sxssfWorkbook = excelUtils.exportExcelAppointSheet(sxssfWorkbook, sheet, list, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sxssfWorkbook;
    }
}
