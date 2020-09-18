package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.*;
import com.cmcc.paymentclean.entity.LocalAssociatedRiskMerchantInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac046.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.entity.dto.response.AssociatedRiskMerchantInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.AssociatedRiskMerchantInfoBackReq;
import com.cmcc.paymentclean.entity.dto.resquest.AssociatedRiskMerchantInfoReq;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.LocalAssociatedRiskMerchantInfoMapper;
import com.cmcc.paymentclean.service.LocalAssociatedRiskMerchantInfoService;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 本地关联风险商户信息表  服务实现类
 * </p>
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Slf4j
@Service
public class LocalAssociatedRiskMerchantInfoServiceImpl extends ServiceImpl<LocalAssociatedRiskMerchantInfoMapper, LocalAssociatedRiskMerchantInfo> implements LocalAssociatedRiskMerchantInfoService {

    @Autowired
    private LocalAssociatedRiskMerchantInfoMapper localAssociatedRiskMerchantInfoMapper;

    @Autowired
    private PcacConfig pcacConfig;

    @Override
    public ResultBean<Page<AssociatedRiskMerchantInfoResp>> pageLocalAssociatedRiskMerchantInfo(AssociatedRiskMerchantInfoReq associatedRiskMerchantInfoReq) {
        log.info("pageLocalAssociatedRiskMerchantInfo req={}", com.alibaba.fastjson.JSON.toJSON(associatedRiskMerchantInfoReq));
        ResultBean<Page<AssociatedRiskMerchantInfoResp>> resultBean = new ResultBean();
        Page<AssociatedRiskMerchantInfoResp> page = new Page<>(associatedRiskMerchantInfoReq.getPageNo(), associatedRiskMerchantInfoReq.getPageSize());
        Page<AssociatedRiskMerchantInfoResp> pageLocalAssociatedRiskMerchantInfo = localAssociatedRiskMerchantInfoMapper.pageLocalAssociatedRiskMerchantInfo(page, associatedRiskMerchantInfoReq);
        List<AssociatedRiskMerchantInfoResp> associatedRiskMerchantInfoResps = pageLocalAssociatedRiskMerchantInfo.getRecords();
        if (!CollectionUtils.isEmpty(associatedRiskMerchantInfoResps)) {
            for (AssociatedRiskMerchantInfoResp associatedRiskMerchantInfoResp : associatedRiskMerchantInfoResps) {
                String validStatus = (new Date().before(associatedRiskMerchantInfoResp.getValidDate())) ? CommonConst.VALIDSTATUS_01 : CommonConst.VALIDSTATUS_02;
                associatedRiskMerchantInfoResp.setValidStatus(validStatus);
                associatedRiskMerchantInfoResp.setLevel(LevelCodeEnum.getLevelDesc(associatedRiskMerchantInfoResp.getLevel()));
                associatedRiskMerchantInfoResp.setPushListType(PushListTypeEnum.getPushListTypeDesc(associatedRiskMerchantInfoResp.getPushListType()));
                associatedRiskMerchantInfoResp.setFeedbackStatus(FeedbackStatusEnum.getFeedbackStatusDesc(associatedRiskMerchantInfoResp.getFeedbackStatus()));
                associatedRiskMerchantInfoResp.setLegDocType(LegDocTypeEnum.getLegDocTypeDesc(associatedRiskMerchantInfoResp.getLegDocType()));
                associatedRiskMerchantInfoResp.setIsBlack(IsBlackEnum.getIsBlackEnumDesc(associatedRiskMerchantInfoResp.getIsBlack()));
                associatedRiskMerchantInfoResp.setLevel(LevelCodeEnum.getLevelDesc(associatedRiskMerchantInfoResp.getLevel()));
                associatedRiskMerchantInfoResp.setDocType(DocTypeEnum.getDocTypeDesc(associatedRiskMerchantInfoResp.getDocType()));
                associatedRiskMerchantInfoResp.setIsBlack(IsBlackEnum.getIsBlackEnumDesc(associatedRiskMerchantInfoResp.getIsBlack()));
                associatedRiskMerchantInfoResp.setLevel(LevelCodeEnum.getLevelDesc(associatedRiskMerchantInfoResp.getLevel()));
                associatedRiskMerchantInfoResp.setRiskType(RiskTypeEnum.getRiskTypeDesc(associatedRiskMerchantInfoResp.getRiskType()));
                associatedRiskMerchantInfoResp.setHandleResult(HandleResultEnum.getHandleResultDesc(associatedRiskMerchantInfoResp.getHandleResult()));
                associatedRiskMerchantInfoResp.setCusType(CusTypeEnum.getCusTypeEnum(associatedRiskMerchantInfoResp.getCusType()));
                associatedRiskMerchantInfoResp.setStatus(StatusEnum.getStatusDesc(associatedRiskMerchantInfoResp.getStatus()));
            }
        }
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        resultBean.setData(pageLocalAssociatedRiskMerchantInfo);
        log.info("pageLocalAssociatedRiskMerchantInfo resp={}", com.alibaba.fastjson.JSON.toJSON(pageLocalAssociatedRiskMerchantInfo));
        return resultBean;
    }

