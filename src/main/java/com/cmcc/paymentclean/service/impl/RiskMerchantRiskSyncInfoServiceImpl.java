package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.RiskMerchantRiskSyncInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantRiskSyncInfoReq;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.RiskMerchantRiskSyncInfoMapper;
import com.cmcc.paymentclean.service.RiskMerchantRiskSyncInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        log.info("正在执行分页查询riskMerchantRiskSyncInfo: page = {} pageSize = {} factor = {}", page, pageSize, factor);
        QueryWrapper<RiskMerchantRiskSyncInfo> queryWrapper = new QueryWrapper<RiskMerchantRiskSyncInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<RiskMerchantRiskSyncInfo> result = super.page(new Page<RiskMerchantRiskSyncInfo>(page, pageSize), queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询riskMerchantRiskSyncInfo完毕: 结果数 = {} ", result.getRecords().size());
        return result;
    }

    @Override
    public RiskMerchantRiskSyncInfo getRiskMerchantRiskSyncInfoById(int id) {
        log.info("正在查询riskMerchantRiskSyncInfo中id为{}的数据", id);
        RiskMerchantRiskSyncInfo riskMerchantRiskSyncInfo = super.getById(id);
        log.info("查询id为{}的riskMerchantRiskSyncInfo{}", id, (null == riskMerchantRiskSyncInfo ? "无结果" : "成功"));
        return riskMerchantRiskSyncInfo;
    }

    @Override
    public int insertRiskMerchantRiskSyncInfo(RiskMerchantRiskSyncInfo riskMerchantRiskSyncInfo) {
        log.info("正在插入riskMerchantRiskSyncInfo");
        if (super.save(riskMerchantRiskSyncInfo)) {
            log.info("插入riskMerchantRiskSyncInfo成功,id为{}", riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId());
            return riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId();
        } else {
            log.error("插入riskMerchantRiskSyncInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteRiskMerchantRiskSyncInfoById(int id) {
        log.info("正在删除id为{}的riskMerchantRiskSyncInfo", id);
        if (super.removeById(id)) {
            log.info("删除id为{}的riskMerchantRiskSyncInfo成功", id);
            return id;
        } else {
            log.error("删除id为{}的riskMerchantRiskSyncInfo失败", id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateRiskMerchantRiskSyncInfo(RiskMerchantRiskSyncInfo riskMerchantRiskSyncInfo) {
        log.info("正在更新id为{}的riskMerchantRiskSyncInfo", riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId());
        if (super.updateById(riskMerchantRiskSyncInfo)) {
            log.info("更新d为{}的riskMerchantRiskSyncInfo成功", riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId());
            return riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId();
        } else {
            log.error("更新id为{}的riskMerchantRiskSyncInfo失败", riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId());
            throw new BizException("更新失败[id=" + riskMerchantRiskSyncInfo.getRiskMerchantRiskSyncInfoId() + "]");
        }
    }

    @Override
    public ResultBean<Boolean> addMerchant(List<RiskMerchantRiskSyncInfoReq> riskMerchantList) {
        log.info("addMerchant req={}", com.alibaba.fastjson.JSON.toJSON(riskMerchantList));
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        List<RiskMerchantRiskSyncInfo> newRiskMerchantList = new ArrayList<>();
        if (CollectionUtils.isEmpty(riskMerchantList)) {
            return resultBean;
        }
        for (RiskMerchantRiskSyncInfoReq riskMerchant : riskMerchantList) {
            RiskMerchantRiskSyncInfo riskMerchantRiskSyncInfo = new RiskMerchantRiskSyncInfo();
            BeanUtils.copyProperties(riskMerchant, riskMerchantRiskSyncInfo);
            riskMerchantRiskSyncInfo.setRiskType(this.splitStrs(riskMerchantRiskSyncInfo.getRiskType()));
            riskMerchantRiskSyncInfo.setSourceChannel(this.splitStrs(riskMerchantRiskSyncInfo.getSourceChannel()));
            riskMerchantRiskSyncInfo.setOperateTime(new Date(System.currentTimeMillis()));
            QueryWrapper<RiskMerchantRiskSyncInfo> queryWrapper = new QueryWrapper();
            queryWrapper.eq("cus_code", riskMerchant.getCusCode());
            RiskMerchantRiskSyncInfo riskMerchant1 = super.getOne(queryWrapper);
            if (null != riskMerchant1) {
                UpdateWrapper<RiskMerchantRiskSyncInfo> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("risk_merchant_risk_sync_info_id", riskMerchant1.getRiskMerchantRiskSyncInfoId());
                super.update(riskMerchantRiskSyncInfo, updateWrapper);
            } else {
                newRiskMerchantList.add(riskMerchantRiskSyncInfo);
            }
        }
        if (!CollectionUtils.isEmpty(newRiskMerchantList)) {
            this.saveBatch(newRiskMerchantList);
        }
        return resultBean;
    }

    private String splitStrs(String strings){
        if(StringUtils.isEmpty(strings)){
            return strings;
        }
        String [] strs = strings.split("|");
        return strs[0];
    }
}
