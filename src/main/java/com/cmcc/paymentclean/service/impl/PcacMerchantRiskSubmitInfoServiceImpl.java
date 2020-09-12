package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.SubmitStatusEnum;
import com.cmcc.paymentclean.entity.PcacMerchantRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskMerchantResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantReq;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.PcacMerchantRiskSubmitInfoMapper;
import com.cmcc.paymentclean.service.PcacMerchantRiskSubmitInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
* <p>
* 协会商户风险信息上报表  服务实现类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
@Slf4j
@Service
public class PcacMerchantRiskSubmitInfoServiceImpl extends ServiceImpl<PcacMerchantRiskSubmitInfoMapper, PcacMerchantRiskSubmitInfo> implements PcacMerchantRiskSubmitInfoService {

    @Override
    public Page<PcacMerchantRiskSubmitInfo> listPcacMerchantRiskSubmitInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询pcacMerchantRiskSubmitInfo: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<PcacMerchantRiskSubmitInfo> queryWrapper =  new QueryWrapper<PcacMerchantRiskSubmitInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<PcacMerchantRiskSubmitInfo> result = super.page(new Page<PcacMerchantRiskSubmitInfo>(page, pageSize),queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询pcacMerchantRiskSubmitInfo完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public PcacMerchantRiskSubmitInfo getPcacMerchantRiskSubmitInfoById(int id) {
        log.info("正在查询pcacMerchantRiskSubmitInfo中id为{}的数据",id);
        PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo = super.getById(id);
        log.info("查询id为{}的pcacMerchantRiskSubmitInfo{}",id,(null == pcacMerchantRiskSubmitInfo?"无结果":"成功"));
        return pcacMerchantRiskSubmitInfo;
    }

    @Override
    public int insertPcacMerchantRiskSubmitInfo(PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo) {
        log.info("正在插入pcacMerchantRiskSubmitInfo");
        if (super.save(pcacMerchantRiskSubmitInfo)) {
            log.info("插入pcacMerchantRiskSubmitInfo成功,id为{}",pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId());
            return pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId();
        } else {
            log.error("插入pcacMerchantRiskSubmitInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deletePcacMerchantRiskSubmitInfoById(int id) {
        log.info("正在删除id为{}的pcacMerchantRiskSubmitInfo",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的pcacMerchantRiskSubmitInfo成功",id);
            return id;
        } else {
            log.error("删除id为{}的pcacMerchantRiskSubmitInfo失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updatePcacMerchantRiskSubmitInfo(PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo) {
        log.info("正在更新id为{}的pcacMerchantRiskSubmitInfo",pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId());
        if (super.updateById(pcacMerchantRiskSubmitInfo)) {
            log.info("更新d为{}的pcacMerchantRiskSubmitInfo成功",pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId());
            return pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId();
        } else {
            log.error("更新id为{}的pcacMerchantRiskSubmitInfo失败",pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId());
            throw new BizException("更新失败[id=" + pcacMerchantRiskSubmitInfo.getPcacMerchantRiskSubmitInfoId() + "]");
        }
    }

    @Autowired
    private PcacMerchantRiskSubmitInfoMapper pcacMerchantRiskSubmitInfoMapper;

    @Override
    public ResultBean<Page<RiskMerchantResp>> pageRiskMerchant(RiskMerchantReq riskMerchantReq) {
        ResultBean<Page<RiskMerchantResp>> resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());

        Page<PcacMerchantRiskSubmitInfo> page = new Page<>(riskMerchantReq.getPageNo(), riskMerchantReq.getPageSize());
        Page<RiskMerchantResp> pagePcacMerchantRiskSubmitInfo =  pcacMerchantRiskSubmitInfoMapper.pagePcacMerchantRiskSubmitInfo(page, riskMerchantReq);
        List<RiskMerchantResp> riskMerchantResps = pagePcacMerchantRiskSubmitInfo.getRecords();
        if(!CollectionUtils.isEmpty(riskMerchantResps)){
            for(RiskMerchantResp riskMerchantResp:riskMerchantResps){
                String validStatus = (new Date().before(riskMerchantResp.getValidDate()))? CommonConst.VALIDSTATUS_01:CommonConst.VALIDSTATUS_02;
                riskMerchantResp.setValidStatus(validStatus);
                riskMerchantResp.setLegDocType(LegDocTypeEnum.getLegDocTypeDesc(riskMerchantResp.getLegDocType()));
                riskMerchantResp.setSubmitStatus(SubmitStatusEnum.getSubmitStatusEnumDesc(riskMerchantResp.getSubmitStatus()));
            }
        }
        resultBean.setData(pagePcacMerchantRiskSubmitInfo);
        return resultBean;
    }

}
