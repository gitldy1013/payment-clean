package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.RiskMerchant;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.mapper.RiskMerchantMapper;
import com.cmcc.paymentclean.service.RiskMerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lumma on 2020/9/9.
 */
@Slf4j
@Service
public class RiskMerchantServiceImpl extends ServiceImpl<RiskMerchantMapper, RiskMerchant> implements RiskMerchantService {


    @Override
    public ResultBean<Boolean> addMerchant(List<RiskMerchant> riskMerchantList) {
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        List<RiskMerchant> newRiskMerchantList = new ArrayList<>();
        if(CollectionUtils.isEmpty(riskMerchantList)){
            return resultBean;
        }
        for(RiskMerchant riskMerchant:riskMerchantList){
            riskMerchant.setOperateTime(new Date());
            QueryWrapper<RiskMerchant> queryWrapper = new QueryWrapper();
            queryWrapper.eq("cus_code",riskMerchant.getCusCode());
            RiskMerchant riskMerchant1 = super.getOne(queryWrapper);
            if(null!=riskMerchant1){
                UpdateWrapper<RiskMerchant> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("risk_merchant_risk_sync_info_id",riskMerchant1.getRiskMerchantRiskSyncInfoId());
                super.update(riskMerchant,updateWrapper);
            }else{
                newRiskMerchantList.add(riskMerchant);
            }
        }
        if(!CollectionUtils.isEmpty(newRiskMerchantList)){
            this.saveBatch(newRiskMerchantList);
        }
        return resultBean;
    }
}
