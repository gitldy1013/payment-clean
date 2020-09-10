package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.PcacMerchantRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.response.RiskMerchantReqResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lumma on 2020/9/10.
 */
@Mapper
@Repository
public interface PcacMerchantRiskSubmitInfoMapper extends BaseMapper<PcacMerchantRiskSubmitInfo> {

    Page<RiskMerchantReqResp> pagePcacMerchantRiskSubmitInfo(Page page, @Param("req") RiskMerchantReq req);
}
