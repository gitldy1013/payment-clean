package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.SubmitStatusEnum;
import com.cmcc.paymentclean.entity.PcacEnterpriseRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resq.BankInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.BankList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.BenInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.BenList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Head;
import com.cmcc.paymentclean.entity.dto.pcac.resq.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Request;
import com.cmcc.paymentclean.entity.dto.pcac.resq.RiskInfo;
import com.cmcc.paymentclean.entity.dto.response.RiskEnterpriseResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskEnterpriseReq;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.PcacEnterpriseRiskSubmitInfoMapper;
import com.cmcc.paymentclean.service.PcacEnterpriseRiskSubmitInfoService;
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
 * 协会企业风险信息上报表  服务实现类
 * </p>
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Slf4j
@Service
public class PcacEnterpriseRiskSubmitInfoServiceImpl extends ServiceImpl<PcacEnterpriseRiskSubmitInfoMapper, PcacEnterpriseRiskSubmitInfo> implements PcacEnterpriseRiskSubmitInfoService {

    @Override
    public Page<PcacEnterpriseRiskSubmitInfo> listPcacEnterpriseRiskSubmitInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询pcacEnterpriseRiskSubmitInfo: page = {} pageSize = {} factor = {}", page, pageSize, factor);
        QueryWrapper<PcacEnterpriseRiskSubmitInfo> queryWrapper = new QueryWrapper<PcacEnterpriseRiskSubmitInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<PcacEnterpriseRiskSubmitInfo> result = super.page(new Page<PcacEnterpriseRiskSubmitInfo>(page, pageSize), queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询pcacEnterpriseRiskSubmitInfo完毕: 结果数 = {} ", result.getRecords().size());
        return result;
    }

    @Override
    public PcacEnterpriseRiskSubmitInfo getPcacEnterpriseRiskSubmitInfoById(int id) {
        log.info("正在查询pcacEnterpriseRiskSubmitInfo中id为{}的数据", id);
        PcacEnterpriseRiskSubmitInfo pcacEnterpriseRiskSubmitInfo = super.getById(id);
        log.info("查询id为{}的pcacEnterpriseRiskSubmitInfo{}", id, (null == pcacEnterpriseRiskSubmitInfo ? "无结果" : "成功"));
        return pcacEnterpriseRiskSubmitInfo;
    }

