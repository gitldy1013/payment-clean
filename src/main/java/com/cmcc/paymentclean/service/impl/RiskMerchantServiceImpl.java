package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.RiskMerchant;
import com.cmcc.paymentclean.entity.dto.ResultBean;
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
    public ResultBean<Boolean> addRiskPerson(List<RiskMerchant> riskMerchantList) {
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.ERROR.getCode());
        resultBean.setResMsg(ResultCodeEnum.ERROR.getDesc());
        if(!CollectionUtils.isEmpty(riskMerchantList)){
            for(RiskMerchant riskMerchant:riskMerchantList){
                riskMerchant.setOperateTime(new Date());
            }

            Boolean result = this.saveBatch(riskMerchantList);
            if(result){
                resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
                resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
                resultBean.setData(result);
                return resultBean;
            }
        }

        return resultBean;
    }
}
