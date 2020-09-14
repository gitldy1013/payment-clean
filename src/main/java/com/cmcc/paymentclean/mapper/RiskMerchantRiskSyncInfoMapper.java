package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cmcc.paymentclean.entity.RiskMerchantRiskSyncInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 风控商户风险信息同步表  Mapper 接口
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
@Mapper
@Repository
public interface RiskMerchantRiskSyncInfoMapper extends BaseMapper<RiskMerchantRiskSyncInfo> {

}
