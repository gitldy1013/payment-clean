package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.entity.RiskEnterprise;
import com.cmcc.paymentclean.mapper.RiskEnterpriseMapper;
import com.cmcc.paymentclean.service.RiskEnterpriseService;
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
public class RiskEnterpriseServiceImpl extends ServiceImpl<RiskEnterpriseMapper, RiskEnterprise> implements RiskEnterpriseService {
    @Override
    public boolean addRiskPerson(List<RiskEnterprise> riskEnterpriseList) {
        if(!CollectionUtils.isEmpty(riskEnterpriseList)){
            for(RiskEnterprise riskEnterprise:riskEnterpriseList){
                riskEnterprise.setOperateTime(new Date());
            }
            return this.saveBatch(riskEnterpriseList);
        }

        return false;
    }
}
