package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.RiskEnterpriseRiskSyncInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.RiskEnterpriseRiskSyncInfoReq;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.RiskEnterpriseRiskSyncInfoMapper;
import com.cmcc.paymentclean.service.RiskEnterpriseRiskSyncInfoService;
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
* 风控企业风险信息同步表  服务实现类
* </p>
*
* @author zhaolei
* @since 2020-09-11
*/
@Slf4j
@Service
public class RiskEnterpriseRiskSyncInfoServiceImpl extends ServiceImpl<RiskEnterpriseRiskSyncInfoMapper, RiskEnterpriseRiskSyncInfo> implements RiskEnterpriseRiskSyncInfoService {

    @Override
    public ResultBean<Boolean> addEnterprise(List<RiskEnterpriseRiskSyncInfoReq> riskEnterpriseList) {
        log.info("addEnterprise req={}", com.alibaba.fastjson.JSON.toJSON(riskEnterpriseList));
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        if(CollectionUtils.isEmpty(riskEnterpriseList)){
            return resultBean;
        }
        List<RiskEnterpriseRiskSyncInfo> newEnterpriseList = new ArrayList<>();
        for(RiskEnterpriseRiskSyncInfoReq riskEnterprise:riskEnterpriseList){
            RiskEnterpriseRiskSyncInfo riskEnterpriseRiskSyncInfo = new RiskEnterpriseRiskSyncInfo();
            BeanUtils.copyProperties(riskEnterprise, riskEnterpriseRiskSyncInfo);
            riskEnterpriseRiskSyncInfo.setRiskType(this.splitStrs(riskEnterpriseRiskSyncInfo.getRiskType()));
            riskEnterpriseRiskSyncInfo.setSourceChannel(this.splitStrs(riskEnterpriseRiskSyncInfo.getSourceChannel()));
            riskEnterpriseRiskSyncInfo.setOperateTime(new Date(System.currentTimeMillis()));
            QueryWrapper<RiskEnterpriseRiskSyncInfo> queryWrapper = new QueryWrapper();
            queryWrapper.eq("cus_code",riskEnterprise.getCusCode());
            RiskEnterpriseRiskSyncInfo riskEnterprise1 = super.getOne(queryWrapper);
            if(null!=riskEnterprise1){
                UpdateWrapper<RiskEnterpriseRiskSyncInfo> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("risk_enterprise_risk_sync_info_id",riskEnterprise1.getRiskEnterpriseRiskSyncInfoId());
                super.update(riskEnterpriseRiskSyncInfo,updateWrapper);
            }else{
                newEnterpriseList.add(riskEnterpriseRiskSyncInfo);
            }
        }
        if(!CollectionUtils.isEmpty(newEnterpriseList)){
            this.saveBatch(newEnterpriseList);
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
