package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.entity.SysLan;
import com.cmcc.paymentclean.mapper.SysLanMapper;
import com.cmcc.paymentclean.service.SysLanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by lumma on 2020/9/21.
 */
@Slf4j
@Service
public class SysLanServiceImpl extends ServiceImpl<SysLanMapper, SysLan> implements SysLanService {
    @Override
    public SysLan getLanInfoById(String lanId) {
        if(StringUtils.isEmpty(lanId)){
            return new SysLan();
        }
        QueryWrapper<SysLan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lan_id",lanId);
        return this.getOne(queryWrapper);
    }
}
