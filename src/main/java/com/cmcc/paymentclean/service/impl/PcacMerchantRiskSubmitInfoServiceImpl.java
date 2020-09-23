package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.CusNatureEnum;
import com.cmcc.paymentclean.consts.CusPropertyEnum;
import com.cmcc.paymentclean.consts.CusTypeEnum;
import com.cmcc.paymentclean.consts.DocTypeEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.LevelCodeEnum;
import com.cmcc.paymentclean.consts.MsgTypeEnum;
import com.cmcc.paymentclean.consts.PcacResultCode;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.RiskTypeEnum;
import com.cmcc.paymentclean.consts.SourChaEnum;
import com.cmcc.paymentclean.consts.SubmitStatusEnum;
import com.cmcc.paymentclean.entity.PcacMerchantRiskSubmitInfo;
import com.cmcc.paymentclean.entity.SysLan;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.BankInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.BankList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.BenInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.BenList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac013.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.entity.dto.response.RiskMerchantResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantReq;
import com.cmcc.paymentclean.mapper.PcacMerchantRiskSubmitInfoMapper;
import com.cmcc.paymentclean.service.PcacMerchantRiskSubmitInfoService;
import com.cmcc.paymentclean.service.SysLanService;
import com.cmcc.paymentclean.utils.BeanUtilsEx;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 协会商户风险信息上报表  服务实现类
 * </p>
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Slf4j
@Service
public class PcacMerchantRiskSubmitInfoServiceImpl extends ServiceImpl<PcacMerchantRiskSubmitInfoMapper, PcacMerchantRiskSubmitInfo> implements PcacMerchantRiskSubmitInfoService {

    @Autowired
    private PcacMerchantRiskSubmitInfoMapper pcacMerchantRiskSubmitInfoMapper;

    @Autowired
    private PcacConfig pcacConfig;

    @Autowired
    private SysLanService sysLanService;

    @Override
    public ResultBean<Page<RiskMerchantResp>> pageRiskMerchant(RiskMerchantReq riskMerchantReq) {
        log.info("pageRiskMerchant req={}", com.alibaba.fastjson.JSON.toJSON(riskMerchantReq));
        ResultBean<Page<RiskMerchantResp>> resultBean = new ResultBean<>();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());

