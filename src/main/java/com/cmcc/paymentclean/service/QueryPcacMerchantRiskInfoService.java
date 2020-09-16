package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.response.QueryPcacMerchantRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskInfoBackReq;
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

    /**
     * 批量商户风险信息导入查询
     * @param queryPcacMerchantRiskReq
     * @return
     */
    ResultBean<Body> batchQueryPcacMerchantRisk(QueryPcacMerchantRiskReq queryPcacMerchantRiskReq);

    ResultBean<Page<QueryPcacMerchantRiskInfoResp>> pageLocalAssociatedRiskMerchantInfo(QueryPcacMerchantRiskInfoReq queryPcacMerchantRiskInfoReq);

    ResultBean<Body> exportExcel();

    /**
     * 批量商户风险信息查询使用情况反馈
     * @param queryPcacMerchantRiskInfoBackReq
     * @return
     */
    ResultBean<Body> queryPcacMerchantRiskInfoBack(List<QueryPcacMerchantRiskInfoBackReq> queryPcacMerchantRiskInfoBackReq);
}
