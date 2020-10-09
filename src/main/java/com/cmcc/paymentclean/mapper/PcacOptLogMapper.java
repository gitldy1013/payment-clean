package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cmcc.paymentclean.entity.PcacOptLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 操作日志表 Mapper 接口
 *
 * @author cmcc
 * @since 2020-09-08
 */
@Mapper
@Repository
public interface PcacOptLogMapper extends BaseMapper<PcacOptLog> {}
