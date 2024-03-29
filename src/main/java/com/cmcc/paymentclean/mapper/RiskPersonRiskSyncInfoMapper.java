package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cmcc.paymentclean.entity.RiskPersonRiskSyncInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 风控个人风险信息同步表 Mapper 接口
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Mapper
@Repository
public interface RiskPersonRiskSyncInfoMapper extends BaseMapper<RiskPersonRiskSyncInfo> {}
