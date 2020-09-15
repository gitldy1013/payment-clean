package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskReq;
import com.cmcc.paymentclean.mapper.QueryPcacMerchantRiskInfoMapper;
import com.cmcc.paymentclean.service.QueryPcacMerchantRiskInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.cmcc.paymentclean.exception.bizException.BizException;

import java.util.List;

/**
* <p>
*  服务实现类
* </p>
*
* @author zhaolei
* @since 2020-09-14
*/
@Slf4j
@Service
public class QueryPcacMerchantRiskInfoServiceImpl extends ServiceImpl<QueryPcacMerchantRiskInfoMapper, QueryPcacMerchantRiskInfo> implements QueryPcacMerchantRiskInfoService {

    @Override
    public ResultBean<Body> batchQueryPcacMerchantRisk(List<QueryPcacMerchantRiskReq> queryPcacMerchantRiskReqs) {
        return null;
    }

}