    @Override
    public ResultBean<com.cmcc.paymentclean.entity.dto.pcac.resp.Body> localAssociatedRiskMerchantInfoBack(List<AssociatedRiskMerchantInfoBackReq> associatedRiskMerchantInfoBackReq) {
        ResultBean<com.cmcc.paymentclean.entity.dto.pcac.resp.Body> resultBean = new ResultBean<com.cmcc.paymentclean.entity.dto.pcac.resp.Body>();
//        if(true){
//            resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
//            resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
//            return resultBean;
//        }

        QueryWrapper<LocalAssociatedRiskMerchantInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("", "");
        LocalAssociatedRiskMerchantInfo localAssociatedRiskMerchantInfo = localAssociatedRiskMerchantInfoMapper.selectOne(wrapper);
        //拼装报文
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        Document document = new Document();
        //设置报文头
        Request request = XmlJsonUtils.getRequest(symmetricKeyEncoded, document, pcacConfig, "");
        //设置报文体
        Body body = new Body();
        PcacList pcacList = new PcacList();
        pcacList.setCount(associatedRiskMerchantInfoBackReq.size() + "");
        List<RiskInfo> riskInfos = new ArrayList<>();
        for (int i = 0; i < associatedRiskMerchantInfoBackReq.size(); i++) {
            AssociatedRiskMerchantInfoBackReq armbr = associatedRiskMerchantInfoBackReq.get(i);
            RiskInfo riskInfo = new RiskInfo();
            riskInfos.add(riskInfo);
            riskInfo.setCusType(localAssociatedRiskMerchantInfo.getCusType());
            riskInfo.setRegName(localAssociatedRiskMerchantInfo.getRegName());
            riskInfo.setCurrency("人民币");
            riskInfo.setAmount(armbr.getAmount());
            riskInfo.setDocType(armbr.getDocType());
            riskInfo.setDocCode(armbr.getDocCode());
            riskInfo.setHandleResult(armbr.getHandleResult());
            riskInfo.setHandleTime(DateUtils.formatTime(new Date(), null));
            pcacList.setRiskInfo(riskInfos);
            body.setPcacList(pcacList);
            request.setBody(body);
        }
        document.setRequest(request);
        //发起反馈
        String xmlStr = XmlJsonUtils.convertObjectToXmlStr(document);
        boolean validateXML = ValidateUtils.validateXML(xmlStr, "");
        if (!validateXML) {
            log.info("XSD校验失败{}", xmlStr);
            return resultBean;
        }
        //解析响应
        String post = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), xmlStr);
        com.cmcc.paymentclean.entity.dto.pcac.resp.Body resBody = (com.cmcc.paymentclean.entity.dto.pcac.resp.Body) XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resp.Body.class, post);
        resultBean.setData(resBody);
        resultBean.setResCode(resBody.getRespInfo().getResultCode());
        if (resBody.getRespInfo().getMsgDetail().isEmpty()) {
            resultBean.setResMsg(resBody.getRespInfo().getResultStatus());
        } else {
            resultBean.setResMsg(resBody.getRespInfo().getMsgDetail());
        }
        return resultBean;
    }

}
