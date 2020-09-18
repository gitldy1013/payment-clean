package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.RiskPersonRiskSyncInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonRiskSyncInfoReq;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.RiskPersonRiskSyncInfoMapper;
import com.cmcc.paymentclean.service.RiskPersonRiskSyncInfoService;
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
* 风控个人风险信息同步表  服务实现类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
@Slf4j
@Service
public class RiskPersonRiskSyncInfoServiceImpl extends ServiceImpl<RiskPersonRiskSyncInfoMapper, RiskPersonRiskSyncInfo> implements RiskPersonRiskSyncInfoService {

    @Override
    public ResultBean<Boolean> addRiskPerson(List<RiskPersonRiskSyncInfoReq> riskPersonList) {
        log.info("addRiskPerson req={}", com.alibaba.fastjson.JSON.toJSON(riskPersonList));
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        if(!CollectionUtils.isEmpty(riskPersonList)){
            List<RiskPersonRiskSyncInfo> newRiskPersonList = new ArrayList<>();
            for(RiskPersonRiskSyncInfoReq riskPerson:riskPersonList){
                RiskPersonRiskSyncInfo riskPersonRiskSyncInfo = new RiskPersonRiskSyncInfo();
                BeanUtils.copyProperties(riskPerson, riskPersonRiskSyncInfo);
                riskPersonRiskSyncInfo.setOccurchan(this.splitStrs(riskPersonRiskSyncInfo.getOccurchan()));
                riskPersonRiskSyncInfo.setRiskType(this.splitStrs(riskPersonRiskSyncInfo.getRiskType()));
                riskPersonRiskSyncInfo.setSourceChannel(this.splitStrs(riskPersonRiskSyncInfo.getSourceChannel()));
                riskPersonRiskSyncInfo.setOperateTime(new Date(System.currentTimeMillis()));
                QueryWrapper<RiskPersonRiskSyncInfo> queryWrapper = new QueryWrapper();
                queryWrapper.eq("usrNo",riskPerson.getUsrNo());
                RiskPersonRiskSyncInfo riskPerson1 = super.getOne(queryWrapper);
                if(null!=riskPerson1){
                    UpdateWrapper<RiskPersonRiskSyncInfo> updateWrapper = new UpdateWrapper<>();
                    updateWrapper.eq("risk_person_risk_sync_info_id",riskPerson1.getRiskPersonRiskSyncInfoId());
                    super.update(riskPersonRiskSyncInfo,updateWrapper);
                }else{
                    newRiskPersonList.add(riskPersonRiskSyncInfo);
                }
            }
            if(!CollectionUtils.isEmpty(newRiskPersonList)){
                this.saveBatch(newRiskPersonList);
            }
            return resultBean;
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
