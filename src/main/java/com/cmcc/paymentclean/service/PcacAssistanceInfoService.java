package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.PcacAssistanceInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 商户信息比对协查信息表 服务类
* </p>
*
* @author cmcc
* @since 2020-09-07
*/
public interface PcacAssistanceInfoService {

    /**
    * 分页查询PcacAssistanceInfo
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author cmcc
    * @since 2020-09-07
    */
    Page<PcacAssistanceInfo> listPcacAssistanceInfosByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询PcacAssistanceInfo
    *
    * @param id 需要查询的PcacAssistanceInfo的id
    * @return 返回对应id的PcacAssistanceInfo对象
    * @author cmcc
    * @since 2020-09-07
    */
    PcacAssistanceInfo getPcacAssistanceInfoById(int id);

    /**
    * 插入PcacAssistanceInfo
    *
    * @param pcacAssistanceInfo 需要插入的PcacAssistanceInfo对象
    * @return 返回插入成功之后PcacAssistanceInfo对象的id
    * @author cmcc
    * @since 2020-09-07
    */
    int insertPcacAssistanceInfo(PcacAssistanceInfo pcacAssistanceInfo);

    /**
    * 根据id删除PcacAssistanceInfo
    *
    * @param id 需要删除的PcacAssistanceInfo对象的id
    * @return 返回被删除的PcacAssistanceInfo对象的id
    * @author cmcc
    * @since 2020-09-07
    */
    int deletePcacAssistanceInfoById(int id);

    /**
    * 根据id更新PcacAssistanceInfo
    *
    * @param pcacAssistanceInfo 需要更新的PcacAssistanceInfo对象
    * @return 返回被更新的PcacAssistanceInfo对象的id
    * @author cmcc
    * @since 2020-09-07
    */
    int updatePcacAssistanceInfo(PcacAssistanceInfo pcacAssistanceInfo);

}
