package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.RiskEnterprise;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.mapper.RiskEnterpriseMapper;
import com.cmcc.paymentclean.service.RiskEnterpriseService;
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
public class RiskEnterpriseServiceImpl extends ServiceImpl<RiskEnterpriseMapper, RiskEnterprise> implements RiskEnterpriseService {


    @Override
    public ResultBean<Boolean> addEnterprise(List<RiskEnterprise> riskEnterpriseList) {
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        if(CollectionUtils.isEmpty(riskEnterpriseList)){
            return resultBean;
        }
        List<RiskEnterprise> newEnterpriseList = new ArrayList<>();
        for(RiskEnterprise riskEnterprise:riskEnterpriseList){
            riskEnterprise.setOperateTime(new Date());
            QueryWrapper<RiskEnterprise> queryWrapper = new QueryWrapper();
            queryWrapper.eq("payAccountNo",riskEnterprise.getPayaccountno());
            RiskEnterprise riskEnterprise1 = super.getOne(queryWrapper);
            if(null!=riskEnterprise1){
                UpdateWrapper<RiskEnterprise> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("risk_enterprise_risk_sync_info_id",riskEnterprise1.getRiskEnterpriseRiskSyncInfoId());
                super.update(riskEnterprise,updateWrapper);
            }else{
                newEnterpriseList.add(riskEnterprise);
            }
        }
        if(!CollectionUtils.isEmpty(newEnterpriseList)){
            this.saveBatch(newEnterpriseList);
        }

        return resultBean;
    }
}
