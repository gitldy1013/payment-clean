package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.consts.CommonConst;
import com.cmcc.paymentclean.consts.IsBlackEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.PcacRiskInfo;
import com.cmcc.paymentclean.entity.dto.PcacRiskInfoDTO;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.PcacRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.PcacRiskInfoReq;
import com.cmcc.paymentclean.exception.bizException.BizException;
import com.cmcc.paymentclean.mapper.PcacRiskInfoMapper;
import com.cmcc.paymentclean.service.PcacRiskInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* <p>
* 商户黑名单提示信息表 服务实现类
* </p>
*
* @author cmcc
* @since 2020-09-08
*/
@Slf4j
@Service
public class PcacRiskInfoServiceImpl extends ServiceImpl<PcacRiskInfoMapper, PcacRiskInfo> implements PcacRiskInfoService {

    @Override
    public Page<PcacRiskInfo> listPcacRiskInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询pcacRiskInfo: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<PcacRiskInfo> queryWrapper =  new QueryWrapper<PcacRiskInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<PcacRiskInfo> result = super.page(new Page<PcacRiskInfo>(page, pageSize),queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询pcacRiskInfo完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public PcacRiskInfo getPcacRiskInfoById(int id) {
        log.info("正在查询pcacRiskInfo中id为{}的数据",id);
        PcacRiskInfo pcacRiskInfo = super.getById(id);
        log.info("查询id为{}的pcacRiskInfo{}",id,(null == pcacRiskInfo?"无结果":"成功"));
        return pcacRiskInfo;
    }

    @Override
    public int insertPcacRiskInfo(PcacRiskInfo pcacRiskInfo) {
        log.info("正在插入pcacRiskInfo");
        if (super.save(pcacRiskInfo)) {
            log.info("插入pcacRiskInfo成功,id为{}",pcacRiskInfo.getPcacRiskInfoId());
            return pcacRiskInfo.getPcacRiskInfoId();
        } else {
            log.error("插入pcacRiskInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deletePcacRiskInfoById(int id) {
        log.info("正在删除id为{}的pcacRiskInfo",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的pcacRiskInfo成功",id);
            return id;
        } else {
            log.error("删除id为{}的pcacRiskInfo失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updatePcacRiskInfo(PcacRiskInfo pcacRiskInfo) {
        log.info("正在更新id为{}的pcacRiskInfo",pcacRiskInfo.getPcacRiskInfoId());
        if (super.updateById(pcacRiskInfo)) {
            log.info("更新d为{}的pcacRiskInfo成功",pcacRiskInfo.getPcacRiskInfoId());
            return pcacRiskInfo.getPcacRiskInfoId();
        } else {
            log.error("更新id为{}的pcacRiskInfo失败",pcacRiskInfo.getPcacRiskInfoId());
            throw new BizException("更新失败[id=" + pcacRiskInfo.getPcacRiskInfoId() + "]");
        }
    }

    @Autowired
    private PcacRiskInfoMapper pcacRiskInfoMapper;

    @Override
    public ResultBean<Page<PcacRiskInfoResp>> pagePcacRiskInfo(PcacRiskInfoReq riskInfoReq) {
        ResultBean<Page<PcacRiskInfoResp>> resultBean = new ResultBean();
        Page<PcacRiskInfoResp> page = new Page<>(riskInfoReq.getPageNo(), riskInfoReq.getPageSize());
        Page<PcacRiskInfoResp> pcacPersonRiskSubmitInfoPage =  pcacRiskInfoMapper.pagePcacRiskInfo(page, riskInfoReq);
        List<PcacRiskInfoResp> riskPersonResps = pcacPersonRiskSubmitInfoPage.getRecords();
        if(!CollectionUtils.isEmpty(riskPersonResps)){
            for(PcacRiskInfoResp riskPersonResp:riskPersonResps){
                String validStatus = (new Date().before(riskPersonResp.getValidDate()))? CommonConst.VALIDSTATUS_01:CommonConst.VALIDSTATUS_02;
                riskPersonResp.setValidStatus(validStatus);
                riskPersonResp.setLegDocType(LegDocTypeEnum.getLegDocTypeDesc(riskPersonResp.getLegDocType()));
            }
        }
        resultBean.setResCode(ResultCodeEnum.SUCCESS.getCode());
        resultBean.setResMsg(ResultCodeEnum.SUCCESS.getDesc());
        resultBean.setData(pcacPersonRiskSubmitInfoPage);
        return resultBean;
    }

    @Override
    public List<PcacRiskInfoDTO> listByIsBlack(String pushListType) {
        List<PcacRiskInfoDTO> pcacRiskInfoDTOs = new ArrayList<>();
        if(StringUtils.isEmpty(pushListType)){
            pushListType = IsBlackEnum.ISBLACKE_01.getCode();
        }
        QueryWrapper<PcacRiskInfo> queryWrapper = new QueryWrapper();
        queryWrapper.eq("push_List_Type",pushListType);

        List<PcacRiskInfo> pcacRiskInfos =  this.list(queryWrapper);
        if(!CollectionUtils.isEmpty(pcacRiskInfos)){
            for(PcacRiskInfo pcacRiskInfo:pcacRiskInfos){
                PcacRiskInfoDTO pcacRiskInfoDTO = new PcacRiskInfoDTO();
                BeanUtils.copyProperties(pcacRiskInfo,pcacRiskInfoDTO);
                try {
                    String regName= new String(pcacRiskInfo.getRegName(),"UTF-8");
                    pcacRiskInfoDTO.setRegName(regName);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                pcacRiskInfoDTOs.add(pcacRiskInfoDTO);
            }
        }

        return pcacRiskInfoDTOs;
    }

}
