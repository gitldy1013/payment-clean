package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.entity.PcacAssistanceInfo;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.PcacAssistanceInfoMapper;
import com.cmcc.paymentclean.service.PcacAssistanceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* <p>
* 商户信息比对协查信息表 服务实现类
* </p>
*
* @author cmcc
* @since 2020-09-08
*/
@Slf4j
@Service
public class PcacAssistanceInfoServiceImpl extends ServiceImpl<PcacAssistanceInfoMapper, PcacAssistanceInfo> implements PcacAssistanceInfoService {

}
