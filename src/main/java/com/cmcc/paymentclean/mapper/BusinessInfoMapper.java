package com.cmcc.paymentclean.mapper;

import com.cmcc.paymentclean.entity.BusinessInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 企业商户信息表  Mapper 接口
* </p>
*
* @author cmcc
* @since 2020-09-15
*/
@Mapper
@Repository
public interface BusinessInfoMapper extends BaseMapper<BusinessInfo> {

}
