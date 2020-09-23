package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.CusPropertyEnum;
import com.cmcc.paymentclean.consts.DocTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.RiskTypeEnum;
import com.cmcc.paymentclean.consts.SourChaEnum;
import com.cmcc.paymentclean.consts.SubmitStatusEnum;
import com.cmcc.paymentclean.entity.PcacPersonRiskSubmitInfo;
import com.cmcc.paymentclean.entity.SysLan;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;
import com.cmcc.paymentclean.mapper.PcacPersonRiskSubmitInfoMapper;
import com.cmcc.paymentclean.service.PcacPersonRiskSubmitInfoService;
import com.cmcc.paymentclean.service.SysLanService;
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

    @Autowired
    private PcacPersonRiskSubmitInfoMapper pcacPersonRiskSubmitInfoMapper;

    @Autowired
    private SysLanService sysLanService;

    @Override
    public ResultBean<Page<RiskPersonResp>> pageRiskPerson(RiskPersonReq riskPersonReq) {
        log.info("pageRiskPerson req={}", com.alibaba.fastjson.JSON.toJSON(riskPersonReq));
        ResultBean<Page<RiskPersonResp>> resultBean = new ResultBean<>();
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
                riskPersonResp.setDocType(DocTypeEnum.getDocTypeDesc(riskPersonResp.getDocType()));
                riskPersonResp.setSubmitStatus(SubmitStatusEnum.getSubmitStatusEnumDesc(riskPersonResp.getSubmitStatus()));
                riskPersonResp.setSourceChannel(SourChaEnum.getSourChaEnum(riskPersonResp.getSourceChannel()));
                riskPersonResp.setRiskType(RiskTypeEnum.getRiskTypeDesc(riskPersonResp.getRiskType()));
                SysLan sysLan = sysLanService.getLanInfoById(riskPersonResp.getOccurarea());
                if(null != sysLan){
                    riskPersonResp.setOccurarea(sysLan.getLanName());
                }
            }
        }
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        resultBean.setData(pcacPersonRiskSubmitInfoPage);
        log.info("pageRiskPerson resp={}", com.alibaba.fastjson.JSON.toJSON(pcacPersonRiskSubmitInfoPage));
        return resultBean;
    }
}
