package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.PcacEnterpriseRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.response.RiskEnterpriseResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskEnterpriseReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
* <p>
* 协会企业风险信息上报表  Mapper 接口
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
@Mapper
@Repository
public interface PcacEnterpriseRiskSubmitInfoMapper extends BaseMapper<PcacEnterpriseRiskSubmitInfo> {
    Page<RiskEnterpriseResp> pagePcacEnterpriseRiskSubmitInfo(Page page, @Param("req") RiskEnterpriseReq req);
}
