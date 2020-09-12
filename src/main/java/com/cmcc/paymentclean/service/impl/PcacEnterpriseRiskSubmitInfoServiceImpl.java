package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.SubmitStatusEnum;
import com.cmcc.paymentclean.entity.PcacEnterpriseRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskEnterpriseResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskEnterpriseReq;
import com.cmcc.paymentclean.exception.InnerCipherException;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.PcacEnterpriseRiskSubmitInfoMapper;
import com.cmcc.paymentclean.service.PcacEnterpriseRiskSubmitInfoService;
import com.cmcc.paymentclean.utils.InnerCipherUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
* <p>
* 协会企业风险信息上报表  服务实现类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
@Slf4j
@Service
public class PcacEnterpriseRiskSubmitInfoServiceImpl extends ServiceImpl<PcacEnterpriseRiskSubmitInfoMapper, PcacEnterpriseRiskSubmitInfo> implements PcacEnterpriseRiskSubmitInfoService {

    @Override
    public Page<PcacEnterpriseRiskSubmitInfo> listPcacEnterpriseRiskSubmitInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询pcacEnterpriseRiskSubmitInfo: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<PcacEnterpriseRiskSubmitInfo> queryWrapper =  new QueryWrapper<PcacEnterpriseRiskSubmitInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<PcacEnterpriseRiskSubmitInfo> result = super.page(new Page<PcacEnterpriseRiskSubmitInfo>(page, pageSize),queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询pcacEnterpriseRiskSubmitInfo完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public PcacEnterpriseRiskSubmitInfo getPcacEnterpriseRiskSubmitInfoById(int id) {
        log.info("正在查询pcacEnterpriseRiskSubmitInfo中id为{}的数据",id);
        PcacEnterpriseRiskSubmitInfo pcacEnterpriseRiskSubmitInfo = super.getById(id);
        log.info("查询id为{}的pcacEnterpriseRiskSubmitInfo{}",id,(null == pcacEnterpriseRiskSubmitInfo?"无结果":"成功"));
        return pcacEnterpriseRiskSubmitInfo;
    }

    @Override
    public int insertPcacEnterpriseRiskSubmitInfo(PcacEnterpriseRiskSubmitInfo pcacEnterpriseRiskSubmitInfo) {
        log.info("正在插入pcacEnterpriseRiskSubmitInfo");
        if (super.save(pcacEnterpriseRiskSubmitInfo)) {
            log.info("插入pcacEnterpriseRiskSubmitInfo成功,id为{}",pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId());
            return pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId();
        } else {
            log.error("插入pcacEnterpriseRiskSubmitInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deletePcacEnterpriseRiskSubmitInfoById(int id) {
        log.info("正在删除id为{}的pcacEnterpriseRiskSubmitInfo",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的pcacEnterpriseRiskSubmitInfo成功",id);
            return id;
        } else {
            log.error("删除id为{}的pcacEnterpriseRiskSubmitInfo失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updatePcacEnterpriseRiskSubmitInfo(PcacEnterpriseRiskSubmitInfo pcacEnterpriseRiskSubmitInfo) {
        log.info("正在更新id为{}的pcacEnterpriseRiskSubmitInfo",pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId());
        if (super.updateById(pcacEnterpriseRiskSubmitInfo)) {
            log.info("更新d为{}的pcacEnterpriseRiskSubmitInfo成功",pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId());
            return pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId();
        } else {
            log.error("更新id为{}的pcacEnterpriseRiskSubmitInfo失败",pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId());
            throw new BizException("更新失败[id=" + pcacEnterpriseRiskSubmitInfo.getPcacEnterpriseRiskSubmitInfoId() + "]");
        }
    }

    @Autowired
    private PcacEnterpriseRiskSubmitInfoMapper pcacEnterpriseRiskSubmitInfoMapper;

    @Override
    public ResultBean<Page<RiskEnterpriseResp>> pageRiskEnterprise(RiskEnterpriseReq riskEnterpriseReq) {
        ResultBean<Page<RiskEnterpriseResp>> resultBean = new ResultBean();
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());

        Page<RiskEnterpriseResp> page = new Page<>(riskEnterpriseReq.getPageNo(), riskEnterpriseReq.getPageSize());
        Page<RiskEnterpriseResp> pagePcacEnterpriseRiskSubmitInfo =  pcacEnterpriseRiskSubmitInfoMapper.pagePcacEnterpriseRiskSubmitInfo(page, riskEnterpriseReq);
        List<RiskEnterpriseResp> riskEnterpriseResps = pagePcacEnterpriseRiskSubmitInfo.getRecords();
        if(!CollectionUtils.isEmpty(riskEnterpriseResps)){
            for(RiskEnterpriseResp riskEnterpriseResp:riskEnterpriseResps){
                String validStatus = (new Date().before(riskEnterpriseResp.getValidDate()))? CommonConst.VALIDSTATUS_01:CommonConst.VALIDSTATUS_02;
                riskEnterpriseResp.setValidStatus(validStatus);
                riskEnterpriseResp.setLegDocType(LegDocTypeEnum.getLegDocTypeDesc(riskEnterpriseResp.getLegDocType()));
                riskEnterpriseResp.setSubmitStatus(SubmitStatusEnum.getSubmitStatusEnumDesc(riskEnterpriseResp.getSubmitStatus()));
            }
        }
        resultBean.setData(pagePcacEnterpriseRiskSubmitInfo);
        return resultBean;
    }

}
