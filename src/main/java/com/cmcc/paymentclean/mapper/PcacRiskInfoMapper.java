package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.PcacRiskInfo;
import com.cmcc.paymentclean.entity.dto.response.PcacRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.PcacRiskInfoReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
* <p>
* 商户黑名单提示信息表 Mapper 接口
* </p>
*
* @author cmcc
* @since 2020-09-08
*/
@Mapper
@Repository
public interface PcacRiskInfoMapper extends BaseMapper<PcacRiskInfo> {

    Page<PcacRiskInfoResp> pagePcacRiskInfo(Page page, @Param("req") PcacRiskInfoReq req);
}
