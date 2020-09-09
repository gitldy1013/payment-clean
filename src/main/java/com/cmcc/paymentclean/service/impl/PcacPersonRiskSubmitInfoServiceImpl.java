package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.entity.PcacPersonRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;
import com.cmcc.paymentclean.mapper.PcacPersonRiskSubmitInfoMapper;
import com.cmcc.paymentclean.service.PcacPersonRiskSubmitInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lumma on 2020/9/9.
 */
@Slf4j
@Service
public class PcacPersonRiskSubmitInfoServiceImpl extends ServiceImpl<PcacPersonRiskSubmitInfoMapper, PcacPersonRiskSubmitInfo> implements PcacPersonRiskSubmitInfoService {

    @Autowired
    private PcacPersonRiskSubmitInfoMapper pcacPersonRiskSubmitInfoMapper;
    @Override
    public Page<RiskPersonResp> pageRiskPerson(RiskPersonReq riskPersonReq) {
        Page<PcacPersonRiskSubmitInfo> page = new Page<>(riskPersonReq.getPageNo(), riskPersonReq.getPageSize());
        Page<RiskPersonResp> pcacPersonRiskSubmitInfoPage =  pcacPersonRiskSubmitInfoMapper.pagePcacPersonRiskSubmitInfo(page, riskPersonReq);
        return pcacPersonRiskSubmitInfoPage;
    }
}
