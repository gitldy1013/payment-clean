package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.CusPropertyEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.RiskTypeEnum;
import com.cmcc.paymentclean.consts.SourChaEnum;
import com.cmcc.paymentclean.consts.SubmitStatusEnum;
import com.cmcc.paymentclean.entity.PcacPersonRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.PcacPersonRiskSubmitInfoMapper;
import com.cmcc.paymentclean.service.PcacPersonRiskSubmitInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
* <p>
* 协会个人风险信息上报表  服务实现类
* </p>
*
* @author zhaolei
* @since 2020-09-13
*/
@Slf4j
@Service
public class PcacPersonRiskSubmitInfoServiceImpl extends ServiceImpl<PcacPersonRiskSubmitInfoMapper, PcacPersonRiskSubmitInfo> implements PcacPersonRiskSubmitInfoService {

    @Override
    public Page<PcacPersonRiskSubmitInfo> listPcacPersonRiskSubmitInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询pcacPersonRiskSubmitInfo: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<PcacPersonRiskSubmitInfo> queryWrapper =  new QueryWrapper<PcacPersonRiskSubmitInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<PcacPersonRiskSubmitInfo> result = super.page(new Page<PcacPersonRiskSubmitInfo>(page, pageSize),queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询pcacPersonRiskSubmitInfo完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public PcacPersonRiskSubmitInfo getPcacPersonRiskSubmitInfoById(int id) {
        log.info("正在查询pcacPersonRiskSubmitInfo中id为{}的数据",id);
        PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo = super.getById(id);
        log.info("查询id为{}的pcacPersonRiskSubmitInfo{}",id,(null == pcacPersonRiskSubmitInfo?"无结果":"成功"));
        return pcacPersonRiskSubmitInfo;
    }

    @Override
    public int insertPcacPersonRiskSubmitInfo(PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo) {
        log.info("正在插入pcacPersonRiskSubmitInfo");
        if (super.save(pcacPersonRiskSubmitInfo)) {
            log.info("插入pcacPersonRiskSubmitInfo成功,id为{}",pcacPersonRiskSubmitInfo.getPcacPersonRiskSubmitInfoId());
            return pcacPersonRiskSubmitInfo.getPcacPersonRiskSubmitInfoId();
        } else {
            log.error("插入pcacPersonRiskSubmitInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deletePcacPersonRiskSubmitInfoById(int id) {
        log.info("正在删除id为{}的pcacPersonRiskSubmitInfo",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的pcacPersonRiskSubmitInfo成功",id);
            return id;
        } else {
            log.error("删除id为{}的pcacPersonRiskSubmitInfo失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updatePcacPersonRiskSubmitInfo(PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo) {
        log.info("正在更新id为{}的pcacPersonRiskSubmitInfo",pcacPersonRiskSubmitInfo.getPcacPersonRiskSubmitInfoId());
        if (super.updateById(pcacPersonRiskSubmitInfo)) {
            log.info("更新d为{}的pcacPersonRiskSubmitInfo成功",pcacPersonRiskSubmitInfo.getPcacPersonRiskSubmitInfoId());
            return pcacPersonRiskSubmitInfo.getPcacPersonRiskSubmitInfoId();
        } else {
            log.error("更新id为{}的pcacPersonRiskSubmitInfo失败",pcacPersonRiskSubmitInfo.getPcacPersonRiskSubmitInfoId());
            throw new BizException("更新失败[id=" + pcacPersonRiskSubmitInfo.getPcacPersonRiskSubmitInfoId() + "]");
        }
    }

    @Autowired
    private PcacPersonRiskSubmitInfoMapper pcacPersonRiskSubmitInfoMapper;


    @Override
    public ResultBean<Page<RiskPersonResp>> pageRiskPerson(RiskPersonReq riskPersonReq) {
        log.info("pageRiskPerson req={}", com.alibaba.fastjson.JSON.toJSON(riskPersonReq));
        ResultBean<Page<RiskPersonResp>> resultBean = new ResultBean();
        Page<PcacPersonRiskSubmitInfo> page = new Page<>(riskPersonReq.getPageNo(), riskPersonReq.getPageSize());
        Page<RiskPersonResp> pcacPersonRiskSubmitInfoPage =  pcacPersonRiskSubmitInfoMapper.pagePcacPersonRiskSubmitInfo(page, riskPersonReq);
        List<RiskPersonResp> riskPersonResps = pcacPersonRiskSubmitInfoPage.getRecords();
        if(!CollectionUtils.isEmpty(riskPersonResps)){
            for(RiskPersonResp riskPersonResp:riskPersonResps){
                String validStatus = (new Date().before(riskPersonResp.getValidDate()))? CommonConst.VALIDSTATUS_01:CommonConst.VALIDSTATUS_02;
                riskPersonResp.setValidStatus(validStatus);
                riskPersonResp.setSubmitStatus(SubmitStatusEnum.getSubmitStatusEnumDesc(riskPersonResp.getSubmitStatus()));
                riskPersonResp.setCusProperty(CusPropertyEnum.getCusPropertyEnum(riskPersonResp.getCusProperty()));
                riskPersonResp.setSubmitStatus(SubmitStatusEnum.getSubmitStatusEnumDesc(riskPersonResp.getSubmitStatus()));
                riskPersonResp.setDocType(LegDocTypeEnum.getLegDocTypeDesc(riskPersonResp.getDocType()));
                riskPersonResp.setSubmitStatus(SubmitStatusEnum.getSubmitStatusEnumDesc(riskPersonResp.getSubmitStatus()));
                riskPersonResp.setSourceChannel(SourChaEnum.getSourChaEnum(riskPersonResp.getSourceChannel()));
                riskPersonResp.setRiskType(RiskTypeEnum.getRiskTypeDesc(riskPersonResp.getRiskType()));
            }
        }
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        resultBean.setData(pcacPersonRiskSubmitInfoPage);
        log.info("pageRiskPerson resp={}", com.alibaba.fastjson.JSON.toJSON(pcacPersonRiskSubmitInfoPage));
        return resultBean;
    }
}
