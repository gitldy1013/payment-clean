package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.LocalAssociatedRiskMerchantInfo;
import com.cmcc.paymentclean.entity.dto.response.AssociatedRiskMerchantInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.AssociatedRiskMerchantInfoReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
* <p>
* 本地关联风险商户信息表  Mapper 接口
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
@Mapper
@Repository
public interface LocalAssociatedRiskMerchantInfoMapper extends BaseMapper<LocalAssociatedRiskMerchantInfo> {

    Page<AssociatedRiskMerchantInfoResp> pageLocalAssociatedRiskMerchantInfo(Page page, @Param("req") AssociatedRiskMerchantInfoReq req);
}
