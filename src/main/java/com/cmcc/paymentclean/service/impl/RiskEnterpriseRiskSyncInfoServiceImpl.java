package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.entity.RiskEnterpriseRiskSyncInfo;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.RiskEnterpriseRiskSyncInfoMapper;
import com.cmcc.paymentclean.service.RiskEnterpriseRiskSyncInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* <p>
* 风控企业风险信息同步表  服务实现类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
@Slf4j
@Service
public class RiskEnterpriseRiskSyncInfoServiceImpl extends ServiceImpl<RiskEnterpriseRiskSyncInfoMapper, RiskEnterpriseRiskSyncInfo> implements RiskEnterpriseRiskSyncInfoService {

    @Override
    public Page<RiskEnterpriseRiskSyncInfo> listRiskEnterpriseRiskSyncInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询riskEnterpriseRiskSyncInfo: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<RiskEnterpriseRiskSyncInfo> queryWrapper =  new QueryWrapper<RiskEnterpriseRiskSyncInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<RiskEnterpriseRiskSyncInfo> result = super.page(new Page<RiskEnterpriseRiskSyncInfo>(page, pageSize),queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询riskEnterpriseRiskSyncInfo完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public RiskEnterpriseRiskSyncInfo getRiskEnterpriseRiskSyncInfoById(int id) {
        log.info("正在查询riskEnterpriseRiskSyncInfo中id为{}的数据",id);
        RiskEnterpriseRiskSyncInfo riskEnterpriseRiskSyncInfo = super.getById(id);
        log.info("查询id为{}的riskEnterpriseRiskSyncInfo{}",id,(null == riskEnterpriseRiskSyncInfo?"无结果":"成功"));
        return riskEnterpriseRiskSyncInfo;
    }

    @Override
    public int insertRiskEnterpriseRiskSyncInfo(RiskEnterpriseRiskSyncInfo riskEnterpriseRiskSyncInfo) {
        log.info("正在插入riskEnterpriseRiskSyncInfo");
        if (super.save(riskEnterpriseRiskSyncInfo)) {
            log.info("插入riskEnterpriseRiskSyncInfo成功,id为{}",riskEnterpriseRiskSyncInfo.getRiskEnterpriseRiskSyncInfoId());
            return riskEnterpriseRiskSyncInfo.getRiskEnterpriseRiskSyncInfoId();
        } else {
            log.error("插入riskEnterpriseRiskSyncInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteRiskEnterpriseRiskSyncInfoById(int id) {
        log.info("正在删除id为{}的riskEnterpriseRiskSyncInfo",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的riskEnterpriseRiskSyncInfo成功",id);
            return id;
        } else {
            log.error("删除id为{}的riskEnterpriseRiskSyncInfo失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateRiskEnterpriseRiskSyncInfo(RiskEnterpriseRiskSyncInfo riskEnterpriseRiskSyncInfo) {
        log.info("正在更新id为{}的riskEnterpriseRiskSyncInfo",riskEnterpriseRiskSyncInfo.getRiskEnterpriseRiskSyncInfoId());
        if (super.updateById(riskEnterpriseRiskSyncInfo)) {
            log.info("更新d为{}的riskEnterpriseRiskSyncInfo成功",riskEnterpriseRiskSyncInfo.getRiskEnterpriseRiskSyncInfoId());
            return riskEnterpriseRiskSyncInfo.getRiskEnterpriseRiskSyncInfoId();
        } else {
            log.error("更新id为{}的riskEnterpriseRiskSyncInfo失败",riskEnterpriseRiskSyncInfo.getRiskEnterpriseRiskSyncInfoId());
            throw new BizException("更新失败[id=" + riskEnterpriseRiskSyncInfo.getRiskEnterpriseRiskSyncInfoId() + "]");
        }
    }

}