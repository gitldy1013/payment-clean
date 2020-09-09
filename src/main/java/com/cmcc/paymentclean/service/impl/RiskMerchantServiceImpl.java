package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.entity.RiskMerchant;
import com.cmcc.paymentclean.mapper.RiskMerchantMapper;
import com.cmcc.paymentclean.service.RiskMerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by lumma on 2020/9/9.
 */
@Slf4j
@Service
public class RiskMerchantServiceImpl extends ServiceImpl<RiskMerchantMapper, RiskMerchant> implements RiskMerchantService {
    @Override
    public boolean addRiskPerson(List<RiskMerchant> riskMerchantList) {
        if(!CollectionUtils.isEmpty(riskMerchantList)){
            for(RiskMerchant riskMerchant:riskMerchantList){
                riskMerchant.setOperateTime(new Date());
            }
            return this.saveBatch(riskMerchantList);
        }

        return false;
    }
}
