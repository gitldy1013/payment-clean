package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.RiskPerson;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.mapper.RiskPersonMapper;
import com.cmcc.paymentclean.service.RiskPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
    public ResultBean<Boolean> addRiskPerson(List<RiskPerson> riskPersonList) {
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        if(!CollectionUtils.isEmpty(riskPersonList)){
            List<RiskPerson> newRiskPersonList = new ArrayList<>();
            for(RiskPerson riskPerson:riskPersonList){
                riskPerson.setOperateTime(new Date());
                QueryWrapper<RiskPerson> queryWrapper = new QueryWrapper();
                queryWrapper.eq("usrNo",riskPerson.getUsrno());
                RiskPerson riskPerson1 = super.getOne(queryWrapper);
                if(null!=riskPerson1){
                    UpdateWrapper<RiskPerson> updateWrapper = new UpdateWrapper<>();
                    updateWrapper.eq("risk_person_risk_sync_info_id",riskPerson1.getRiskPersonRiskSyncInfoId());
                    super.update(riskPerson,updateWrapper);
                }else{
                    newRiskPersonList.add(riskPerson);
                }
            }
            if(!CollectionUtils.isEmpty(newRiskPersonList)){
                this.saveBatch(newRiskPersonList);
            }
            return resultBean;
        }

        return resultBean;
    }




}