    @Override
    public int insertPcacEnterpriseRiskSubmitInfo(PcacEnterpriseRiskSubmitInfo pcacEnterpriseRiskSubmitInfo) {
        log.info("正在插入pcacEnterpriseRiskSubmitInfo");
        if (super.save(pcacEnterpriseRiskSubmitInfo)) {
            log.info("插入pcacEnterpriseRiskSubmitInfo成功,id为{}", pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId());
            return pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId();
        } else {
            log.error("插入pcacEnterpriseRiskSubmitInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deletePcacEnterpriseRiskSubmitInfoById(int id) {
        log.info("正在删除id为{}的pcacEnterpriseRiskSubmitInfo", id);
        if (super.removeById(id)) {
            log.info("删除id为{}的pcacEnterpriseRiskSubmitInfo成功", id);
            return id;
        } else {
            log.error("删除id为{}的pcacEnterpriseRiskSubmitInfo失败", id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updatePcacEnterpriseRiskSubmitInfo(PcacEnterpriseRiskSubmitInfo pcacEnterpriseRiskSubmitInfo) {
        log.info("正在更新id为{}的pcacEnterpriseRiskSubmitInfo", pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId());
        if (super.updateById(pcacEnterpriseRiskSubmitInfo)) {
            log.info("更新d为{}的pcacEnterpriseRiskSubmitInfo成功", pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId());
            return pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId();
        } else {
            log.error("更新id为{}的pcacEnterpriseRiskSubmitInfo失败", pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId());
            throw new BizException("更新失败[id=" + pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId() + "]");
        }
    }

    @Autowired
    private PcacEnterpriseRiskSubmitInfoMapper pcacEnterpriseRiskSubmitInfoMapper;

    @Autowired
    private PcacConfig pcacConfig;

    @Override
    public ResultBean<Page<RiskEnterpriseResp>> pageRiskEnterprise(RiskEnterpriseReq riskEnterpriseReq) {
        ResultBean<Page<RiskEnterpriseResp>> resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());

        Page<RiskEnterpriseResp> page = new Page<>(riskEnterpriseReq.getPageNo(), riskEnterpriseReq.getPageSize());
        Page<RiskEnterpriseResp> pagePcacEnterpriseRiskSubmitInfo = pcacEnterpriseRiskSubmitInfoMapper.pagePcacEnterpriseRiskSubmitInfo(page, riskEnterpriseReq);
        List<RiskEnterpriseResp> riskEnterpriseResps = pagePcacEnterpriseRiskSubmitInfo.getRecords();
        if (!CollectionUtils.isEmpty(riskEnterpriseResps)) {
            for (RiskEnterpriseResp riskEnterpriseResp : riskEnterpriseResps) {
                String validStatus = (new Date().before(riskEnterpriseResp.getValidDate())) ? CommonConst.VALIDSTATUS_01 : CommonConst.VALIDSTATUS_02;
                riskEnterpriseResp.setValidStatus(validStatus);
                riskEnterpriseResp.setLegDocType(LegDocTypeEnum.getLegDocTypeDesc(riskEnterpriseResp.getLegDocType()));
                riskEnterpriseResp.setSubmitStatus(SubmitStatusEnum.getSubmitStatusEnumDesc(riskEnterpriseResp.getSubmitStatus()));
            }
        }
        resultBean.setData(pagePcacEnterpriseRiskSubmitInfo);
        return resultBean;
    }

    @Override
    public void queryRiskEnterpriseAndPushPcac() {
        //获取未上报的数据
        QueryWrapper<PcacEnterpriseRiskSubmitInfo> queryWrapper = new QueryWrapper<PcacEnterpriseRiskSubmitInfo>().like("msg_detail", "未上报");
        List<PcacEnterpriseRiskSubmitInfo> PcacEnterpriseRiskSubmitInfos = pcacEnterpriseRiskSubmitInfoMapper.selectList(queryWrapper);
        if (PcacEnterpriseRiskSubmitInfos.size() == 0) {
            log.info("当前没有可上报的风险商户信息");
            return;
        }
        Document document = getDocument(PcacEnterpriseRiskSubmitInfos);
        //报文转换
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("获取到的xml数据:{}", xml);
        if (StringUtils.isEmpty(xml)) {
            log.info("xml报文转换失败");
            return;
        }
        //校验xml报文
        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries.059");
        // boolean validate = ValidateUtils.validateXML(xml, "pcac.ries.013");
        if (!validate) {
            log.info("XML校验失败");
            return;
        }
        pushToPcac(PcacEnterpriseRiskSubmitInfos, xml);
    }

    private void pushToPcac(List<PcacEnterpriseRiskSubmitInfo> PcacEnterpriseRiskSubmitInfos, String xml) {
        //上报数据
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
        log.info("url:{}", pcacConfig.getUrl());
        /*String post = "<Body>\n" +
                "    <RespInfo>\n" +
                "        <ResultStatus>已上报</ResultStatus>\n" +
                "        <ResultCode>01</ResultCode>\n" +
                "    </RespInfo>\n" +
                "</Body>";*/
        com.cmcc.paymentclean.entity.dto.pcac.resp.Document doc = (com.cmcc.paymentclean.entity.dto.pcac.resp.Document) XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class, post);
        log.info("协会返回数据对象:{}", doc);
        for (PcacEnterpriseRiskSubmitInfo PcacEnterpriseRiskSubmitInfo : PcacEnterpriseRiskSubmitInfos) {
            UpdateWrapper<PcacEnterpriseRiskSubmitInfo> updateWrapper = new UpdateWrapper<PcacEnterpriseRiskSubmitInfo>().set("msg_detail", doc.getRespone().getBody().getRespInfo().getResultStatus());
            pcacEnterpriseRiskSubmitInfoMapper.update(PcacEnterpriseRiskSubmitInfo, updateWrapper);
        }
    }

    private Document getDocument(List<PcacEnterpriseRiskSubmitInfo> PcacEnterpriseRiskSubmitInfos) {
        //拼装报文
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        Document document = new Document();
        //设置报文头
        Request request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig,"BR0001");
        //设置报文体
        Body body = new Body();
        PcacList pcacList = new PcacList();
        for (int i = 0; i < PcacEnterpriseRiskSubmitInfos.size(); i++) {
            pcacList.setCount(PcacEnterpriseRiskSubmitInfos.size());
            ArrayList<RiskInfo> riskInfos = new ArrayList<>();
            RiskInfo riskInfo = new RiskInfo();
            PcacEnterpriseRiskSubmitInfo PcacEnterpriseRiskSubmitInfo = PcacEnterpriseRiskSubmitInfos.get(i);
            BeanUtilsEx.copyProperties(riskInfo, PcacEnterpriseRiskSubmitInfo);
            BankList bankList = new BankList();
            BankInfo bankInfo = new BankInfo();
            BeanUtilsEx.copyProperties(bankInfo, PcacEnterpriseRiskSubmitInfo);
            //银行结算账号
            bankInfo.setBankNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, bankInfo.getBankNo()));
            bankList.setBankInfo(bankInfo);
            riskInfo.setBankList(bankList);
            riskInfo.setRepDate(DateUtils.formatTime(new Date(System.currentTimeMillis()), null));
            BenList benList = new BenList();
            BenInfo benInfo = new BenInfo();
            BeanUtilsEx.copyProperties(benInfo, PcacEnterpriseRiskSubmitInfo);
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
            riskInfo.setLegDocName(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getLegDocName()));
            //法定代表人（负责人）证件号码
            riskInfo.setLegDocCode(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getLegDocCode()));
            //法定代表人（负责人）手机号
            riskInfo.setMobileNo(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getMobileNo()));
            //网址
            riskInfo.setUrl(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getUrl()));
            //服务器 ip
            riskInfo.setServerIp(CFCACipherUtils.encrypt(symmetricKeyEncoded, riskInfo.getServerIp()));
            //ICP 备案编号
            riskInfo.setIcp(CFCACipherUtils.encrypt(symmetricKeyEncoded, PcacEnterpriseRiskSubmitInfo.getRegName()));
            riskInfo.setDocCode(CFCACipherUtils.getInnerToCFCA(PcacEnterpriseRiskSubmitInfo.getDocType(), PcacEnterpriseRiskSubmitInfo.getDocCode(), symmetricKeyEncoded));
            riskInfo.setBenList(benList);
            riskInfos.add(riskInfo);
            pcacList.setRiskInfo(riskInfos);
        }
        body.setPcacList(pcacList);
        request.setBody(body);
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        //加签
        String doSignature = CFCACipherUtils.doSignature(xml);
        document.setSignature(doSignature);
        document.setRequest(request);
        return document;
    }

}
