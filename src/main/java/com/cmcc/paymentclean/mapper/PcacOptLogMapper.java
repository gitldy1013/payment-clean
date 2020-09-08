package com.cmcc.paymentclean.mapper;

import com.cmcc.paymentclean.entity.PcacOptLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 操作日志表  Mapper 接口
* </p>
*
* @author cmcc
* @since 2020-09-08
*/
@Mapper
@Repository
public interface PcacOptLogMapper extends BaseMapper<PcacOptLog> {

}
