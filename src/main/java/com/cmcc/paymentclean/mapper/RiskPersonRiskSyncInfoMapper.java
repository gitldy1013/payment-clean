package com.cmcc.paymentclean.mapper;

import com.cmcc.paymentclean.entity.RiskPersonRiskSyncInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 风控个人风险信息同步表  Mapper 接口
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
@Mapper
@Repository
public interface RiskPersonRiskSyncInfoMapper extends BaseMapper<RiskPersonRiskSyncInfo> {

}
