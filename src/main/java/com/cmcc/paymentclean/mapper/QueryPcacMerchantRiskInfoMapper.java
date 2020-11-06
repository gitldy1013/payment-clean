package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
import com.cmcc.paymentclean.entity.dto.response.QueryPcacMerchantRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskInfoBackReq;
import com.cmcc.paymentclean.entity.dto.resquest.QueryPcacMerchantRiskInfoReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author zhaolei
 * @since 2020-09-14
 */
@Mapper
@Repository
public interface QueryPcacMerchantRiskInfoMapper extends BaseMapper<QueryPcacMerchantRiskInfo> {

  Page<QueryPcacMerchantRiskInfoResp> pageLocalAssociatedRiskMerchantInfo(
      Page page, @Param("req") QueryPcacMerchantRiskInfoReq req);

  List<QueryPcacMerchantRiskInfoResp> qryByPushStatus(@Param("pushStatus") String pushStatus);

  void updatePushStatus(@Param("ids") List<String> ids);

  void updateByProId(@Param("req")QueryPcacMerchantRiskInfoBackReq queryPcacMerchantRiskInfoBackReq);
}
