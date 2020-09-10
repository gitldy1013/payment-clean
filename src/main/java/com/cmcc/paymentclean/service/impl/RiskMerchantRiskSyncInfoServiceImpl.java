package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.entity.RiskMerchantRiskSyncInfo;
import com.cmcc.paymentclean.mapper.RiskMerchantRiskSyncInfoMapper;
import com.cmcc.paymentclean.service.RiskMerchantRiskSyncInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.cmcc.paymentclean.exception.bizException.BizException;

/**
* <p>
* 风控商户风险信息同步表  服务实现类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
@Slf4j
@Service
public class RiskMerchantRiskSyncInfoServiceImpl extends ServiceImpl<RiskMerchantRiskSyncInfoMapper, RiskMerchantRiskSyncInfo> implements RiskMerchantRiskSyncInfoService {

    @Override
    public Page<RiskMerchantRiskSyncInfo> listRiskMerchantRiskSyncInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询riskMerchantRiskSyncInfo: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<RiskMerchantRiskSyncInfo> queryWrapper =  new QueryWrapper<RiskMerchantRiskSyncInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<RiskMerchantRiskSyncInfo> result = super.page(new Page<RiskMerchantRiskSyncInfo>(page, pageSize),queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询riskMerchantRiskSyncInfo完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public RiskMerchantRiskSyncInfo getRiskMerchantRiskSyncInfoById(int id) {
        log.info("正在查询riskMerchantRiskSyncInfo中id为{}的数据",id);
        RiskMerchantRiskSyncInfo riskMerchantRiskSyncInfo = super.getById(id);
        log.info("查询id为{}的riskMerchantRiskSyncInfo{}",id,(null == riskMerchantRiskSyncInfo?"无结果":"成功"));
        return riskMerchantRiskSyncInfo;
    }

    @Override
    public int insertRiskMerchantRiskSyncInfo(RiskMerchantRiskSyncInfo riskMerchantRiskSyncInfo) {
        log.info("正在插入riskMerchantRiskSyncInfo");
        if (super.save(riskMerchantRiskSyncInfo)) {
            log.info("插入riskMerchantRiskSyncInfo成功,id为{}",riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId());
            return riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId();
        } else {
            log.error("插入riskMerchantRiskSyncInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteRiskMerchantRiskSyncInfoById(int id) {
        log.info("正在删除id为{}的riskMerchantRiskSyncInfo",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的riskMerchantRiskSyncInfo成功",id);
            return id;
        } else {
            log.error("删除id为{}的riskMerchantRiskSyncInfo失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateRiskMerchantRiskSyncInfo(RiskMerchantRiskSyncInfo riskMerchantRiskSyncInfo) {
        log.info("正在更新id为{}的riskMerchantRiskSyncInfo",riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId());
        if (super.updateById(riskMerchantRiskSyncInfo)) {
            log.info("更新d为{}的riskMerchantRiskSyncInfo成功",riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId());
            return riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId();
        } else {
            log.error("更新id为{}的riskMerchantRiskSyncInfo失败",riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId());
            throw new BizException("更新失败[id=" + riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId() + "]");
        }
    }

}
