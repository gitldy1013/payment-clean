package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cmcc.paymentclean.entity.RiskEnterpriseRiskSyncInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 风控企业风险信息同步表  Mapper 接口
* </p>
*
* @author zhaolei
* @since 2020-09-11
*/
@Mapper
@Repository
public interface RiskEnterpriseRiskSyncInfoMapper extends BaseMapper<RiskEnterpriseRiskSyncInfo> {

}
