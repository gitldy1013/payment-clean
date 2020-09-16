package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.response.QueryPcacMerchantRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskInfoReq;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskReq;

import java.util.List;

/**
* <p>
*  服务类
* </p>
*
* @author zhaolei
* @since 2020-09-14
*/
public interface QueryPcacMerchantRiskInfoService {

    ResultBean<Body> batchQueryPcacMerchantRisk(QueryPcacMerchantRiskReq queryPcacMerchantRiskReq);

    ResultBean<Page<QueryPcacMerchantRiskInfoResp>> pageLocalAssociatedRiskMerchantInfo(QueryPcacMerchantRiskInfoReq queryPcacMerchantRiskInfoReq);

    ResultBean<Body> exportExcel();
}
