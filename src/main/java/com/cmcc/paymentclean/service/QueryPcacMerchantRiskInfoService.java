package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.QueryPcacMerchantRiskInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
*  服务类
* </p>
*
* @author zhaolei
* @since 2020-09-14
*/
public interface QueryPcacMerchantRiskInfoService {

    /**
    * 分页查询QueryPcacMerchantRiskInfo
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author zhaolei
    * @since 2020-09-14
    */
    Page<QueryPcacMerchantRiskInfo> listQueryPcacMerchantRiskInfosByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询QueryPcacMerchantRiskInfo
    *
    * @param id 需要查询的QueryPcacMerchantRiskInfo的id
    * @return 返回对应id的QueryPcacMerchantRiskInfo对象
    * @author zhaolei
    * @since 2020-09-14
    */
    QueryPcacMerchantRiskInfo getQueryPcacMerchantRiskInfoById(int id);

    /**
    * 插入QueryPcacMerchantRiskInfo
    *
    * @param queryPcacMerchantRiskInfo 需要插入的QueryPcacMerchantRiskInfo对象
    * @return 返回插入成功之后QueryPcacMerchantRiskInfo对象的id
    * @author zhaolei
    * @since 2020-09-14
    */
    int insertQueryPcacMerchantRiskInfo(QueryPcacMerchantRiskInfo queryPcacMerchantRiskInfo);

    /**
    * 根据id删除QueryPcacMerchantRiskInfo
    *
    * @param id 需要删除的QueryPcacMerchantRiskInfo对象的id
    * @return 返回被删除的QueryPcacMerchantRiskInfo对象的id
    * @author zhaolei
    * @since 2020-09-14
    */
    int deleteQueryPcacMerchantRiskInfoById(int id);

    /**
    * 根据id更新QueryPcacMerchantRiskInfo
    *
    * @param queryPcacMerchantRiskInfo 需要更新的QueryPcacMerchantRiskInfo对象
    * @return 返回被更新的QueryPcacMerchantRiskInfo对象的id
    * @author zhaolei
    * @since 2020-09-14
    */
    int updateQueryPcacMerchantRiskInfo(QueryPcacMerchantRiskInfo queryPcacMerchantRiskInfo);

}
