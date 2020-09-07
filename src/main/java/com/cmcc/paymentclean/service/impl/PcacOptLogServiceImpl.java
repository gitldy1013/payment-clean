package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.entity.PcacOptLog;
import com.cmcc.paymentclean.mapper.PcacOptLogMapper;
import com.cmcc.paymentclean.service.PcacOptLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.cmcc.paymentclean.exception.bizException.BizException;

/**
* <p>
* 操作日志表  服务实现类
* </p>
*
* @author cmcc
* @since 2020-09-07
*/
@Slf4j
@Service
public class PcacOptLogServiceImpl extends ServiceImpl<PcacOptLogMapper, PcacOptLog> implements PcacOptLogService {

    @Override
    public Page<PcacOptLog> listPcacOptLogsByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询pcacOptLog: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<PcacOptLog> queryWrapper =  new QueryWrapper<PcacOptLog>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<PcacOptLog> result = super.page(new Page<PcacOptLog>(page, pageSize));
        log.info("分页查询pcacOptLog完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

    @Override
    public PcacOptLog getPcacOptLogById(int id) {
        log.info("正在查询pcacOptLog中id为{}的数据",id);
        PcacOptLog pcacOptLog = super.getById(id);
        log.info("查询id为{}的pcacOptLog{}",id,(null == pcacOptLog?"无结果":"成功"));
        return pcacOptLog;
    }

    @Override
    public int insertPcacOptLog(PcacOptLog pcacOptLog) {
        log.info("正在插入pcacOptLog");
        if (super.save(pcacOptLog)) {
            log.info("插入pcacOptLog成功,id为{}",pcacOptLog.getPcacOptLogId());
            return pcacOptLog.getPcacOptLogId();
        } else {
            log.error("插入pcacOptLog失败");
            throw new BizException("添加失败");
        }
    }

    @Override
    public int deletePcacOptLogById(int id) {
        log.info("正在删除id为{}的pcacOptLog",id);
        if (super.removeById(id)) {
            log.info("删除id为{}的pcacOptLog成功",id);
            return id;
        } else {
            log.error("删除id为{}的pcacOptLog失败",id);
            throw new BizException("删除失败[id=" + id + "]");
        }
    }

    @Override
    public int updatePcacOptLog(PcacOptLog pcacOptLog) {
        log.info("正在更新id为{}的pcacOptLog",pcacOptLog.getPcacOptLogId());
        if (super.updateById(pcacOptLog)) {
            log.info("更新d为{}的pcacOptLog成功",pcacOptLog.getPcacOptLogId());
            return pcacOptLog.getPcacOptLogId();
        } else {
            log.error("更新id为{}的pcacOptLog失败",pcacOptLog.getPcacOptLogId());
            throw new BizException("更新失败[id=" + pcacOptLog.getPcacOptLogId() + "]");
        }
    }

}
