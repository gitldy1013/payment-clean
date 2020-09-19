package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.PcacAssistanceInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
* <p>
* 商户信息比对协查信息表 服务类
* </p>
*
* @author cmcc
* @since 2020-09-08
*/
@Service
public interface PcacAssistanceInfoService {

    String saveAssistanceInfo(ArrayList<PcacAssistanceInfo> assistanceInfoList);
}
