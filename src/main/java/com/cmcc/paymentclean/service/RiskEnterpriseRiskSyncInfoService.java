package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.RiskEnterpriseRiskSyncInfo;

/**
* <p>
* 风控企业风险信息同步表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
public interface RiskEnterpriseRiskSyncInfoService {

    /**
    * 分页查询RiskEnterpriseRiskSyncInfo
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author cmcc
    * @since 2020-09-10
    */
    Page<RiskEnterpriseRiskSyncInfo> listRiskEnterpriseRiskSyncInfosByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询RiskEnterpriseRiskSyncInfo
    *
    * @param id 需要查询的RiskEnterpriseRiskSyncInfo的id
    * @return 返回对应id的RiskEnterpriseRiskSyncInfo对象
    * @author cmcc
    * @since 2020-09-10
    */
    RiskEnterpriseRiskSyncInfo getRiskEnterpriseRiskSyncInfoById(int id);

    /**
    * 插入RiskEnterpriseRiskSyncInfo
    *
    * @param riskEnterpriseRiskSyncInfo 需要插入的RiskEnterpriseRiskSyncInfo对象
    * @return 返回插入成功之后RiskEnterpriseRiskSyncInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int insertRiskEnterpriseRiskSyncInfo(RiskEnterpriseRiskSyncInfo riskEnterpriseRiskSyncInfo);

    /**
    * 根据id删除RiskEnterpriseRiskSyncInfo
    *
    * @param id 需要删除的RiskEnterpriseRiskSyncInfo对象的id
    * @return 返回被删除的RiskEnterpriseRiskSyncInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int deleteRiskEnterpriseRiskSyncInfoById(int id);

    /**
    * 根据id更新RiskEnterpriseRiskSyncInfo
    *
    * @param riskEnterpriseRiskSyncInfo 需要更新的RiskEnterpriseRiskSyncInfo对象
    * @return 返回被更新的RiskEnterpriseRiskSyncInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int updateRiskEnterpriseRiskSyncInfo(RiskEnterpriseRiskSyncInfo riskEnterpriseRiskSyncInfo);

}