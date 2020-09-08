package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.PcacOptLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 操作日志表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-08
*/
public interface PcacOptLogService {

    /**
    * 分页查询PcacOptLog
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author cmcc
    * @since 2020-09-08
    */
    Page<PcacOptLog> listPcacOptLogsByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询PcacOptLog
    *
    * @param id 需要查询的PcacOptLog的id
    * @return 返回对应id的PcacOptLog对象
    * @author cmcc
    * @since 2020-09-08
    */
    PcacOptLog getPcacOptLogById(int id);

    /**
    * 插入PcacOptLog
    *
    * @param pcacOptLog 需要插入的PcacOptLog对象
    * @return 返回插入成功之后PcacOptLog对象的id
    * @author cmcc
    * @since 2020-09-08
    */
    int insertPcacOptLog(PcacOptLog pcacOptLog);

    /**
    * 根据id删除PcacOptLog
    *
    * @param id 需要删除的PcacOptLog对象的id
    * @return 返回被删除的PcacOptLog对象的id
    * @author cmcc
    * @since 2020-09-08
    */
    int deletePcacOptLogById(int id);

    /**
    * 根据id更新PcacOptLog
    *
    * @param pcacOptLog 需要更新的PcacOptLog对象
    * @return 返回被更新的PcacOptLog对象的id
    * @author cmcc
    * @since 2020-09-08
    */
    int updatePcacOptLog(PcacOptLog pcacOptLog);

}
