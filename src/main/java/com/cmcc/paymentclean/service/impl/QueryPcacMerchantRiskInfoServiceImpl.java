package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
import com.cmcc.paymentclean.mapper.QueryPcacMerchantRiskInfoMapper;
import com.cmcc.paymentclean.service.QueryPcacMerchantRiskInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.cmcc.paymentclean.exception.bizException.BizException;

/**
* <p>
*  服务实现类
* </p>
*
* @author zhaolei
* @since 2020-09-14
*/
@Slf4j
@Service
public class QueryPcacMerchantRiskInfoServiceImpl extends ServiceImpl<QueryPcacMerchantRiskInfoMapper, QueryPcacMerchantRiskInfo> implements QueryPcacMerchantRiskInfoService {

    @Override
    public Page<QueryPcacMerchantRiskInfo> listQueryPcacMerchantRiskInfosByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询queryPcacMerchantRiskInfo: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<QueryPcacMerchantRiskInfo> queryWrapper =  new QueryWrapper<QueryPcacMerchantRiskInfo>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<QueryPcacMerchantRiskInfo> result = super.page(new Page<QueryPcacMerchantRiskInfo>(page, pageSize),queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询queryPcacMerchantRiskInfo完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public QueryPcacMerchantRiskInfo getQueryPcacMerchantRiskInfoById(int id) {
        log.info("正在查询queryPcacMerchantRiskInfo中id为{}的数据",id);
        QueryPcacMerchantRiskInfo queryPcacMerchantRiskInfo = super.getById(id);
        log.info("查询id为{}的queryPcacMerchantRiskInfo{}",id,(null == queryPcacMerchantRiskInfo?"无结果":"成功"));
        return queryPcacMerchantRiskInfo;
    }

    @Override
    public int insertQueryPcacMerchantRiskInfo(QueryPcacMerchantRiskInfo queryPcacMerchantRiskInfo) {
        log.info("正在插入queryPcacMerchantRiskInfo");
        if (super.save(queryPcacMerchantRiskInfo)) {
            log.info("插入queryPcacMerchantRiskInfo成功,id为{}",queryPcacMerchantRiskInfo.getQueryPcacMerchantRiskInfoId());
            return queryPcacMerchantRiskInfo.getQueryPcacMerchantRiskInfoId();
        } else {
            log.error("插入queryPcacMerchantRiskInfo失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deleteQueryPcacMerchantRiskInfoById(int id) {
        log.info("正在删除id为{}的queryPcacMerchantRiskInfo",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的queryPcacMerchantRiskInfo成功",id);
            return id;
        } else {
            log.error("删除id为{}的queryPcacMerchantRiskInfo失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updateQueryPcacMerchantRiskInfo(QueryPcacMerchantRiskInfo queryPcacMerchantRiskInfo) {
        log.info("正在更新id为{}的queryPcacMerchantRiskInfo",queryPcacMerchantRiskInfo.getQueryPcacMerchantRiskInfoId());
        if (super.updateById(queryPcacMerchantRiskInfo)) {
            log.info("更新d为{}的queryPcacMerchantRiskInfo成功",queryPcacMerchantRiskInfo.getQueryPcacMerchantRiskInfoId());
            return queryPcacMerchantRiskInfo.getQueryPcacMerchantRiskInfoId();
        } else {
            log.error("更新id为{}的queryPcacMerchantRiskInfo失败",queryPcacMerchantRiskInfo.getQueryPcacMerchantRiskInfoId());
            throw new BizException("更新失败[id=" + queryPcacMerchantRiskInfo.getQueryPcacMerchantRiskInfoId() + "]");
        }
    }

}
