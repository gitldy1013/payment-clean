package com.cmcc.paymentclean.mapper;

import com.cmcc.paymentclean.entity.LocalAssociatedRiskMerchantInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
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

}
