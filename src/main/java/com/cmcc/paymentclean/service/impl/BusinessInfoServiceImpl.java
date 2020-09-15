package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.entity.BusinessInfo;
import com.cmcc.paymentclean.mapper.BusinessInfoMapper;
import com.cmcc.paymentclean.service.BusinessInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.cmcc.paymentclean.exception.bizException.BizException;

/**
* <p>
* 企业商户信息表  服务实现类
* </p>
*
* @author cmcc
* @since 2020-09-15
*/
@Slf4j
@Service
public class BusinessInfoServiceImpl extends ServiceImpl<BusinessInfoMapper, BusinessInfo> implements BusinessInfoService {

    @Override
    public Page<BusinessInfo> listBusinessInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询businessInfo: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<BusinessInfo> queryWrapper =  new QueryWrapper<BusinessInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<BusinessInfo> result = super.page(new Page<BusinessInfo>(page, pageSize),queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询businessInfo完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public BusinessInfo getBusinessInfoById(int id) {
        log.info("正在查询businessInfo中id为{}的数据",id);
        BusinessInfo businessInfo = super.getById(id);
        log.info("查询id为{}的businessInfo{}",id,(null == businessInfo?"无结果":"成功"));
        return businessInfo;
    }

    @Override
    public int insertBusinessInfo(BusinessInfo businessInfo) {
        log.info("正在插入businessInfo");
        if (super.save(businessInfo)) {
            log.info("插入businessInfo成功,id为{}",businessInfo.getBusinessInfoId());
            return businessInfo.getBusinessInfoId();
        } else {
            log.error("插入businessInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteBusinessInfoById(int id) {
        log.info("正在删除id为{}的businessInfo",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的businessInfo成功",id);
            return id;
        } else {
            log.error("删除id为{}的businessInfo失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateBusinessInfo(BusinessInfo businessInfo) {
        log.info("正在更新id为{}的businessInfo",businessInfo.getBusinessInfoId());
        if (super.updateById(businessInfo)) {
            log.info("更新d为{}的businessInfo成功",businessInfo.getBusinessInfoId());
            return businessInfo.getBusinessInfoId();
        } else {
            log.error("更新id为{}的businessInfo失败",businessInfo.getBusinessInfoId());
            throw new BizException("更新失败[id=" + businessInfo.getBusinessInfoId() + "]");
        }
    }

}