        Page<PcacMerchantRiskSubmitInfo> page = new Page<>(riskMerchantReq.getPageNo(), riskMerchantReq.getPageSize());
        Page<RiskMerchantResp> pagePcacMerchantRiskSubmitInfo = pcacMerchantRiskSubmitInfoMapper.pagePcacMerchantRiskSubmitInfo(page, riskMerchantReq);
        List<RiskMerchantResp> riskMerchantResps = pagePcacMerchantRiskSubmitInfo.getRecords();
        if (!CollectionUtils.isEmpty(riskMerchantResps)) {
            for (RiskMerchantResp riskMerchantResp : riskMerchantResps) {
                String validStatus = (new Date(System.currentTimeMillis()).before(riskMerchantResp.getValidDate())) ? CommonConst.VALIDSTATUS_01 : CommonConst.VALIDSTATUS_02;
                riskMerchantResp.setValidStatus(validStatus);
                riskMerchantResp.setLegDocType(LegDocTypeEnum.getLegDocTypeDesc(riskMerchantResp.getLegDocType()));
                riskMerchantResp.setSubmitStatus(SubmitStatusEnum.getSubmitStatusEnumDesc(riskMerchantResp.getSubmitStatus()));
                riskMerchantResp.setCusType(CusTypeEnum.getCusTypeEnum(riskMerchantResp.getCusType()));
                riskMerchantResp.setCusNature(CusNatureEnum.getCusNatureEnum(riskMerchantResp.getCusNature()));
                riskMerchantResp.setSourceChannel(SourChaEnum.getSourChaEnum(riskMerchantResp.getSourceChannel()));
                riskMerchantResp.setLevel(LevelCodeEnum.getLevelDesc(riskMerchantResp.getLevel()));
                riskMerchantResp.setDocType(DocTypeEnum.getDocTypeDesc(riskMerchantResp.getDocType()));
                riskMerchantResp.setRiskType(RiskTypeEnum.getRiskTypeDesc(riskMerchantResp.getRiskType()));
                riskMerchantResp.setCusProperty(CusPropertyEnum.getCusPropertyEnum(riskMerchantResp.getCusProperty()));
                riskMerchantResp.setMsgType(MsgTypeEnum.MsgTypeEnum_02.getDesc());
                SysLan sysLan = sysLanService.getLanInfoById(riskMerchantResp.getOccurarea());
                if (null != sysLan) {
                    riskMerchantResp.setOccurarea(sysLan.getLanName());
                }
            }
        }
        resultBean.setData(pagePcacMerchantRiskSubmitInfo);
        log.info("pageRiskMerchant resp={}", com.alibaba.fastjson.JSON.toJSON(pagePcacMerchantRiskSubmitInfo));
        return resultBean;
    }

    @Override
    public void queryRiskMerchantAndPushPcac() {
        //获取未上报的数据
        QueryWrapper<PcacMerchantRiskSubmitInfo> queryWrapper = new QueryWrapper<PcacMerchantRiskSubmitInfo>().like("submit_status", SubmitStatusEnum.ISBLACKENUM_0.getCode());
        List<PcacMerchantRiskSubmitInfo> pcacMerchantRiskSubmitInfos = pcacMerchantRiskSubmitInfoMapper.selectList(queryWrapper);
        if (pcacMerchantRiskSubmitInfos.size() == 0) {
            log.info("当前没有可上报的风险商户信息");
            return;
        }
        Document document = getDocument(pcacMerchantRiskSubmitInfos);
        //报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("获取到的xml数据:{}", xml);
        if (StringUtils.isEmpty(xml)) {
            log.info("xml报文转换失败");
            return;
        }
        //校验xml报文
//        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries.013");
        log.info("请求报文: {}", XmlJsonUtils.formatXml(xml));
        boolean validate = ValidateUtils.validateXML(XmlJsonUtils.formatXml(xml), "pcac.ries.013");
        if (!validate) {
            log.info("XML校验失败");
            return;
        }
        pushToPcac(pcacMerchantRiskSubmitInfos, xml);
    }

    private void pushToPcac(List<PcacMerchantRiskSubmitInfo> pcacMerchantRiskSubmitInfos, String xml) {
        //上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("url:{}", pcacConfig.getUrl());
        log.info("协会返回数据字符串:{}", XmlJsonUtils.formatXml(post));
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document doc = (com.cmcc.paymentclean.entity.dto.pcac.resp.Document) XmlJsonUtils.convertXmlStrToObject(post, com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class);
        log.info("协会返回数据对象:{}", doc);
        if (doc.getRespone().getBody().getRespInfo().getResultCode().equals(PcacResultCode.S00000.getCode())) {
            for (PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo : pcacMerchantRiskSubmitInfos) {
                UpdateWrapper<PcacMerchantRiskSubmitInfo> updateWrapper = new UpdateWrapper<PcacMerchantRiskSubmitInfo>().set("msg_detail", doc.getRespone().getBody().getRespInfo().getMsgDetail());
                updateWrapper.set("submit_status", SubmitStatusEnum.ISBLACKENUM_1.getCode());
                pcacMerchantRiskSubmitInfoMapper.update(pcacMerchantRiskSubmitInfo, updateWrapper);
            }
        } else {
            log.info("返回状态码及信息：{}:{}", doc.getRespone().getBody().getRespInfo().getResultCode(), doc.getRespone().getBody().getRespInfo().getMsgDetail());
        }
    }

    private Document getDocument(List<PcacMerchantRiskSubmitInfo> pcacMerchantRiskSubmitInfos) {
        //拼装报文
        Document document = new Document();
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        //设置报文头
        Request request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig, "ER0001");
        //设置报文体
        Body body = new Body();
        PcacList pcacList = new PcacList();
        ArrayList<RiskInfo> riskInfos = new ArrayList<RiskInfo>();
        for (int i = 0; i < pcacMerchantRiskSubmitInfos.size(); i++) {
            pcacList.setCount(pcacMerchantRiskSubmitInfos.size() + "");
            RiskInfo riskInfo = new RiskInfo();
            PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo = pcacMerchantRiskSubmitInfos.get(i);
            BeanUtilsEx.copyProperties(riskInfo, pcacMerchantRiskSubmitInfo);
            BankList bankList = new BankList();
            List<BankInfo> bankInfos = new ArrayList<BankInfo>();
            BankInfo bankInfo = new BankInfo();
            BeanUtilsEx.copyProperties(bankInfo, pcacMerchantRiskSubmitInfo);
            //银行结算账号
            bankInfo.setBankNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, bankInfo.getBankNo()));
            //log.info("解密：{}",CFCACipherUtils.decrypt(symmetricKeyEncoded,bankInfo.getBankNo()));
            bankInfos.add(bankInfo);
            bankList.setBankInfo(bankInfos);
            riskInfo.setBankList(bankList);
            riskInfo.setRepDate(DateUtils.formatTime(new Date(System.currentTimeMillis()), null));
            BenList benList = new BenList();
            List<BenInfo> benInfos = new ArrayList<>();
            BenInfo benInfo = new BenInfo();
            BeanUtilsEx.copyProperties(benInfo, pcacMerchantRiskSubmitInfo);
            benInfos.add(benInfo);
            benList.setBenInfo(benInfos);
            //解密风控加密协会 商户上报：
            //商户名称
            riskInfo.setRegName(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getRegName()));
            //商户简称
            riskInfo.setCusName(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getCusName()));
            //商户代码
            riskInfo.setCusCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getCusCode()));
            //法人证件号码
            riskInfo.setDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getDocCode()));
            //法定代表人姓名/负责人姓名
            riskInfo.setLegRepName(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getLegRepName()));
            //法定代表人（负责人）证件号码
            riskInfo.setLegDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getLegDocCode()));
            //法定代表人（负责人）手机号
            riskInfo.setMobileNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getMobileNo()));
            //网址
            riskInfo.setUrl(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getUrl() + "1"));
            //服务器 ip
            riskInfo.setServerIp(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getServerIp()));
            //ICP 备案编号
            riskInfo.setIcp(CFCACipherUtils.encrypt(symmetricKeyEncoded, pcacMerchantRiskSubmitInfo.getRegName()));
            riskInfo.setDocCode(CFCACipherUtils.getInnerToCFCA(pcacMerchantRiskSubmitInfo.getDocType(), pcacMerchantRiskSubmitInfo.getDocCode(), symmetricKeyEncoded));
            //实控人证件号
            riskInfo.setLegControlCardCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getLegControlCardCode()));
            //商户注册号
            riskInfo.setRegisteredCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getRegisteredCode()));
            riskInfo.setBenList(benList);
            riskInfos.add(riskInfo);
            pcacList.setRiskInfo(riskInfos);
        }
        body.setPcacList(pcacList);
        request.setBody(body);
        document.setRequest(request);
        XmlJsonUtils.doSignature(document);
        return document;
    }

    private String splitStrs(String strings) {
        if (StringUtils.isEmpty(strings)) {
            return strings;
        }
        String[] strs = strings.split("\\|");
        return strs[0];
    }
}
