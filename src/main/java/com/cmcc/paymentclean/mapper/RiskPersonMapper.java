package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cmcc.paymentclean.entity.RiskPerson;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by lumma on 2020/9/9.
 * @author lumma
 */
@Mapper
@Repository
public interface RiskPersonMapper extends BaseMapper<RiskPerson> {
}
