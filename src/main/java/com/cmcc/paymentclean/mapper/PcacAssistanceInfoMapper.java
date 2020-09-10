package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cmcc.paymentclean.entity.PcacAssistanceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 商户信息比对协查信息表 Mapper 接口
* </p>
*
* @author cmcc
* @since 2020-09-08
*/
@Mapper
@Repository
public interface PcacAssistanceInfoMapper extends BaseMapper<PcacAssistanceInfo> {

}
