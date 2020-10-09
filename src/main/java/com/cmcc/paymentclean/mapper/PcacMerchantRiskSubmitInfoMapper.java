package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.PcacMerchantRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.response.RiskMerchantResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 协会商户风险信息上报表 Mapper 接口
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Mapper
@Repository
public interface PcacMerchantRiskSubmitInfoMapper extends BaseMapper<PcacMerchantRiskSubmitInfo> {

  Page<RiskMerchantResp> pagePcacMerchantRiskSubmitInfo(
      Page page, @Param("req") RiskMerchantReq req);
}
