package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.entity.RiskPerson;
import com.cmcc.paymentclean.mapper.RiskPersonMapper;
import com.cmcc.paymentclean.service.RiskPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by lumma on 2020/9/9.
 * @author lumma
 */
@Slf4j
@Service
public class RiskPersonServiceImpl extends ServiceImpl<RiskPersonMapper, RiskPerson> implements RiskPersonService {

    @Override
    public boolean addRiskPerson(List<RiskPerson> riskPersonList) {
        if(!CollectionUtils.isEmpty(riskPersonList)){
            for(RiskPerson riskPerson:riskPersonList){
                riskPerson.setOperateTime(new Date());
            }
           return this.saveBatch(riskPersonList);
        }

        return false;
    }




}
