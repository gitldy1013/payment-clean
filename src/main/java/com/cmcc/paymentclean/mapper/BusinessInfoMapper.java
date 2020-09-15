package com.cmcc.paymentclean.mapper;

import com.cmcc.paymentclean.entity.BusinessInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cmcc.paymentclean.entity.dto.response.BusinessInfoResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


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

    List<BusinessInfoResp> qryBySubmitStatus(@Param("submitStatus")String submitStatus);

    void updateSubmitStatus(@Param("ids")List<String> ids);

}
