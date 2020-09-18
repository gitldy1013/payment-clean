package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.RiskMerchantRiskSyncInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantRiskSyncInfoReq;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.RiskMerchantRiskSyncInfoMapper;
import com.cmcc.paymentclean.service.RiskMerchantRiskSyncInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 风控商户风险信息同步表  服务实现类
 * </p>
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Slf4j
@Service
public class RiskMerchantRiskSyncInfoServiceImpl extends ServiceImpl<RiskMerchantRiskSyncInfoMapper, RiskMerchantRiskSyncInfo> implements RiskMerchantRiskSyncInfoService {

    @Override
    public ResultBean<Boolean> addMerchant(List<RiskMerchantRiskSyncInfoReq> riskMerchantList) {
        log.info("addMerchant req={}", com.alibaba.fastjson.JSON.toJSON(riskMerchantList));
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        List<RiskMerchantRiskSyncInfo> newRiskMerchantList = new ArrayList<>();
        if (CollectionUtils.isEmpty(riskMerchantList)) {
            return resultBean;
        }
        for (RiskMerchantRiskSyncInfoReq riskMerchant : riskMerchantList) {
            RiskMerchantRiskSyncInfo riskMerchantRiskSyncInfo = new RiskMerchantRiskSyncInfo();
            BeanUtils.copyProperties(riskMerchant, riskMerchantRiskSyncInfo);
            riskMerchantRiskSyncInfo.setRiskType(this.splitStrs(riskMerchantRiskSyncInfo.getRiskType()));
            riskMerchantRiskSyncInfo.setSourceChannel(this.splitStrs(riskMerchantRiskSyncInfo.getSourceChannel()));
            riskMerchantRiskSyncInfo.setOperateTime(new Date(System.currentTimeMillis()));
            QueryWrapper<RiskMerchantRiskSyncInfo> queryWrapper = new QueryWrapper();
            queryWrapper.eq("cus_code", riskMerchant.getCusCode());
            RiskMerchantRiskSyncInfo riskMerchant1 = super.getOne(queryWrapper);
            if (null != riskMerchant1) {
                UpdateWrapper<RiskMerchantRiskSyncInfo> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("risk_merchant_risk_sync_info_id", riskMerchant1.getRiskMerchantRiskSyncInfoId());
                super.update(riskMerchantRiskSyncInfo, updateWrapper);
            } else {
                newRiskMerchantList.add(riskMerchantRiskSyncInfo);
            }
        }
        if (!CollectionUtils.isEmpty(newRiskMerchantList)) {
            this.saveBatch(newRiskMerchantList);
        }
        return resultBean;
    }

    private String splitStrs(String strings){
        if(StringUtils.isEmpty(strings)){
            return strings;
        }
        String [] strs = strings.split("|");
        return strs[0];
    }
}
