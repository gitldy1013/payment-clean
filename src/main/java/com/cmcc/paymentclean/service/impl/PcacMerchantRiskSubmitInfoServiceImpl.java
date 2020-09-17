package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.MsgDetailEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.SubmitStatusEnum;
import com.cmcc.paymentclean.entity.PcacMerchantRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resq.BankInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.BankList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.BenInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.BenList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Request;
import com.cmcc.paymentclean.entity.dto.pcac.resq.RiskInfo;
import com.cmcc.paymentclean.entity.dto.response.RiskMerchantResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantReq;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.PcacMerchantRiskSubmitInfoMapper;
import com.cmcc.paymentclean.service.PcacMerchantRiskSubmitInfoService;
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

    @Override
    public Page<PcacMerchantRiskSubmitInfo> listPcacMerchantRiskSubmitInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询pcacMerchantRiskSubmitInfo: page = {} pageSize = {} factor = {}", page, pageSize, factor);
        QueryWrapper<PcacMerchantRiskSubmitInfo> queryWrapper = new QueryWrapper<PcacMerchantRiskSubmitInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<PcacMerchantRiskSubmitInfo> result = super.page(new Page<PcacMerchantRiskSubmitInfo>(page, pageSize), queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询pcacMerchantRiskSubmitInfo完毕: 结果数 = {} ", result.getRecords().size());
        return result;
    }

    @Override
    public PcacMerchantRiskSubmitInfo getPcacMerchantRiskSubmitInfoById(int id) {
        log.info("正在查询pcacMerchantRiskSubmitInfo中id为{}的数据", id);
        PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo = super.getById(id);
        log.info("查询id为{}的pcacMerchantRiskSubmitInfo{}", id, (null == pcacMerchantRiskSubmitInfo ? "无结果" : "成功"));
        return pcacMerchantRiskSubmitInfo;
    }

    @Override
    public int insertPcacMerchantRiskSubmitInfo(PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo) {
        log.info("正在插入pcacMerchantRiskSubmitInfo");
        if (super.save(pcacMerchantRiskSubmitInfo)) {
            log.info("插入pcacMerchantRiskSubmitInfo成功,id为{}", pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId());
            return pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId();
        } else {
            log.error("插入pcacMerchantRiskSubmitInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deletePcacMerchantRiskSubmitInfoById(int id) {
        log.info("正在删除id为{}的pcacMerchantRiskSubmitInfo", id);
        if (super.removeById(id)) {
            log.info("删除id为{}的pcacMerchantRiskSubmitInfo成功", id);
            return id;
        } else {
            log.error("删除id为{}的pcacMerchantRiskSubmitInfo失败", id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updatePcacMerchantRiskSubmitInfo(PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo) {
        log.info("正在更新id为{}的pcacMerchantRiskSubmitInfo", pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId());
        if (super.updateById(pcacMerchantRiskSubmitInfo)) {
            log.info("更新d为{}的pcacMerchantRiskSubmitInfo成功", pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId());
            return pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId();
        } else {
            log.error("更新id为{}的pcacMerchantRiskSubmitInfo失败", pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId());
            throw new BizException("更新失败[id=" + pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId() + "]");
        }
    }

    @Autowired
    private PcacMerchantRiskSubmitInfoMapper pcacMerchantRiskSubmitInfoMapper;

    @Autowired
    private PcacConfig pcacConfig;

    @Override
    public ResultBean<Page<RiskMerchantResp>> pageRiskMerchant(RiskMerchantReq riskMerchantReq) {
        ResultBean<Page<RiskMerchantResp>> resultBean = new ResultBean();
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
            }
        }
        resultBean.setData(pagePcacMerchantRiskSubmitInfo);
        return resultBean;
    }

    @Override
    public void queryRiskMerchantAndPushPcac() {
        //获取未上报的数据
        QueryWrapper<PcacMerchantRiskSubmitInfo> queryWrapper = new QueryWrapper<PcacMerchantRiskSubmitInfo>().like("msg_detail", MsgDetailEnum.MSGDETAILENUM_00.getDesc());
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
        log.info("请求报文: {}",XmlJsonUtils.formatXml(xml));
         boolean validate = ValidateUtils.validateXML(xml, "pcac.ries.013");
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
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document doc = (com.cmcc.paymentclean.entity.dto.pcac.resp.Document) XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class, post);
        log.info("协会返回数据对象:{}", doc);
        for (PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo : pcacMerchantRiskSubmitInfos) {
            UpdateWrapper<PcacMerchantRiskSubmitInfo> updateWrapper = new UpdateWrapper<PcacMerchantRiskSubmitInfo>().set("msg_detail", doc.getRespone().getBody().getRespInfo().getMsgDetail());
            //pcacMerchantRiskSubmitInfoMapper.update(pcacMerchantRiskSubmitInfo, updateWrapper);
        }
    }

    private Document getDocument(List<PcacMerchantRiskSubmitInfo> pcacMerchantRiskSubmitInfos) {
        //拼装报文
        Document document = new Document();
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        //设置报文头
        Request request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig,"ER0001");
        //设置报文体
        Body body = new Body();
        PcacList pcacList = new PcacList();
        ArrayList<RiskInfo> riskInfos = new ArrayList<RiskInfo>();
        for (int i = 0; i < pcacMerchantRiskSubmitInfos.size(); i++) {
            pcacList.setCount(pcacMerchantRiskSubmitInfos.size());
            RiskInfo riskInfo = new RiskInfo();
            PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo = pcacMerchantRiskSubmitInfos.get(i);
            BeanUtilsEx.copyProperties(riskInfo, pcacMerchantRiskSubmitInfo);
            BankList bankList = new BankList();
            BankInfo bankInfo = new BankInfo();
            BeanUtilsEx.copyProperties(bankInfo, pcacMerchantRiskSubmitInfo);
            //银行结算账号
            bankInfo.setBankNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, bankInfo.getBankNo()));
            //log.info("解密：{}",CFCACipherUtils.decrypt(symmetricKeyEncoded,bankInfo.getBankNo()));
            bankList.setBankInfo(bankInfo);
            riskInfo.setBankList(bankList);
            riskInfo.setRepDate(DateUtils.formatTime(new Date(System.currentTimeMillis()), null));
            BenList benList = new BenList();
            BenInfo benInfo = new BenInfo();
            BeanUtilsEx.copyProperties(benInfo, pcacMerchantRiskSubmitInfo);
            benList.setBenInfo(benInfo);
            riskInfo.setBankNo(null);
            riskInfo.setOpenBank(null);
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
            riskInfo.setUrl(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getUrl()+"1"));
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
        document.setRequest(request);
        request.setBody(body);
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        //加签
        String doSignature = CFCACipherUtils.doSignature(xml);
        document.setSignature(doSignature);
        return document;
    }

}
