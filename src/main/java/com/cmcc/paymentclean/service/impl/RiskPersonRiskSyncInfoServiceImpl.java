package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.RiskPersonRiskSyncInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonRiskSyncInfoReq;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.RiskPersonRiskSyncInfoMapper;
import com.cmcc.paymentclean.service.RiskPersonRiskSyncInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* <p>
* 风控个人风险信息同步表  服务实现类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
@Slf4j
@Service
public class RiskPersonRiskSyncInfoServiceImpl extends ServiceImpl<RiskPersonRiskSyncInfoMapper, RiskPersonRiskSyncInfo> implements RiskPersonRiskSyncInfoService {

    @Override
    public Page<RiskPersonRiskSyncInfo> listRiskPersonRiskSyncInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询riskPersonRiskSyncInfo: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<RiskPersonRiskSyncInfo> queryWrapper =  new QueryWrapper<RiskPersonRiskSyncInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<RiskPersonRiskSyncInfo> result = super.page(new Page<RiskPersonRiskSyncInfo>(page, pageSize),queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询riskPersonRiskSyncInfo完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public RiskPersonRiskSyncInfo getRiskPersonRiskSyncInfoById(int id) {
        log.info("正在查询riskPersonRiskSyncInfo中id为{}的数据",id);
        RiskPersonRiskSyncInfo riskPersonRiskSyncInfo = super.getById(id);
        log.info("查询id为{}的riskPersonRiskSyncInfo{}",id,(null == riskPersonRiskSyncInfo?"无结果":"成功"));
        return riskPersonRiskSyncInfo;
    }

    @Override
    public int insertRiskPersonRiskSyncInfo(RiskPersonRiskSyncInfo riskPersonRiskSyncInfo) {
        log.info("正在插入riskPersonRiskSyncInfo");
        if (super.save(riskPersonRiskSyncInfo)) {
            log.info("插入riskPersonRiskSyncInfo成功,id为{}",riskPersonRiskSyncInfo.getRiskPersonRiskSyncInfoId());
            return riskPersonRiskSyncInfo.getRiskPersonRiskSyncInfoId();
        } else {
            log.error("插入riskPersonRiskSyncInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteRiskPersonRiskSyncInfoById(int id) {
        log.info("正在删除id为{}的riskPersonRiskSyncInfo",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的riskPersonRiskSyncInfo成功",id);
            return id;
        } else {
            log.error("删除id为{}的riskPersonRiskSyncInfo失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateRiskPersonRiskSyncInfo(RiskPersonRiskSyncInfo riskPersonRiskSyncInfo) {
        log.info("正在更新id为{}的riskPersonRiskSyncInfo",riskPersonRiskSyncInfo.getRiskPersonRiskSyncInfoId());
        if (super.updateById(riskPersonRiskSyncInfo)) {
            log.info("更新d为{}的riskPersonRiskSyncInfo成功",riskPersonRiskSyncInfo.getRiskPersonRiskSyncInfoId());
            return riskPersonRiskSyncInfo.getRiskPersonRiskSyncInfoId();
        } else {
            log.error("更新id为{}的riskPersonRiskSyncInfo失败",riskPersonRiskSyncInfo.getRiskPersonRiskSyncInfoId());
            throw new BizException("更新失败[id=" + riskPersonRiskSyncInfo.getRiskPersonRiskSyncInfoId() + "]");
        }
    }

    @Override
    public ResultBean<Boolean> addRiskPerson(List<RiskPersonRiskSyncInfoReq> riskPersonList) {
        ResultBean resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        if(!CollectionUtils.isEmpty(riskPersonList)){
            List<RiskPersonRiskSyncInfo> newRiskPersonList = new ArrayList<>();
            for(RiskPersonRiskSyncInfoReq riskPerson:riskPersonList){
                RiskPersonRiskSyncInfo riskPersonRiskSyncInfo = new RiskPersonRiskSyncInfo();
                BeanUtils.copyProperties(riskPerson, riskPersonRiskSyncInfo);
                riskPersonRiskSyncInfo.setOperateTime(LocalDate.now());
                QueryWrapper<RiskPersonRiskSyncInfo> queryWrapper = new QueryWrapper();
                queryWrapper.eq("usrNo",riskPerson.getUsrNo());
                RiskPersonRiskSyncInfo riskPerson1 = super.getOne(queryWrapper);
                if(null!=riskPerson1){
                    UpdateWrapper<RiskPersonRiskSyncInfo> updateWrapper = new UpdateWrapper<>();
                    updateWrapper.eq("risk_person_risk_sync_info_id",riskPerson1.getRiskPersonRiskSyncInfoId());
                    super.update(riskPersonRiskSyncInfo,updateWrapper);
                }else{
                    newRiskPersonList.add(riskPersonRiskSyncInfo);
                }
            }
            if(!CollectionUtils.isEmpty(newRiskPersonList)){
                this.saveBatch(newRiskPersonList);
            }
            return resultBean;
        }

        return resultBean;
    }
}
