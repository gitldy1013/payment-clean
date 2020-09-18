package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.FeedbackStatusEnum;
import com.cmcc.paymentclean.consts.IsBlackEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.LevelCodeEnum;
import com.cmcc.paymentclean.consts.PushListTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
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

    @Override
    public Page<LocalAssociatedRiskMerchantInfo> listLocalAssociatedRiskMerchantInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询localAssociatedRiskMerchantInfo: page = {} pageSize = {} factor = {}", page, pageSize, factor);
        QueryWrapper<LocalAssociatedRiskMerchantInfo> queryWrapper = new QueryWrapper<LocalAssociatedRiskMerchantInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<LocalAssociatedRiskMerchantInfo> result = super.page(new Page<LocalAssociatedRiskMerchantInfo>(page, pageSize), queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询localAssociatedRiskMerchantInfo完毕: 结果数 = {} ", result.getRecords().size());
        return result;
    }

    @Override
    public LocalAssociatedRiskMerchantInfo getLocalAssociatedRiskMerchantInfoById(int id) {
        log.info("正在查询localAssociatedRiskMerchantInfo中id为{}的数据", id);
        LocalAssociatedRiskMerchantInfo localAssociatedRiskMerchantInfo = super.getById(id);
        log.info("查询id为{}的localAssociatedRiskMerchantInfo{}", id, (null == localAssociatedRiskMerchantInfo ? "无结果" : "成功"));
        return localAssociatedRiskMerchantInfo;
    }

    @Override
    public int insertLocalAssociatedRiskMerchantInfo(LocalAssociatedRiskMerchantInfo localAssociatedRiskMerchantInfo) {
        log.info("正在插入localAssociatedRiskMerchantInfo");
        if (super.save(localAssociatedRiskMerchantInfo)) {
            log.info("插入localAssociatedRiskMerchantInfo成功,id为{}", localAssociatedRiskMerchantInfo.getLocalAssociatedRiskMerchantInfoId());
            return localAssociatedRiskMerchantInfo.getLocalAssociatedRiskMerchantInfoId();
        } else {
            log.error("插入localAssociatedRiskMerchantInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteLocalAssociatedRiskMerchantInfoById(int id) {
        log.info("正在删除id为{}的localAssociatedRiskMerchantInfo", id);
        if (super.removeById(id)) {
            log.info("删除id为{}的localAssociatedRiskMerchantInfo成功", id);
            return id;
        } else {
            log.error("删除id为{}的localAssociatedRiskMerchantInfo失败", id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateLocalAssociatedRiskMerchantInfo(LocalAssociatedRiskMerchantInfo localAssociatedRiskMerchantInfo) {
        log.info("正在更新id为{}的localAssociatedRiskMerchantInfo", localAssociatedRiskMerchantInfo.getLocalAssociatedRiskMerchantInfoId());
        if (super.updateById(localAssociatedRiskMerchantInfo)) {
            log.info("更新d为{}的localAssociatedRiskMerchantInfo成功", localAssociatedRiskMerchantInfo.getLocalAssociatedRiskMerchantInfoId());
            return localAssociatedRiskMerchantInfo.getLocalAssociatedRiskMerchantInfoId();
        } else {
            log.error("更新id为{}的localAssociatedRiskMerchantInfo失败", localAssociatedRiskMerchantInfo.getLocalAssociatedRiskMerchantInfoId());
            throw new BizException("更新失败[id=" + localAssociatedRiskMerchantInfo.getLocalAssociatedRiskMerchantInfoId() + "]");
        }
    }

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
