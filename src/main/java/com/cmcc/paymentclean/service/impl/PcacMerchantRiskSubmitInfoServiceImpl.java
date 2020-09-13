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
import com.cmcc.paymentclean.entity.PcacMerchantRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.RespInfo;
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
import com.cmcc.paymentclean.entity.dto.response.RiskMerchantResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantReq;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.PcacMerchantRiskSubmitInfoMapper;
import com.cmcc.paymentclean.service.PcacMerchantRiskSubmitInfoService;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.LocalDateTimeUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.cmcc.paymentclean.utils.ValidateUtils.XSD_DIR;

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
                String validStatus = (new Date().before(riskMerchantResp.getValidDate())) ? CommonConst.VALIDSTATUS_01 : CommonConst.VALIDSTATUS_02;
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
        QueryWrapper<PcacMerchantRiskSubmitInfo> queryWrapper = new QueryWrapper<PcacMerchantRiskSubmitInfo>().like("msg_detail", "未上报");
        List<PcacMerchantRiskSubmitInfo> pcacMerchantRiskSubmitInfos = pcacMerchantRiskSubmitInfoMapper.selectList(queryWrapper);
        if (pcacMerchantRiskSubmitInfos.size() == 0) {
            log.info("当前没有可上报的风险商户信息");
            return;
        }
        Document document = getDocument(pcacMerchantRiskSubmitInfos);
        //报文转换
        Gson gson = new Gson();
        String json = gson.toJson(document);
        log.info("获取到的json数据:{}", json);
        String xml = XmlJsonUtils.json2xml4pcac(json);
        log.info("获取到的xml数据:{}", xml);
        //校验xml报文
        boolean validate = ValidateUtils.validateXMLByXSD(xml, XSD_DIR + "pcac.ries.013");
        if (!validate) {
            log.info("XML校验失败");
            return;
        }
        pushToPcac(pcacMerchantRiskSubmitInfos, gson, xml);
    }

    private void pushToPcac(List<PcacMerchantRiskSubmitInfo> pcacMerchantRiskSubmitInfos, Gson gson, String xml) {
        //上报数据
        try {
            String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xml);
            log.info("url:{}", pcacConfig.getUrl());
//            String post = "<Body>\n" +
//                    "    <RespInfo>\n" +
//                    "        <ResultStatus>123</ResultStatus>\n" +
//                    "        <ResultCode>321</ResultCode>\n" +
//                    "    </RespInfo>\n" +
//                    "</Body>";
            String pcac = XmlJsonUtils.xml2pcac4pcac(post);
            log.info("协会返回数据JSON:{}", pcac);
            RespInfo respInfo = gson.fromJson(pcac, RespInfo.class);
            com.cmcc.paymentclean.entity.dto.pcac.resp.Body resBody = new com.cmcc.paymentclean.entity.dto.pcac.resp.Body();
            resBody.setRespInfo(respInfo);
            log.info("协会返回数据对象:{}", resBody);
            for (PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo : pcacMerchantRiskSubmitInfos) {
                UpdateWrapper<PcacMerchantRiskSubmitInfo> updateWrapper = new UpdateWrapper<PcacMerchantRiskSubmitInfo>().set("msg_detail", resBody.getRespInfo().getResultStatus());
                pcacMerchantRiskSubmitInfoMapper.update(pcacMerchantRiskSubmitInfo, updateWrapper);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("上报商户数据异常：{}", e.getMessage());
        }
    }

    private Document getDocument(List<PcacMerchantRiskSubmitInfo> pcacMerchantRiskSubmitInfos) {
        //拼装报文
        Document document = new Document();
        document.setSignature("");
        Request request = new Request();
        Head head = new Head();
        head.setVersion("V1.3.0");
        head.setIdentification(LocalDateTimeUtils.formatTime(LocalDateTime.now(), LocalDateTimeUtils.FORMAT_DATE_PCAC + "10"));
        head.setOrigSender("");
        head.setOrigSenderSID("");
        head.setRecSystemId("R0001");
        head.setTrnxCode("");
        head.setTrnxTime(LocalDateTimeUtils.formatTime(LocalDateTime.now(), LocalDateTimeUtils.FORMAT_TIME_PCAC));
        head.setUserToken("");
        head.setSecretKey("");
        Body body = new Body();
        ArrayList<PcacList> pcacList = new ArrayList<PcacList>();
        for (int i = 0; i < pcacMerchantRiskSubmitInfos.size(); i++) {
            PcacList pcac = new PcacList();
            pcac.setCount(pcacMerchantRiskSubmitInfos.size());
            RiskInfo riskInfo = new RiskInfo();
            PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo = pcacMerchantRiskSubmitInfos.get(i);
            BeanUtils.copyProperties(pcacMerchantRiskSubmitInfo, riskInfo);
            BankList bankList = new BankList();
            bankList.setCount("1");
            BankInfo bankInfo = new BankInfo();
            BeanUtils.copyProperties(pcacMerchantRiskSubmitInfo, bankInfo);
            bankList.setBankInfo(bankInfo);
            riskInfo.setBankList(bankList);
            riskInfo.setRepDate(LocalDateTimeUtils.formatTime(LocalDateTime.now(), null));
            BenList benList = new BenList();
            BenInfo benInfo = new BenInfo();
            BeanUtils.copyProperties(pcacMerchantRiskSubmitInfo, benInfo);
            benList.setBenInfo(benInfo);
            bankList.setCount("1");
            riskInfo.setBenList(benList);
            pcac.setRiskInfo(riskInfo);
            pcacList.add(pcac);
        }
        body.setPcacList(pcacList);
        request.setHead(head);
        request.setBody(body);
        document.setRequest(request);
        return document;
    }

}
