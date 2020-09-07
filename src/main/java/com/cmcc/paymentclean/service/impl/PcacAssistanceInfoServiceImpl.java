package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.entity.PcacAssistanceInfo;
import com.cmcc.paymentclean.mapper.PcacAssistanceInfoMapper;
import com.cmcc.paymentclean.service.PcacAssistanceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.cmcc.paymentclean.exception.bizException.BizException;

/**
* <p>
* 商户信息比对协查信息表 服务实现类
* </p>
*
* @author cmcc
* @since 2020-09-07
*/
@Slf4j
@Service
public class PcacAssistanceInfoServiceImpl extends ServiceImpl<PcacAssistanceInfoMapper, PcacAssistanceInfo> implements PcacAssistanceInfoService {

    @Override
    public Page<PcacAssistanceInfo> listPcacAssistanceInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询pcacAssistanceInfo: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<PcacAssistanceInfo> queryWrapper =  new QueryWrapper<PcacAssistanceInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<PcacAssistanceInfo> result = super.page(new Page<PcacAssistanceInfo>(page, pageSize));
        log.info("分页查询pcacAssistanceInfo完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public PcacAssistanceInfo getPcacAssistanceInfoById(int id) {
        log.info("正在查询pcacAssistanceInfo中id为{}的数据",id);
        PcacAssistanceInfo pcacAssistanceInfo = super.getById(id);
        log.info("查询id为{}的pcacAssistanceInfo{}",id,(null == pcacAssistanceInfo?"无结果":"成功"));
        return pcacAssistanceInfo;
    }

    @Override
    public int insertPcacAssistanceInfo(PcacAssistanceInfo pcacAssistanceInfo) {
        log.info("正在插入pcacAssistanceInfo");
        if (super.save(pcacAssistanceInfo)) {
            log.info("插入pcacAssistanceInfo成功,id为{}",pcacAssistanceInfo.getPcacAssistanceInfoId());
            return pcacAssistanceInfo.getPcacAssistanceInfoId();
        } else {
            log.error("插入pcacAssistanceInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deletePcacAssistanceInfoById(int id) {
        log.info("正在删除id为{}的pcacAssistanceInfo",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的pcacAssistanceInfo成功",id);
            return id;
        } else {
            log.error("删除id为{}的pcacAssistanceInfo失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updatePcacAssistanceInfo(PcacAssistanceInfo pcacAssistanceInfo) {
        log.info("正在更新id为{}的pcacAssistanceInfo",pcacAssistanceInfo.getPcacAssistanceInfoId());
        if (super.updateById(pcacAssistanceInfo)) {
            log.info("更新d为{}的pcacAssistanceInfo成功",pcacAssistanceInfo.getPcacAssistanceInfoId());
            return pcacAssistanceInfo.getPcacAssistanceInfoId();
        } else {
            log.error("更新id为{}的pcacAssistanceInfo失败",pcacAssistanceInfo.getPcacAssistanceInfoId());
            throw new BizException("更新失败[id=" + pcacAssistanceInfo.getPcacAssistanceInfoId() + "]");
        }
    }

}
