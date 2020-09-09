package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.PcacPersonRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lumma on 2020/9/9.
 */
@Mapper
@Repository
public interface PcacPersonRiskSubmitInfoMapper extends BaseMapper<PcacPersonRiskSubmitInfo> {

    Page<RiskPersonResp> pagePcacPersonRiskSubmitInfo(Page page, @Param("req") RiskPersonReq req);
}
