package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.RiskPersonRiskSyncInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 风控个人风险信息同步表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
public interface RiskPersonRiskSyncInfoService {

    /**
    * 分页查询RiskPersonRiskSyncInfo
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author cmcc
    * @since 2020-09-10
    */
    Page<RiskPersonRiskSyncInfo> listRiskPersonRiskSyncInfosByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询RiskPersonRiskSyncInfo
    *
    * @param id 需要查询的RiskPersonRiskSyncInfo的id
    * @return 返回对应id的RiskPersonRiskSyncInfo对象
    * @author cmcc
    * @since 2020-09-10
    */
    RiskPersonRiskSyncInfo getRiskPersonRiskSyncInfoById(int id);

    /**
    * 插入RiskPersonRiskSyncInfo
    *
    * @param riskPersonRiskSyncInfo 需要插入的RiskPersonRiskSyncInfo对象
    * @return 返回插入成功之后RiskPersonRiskSyncInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int insertRiskPersonRiskSyncInfo(RiskPersonRiskSyncInfo riskPersonRiskSyncInfo);

    /**
    * 根据id删除RiskPersonRiskSyncInfo
    *
    * @param id 需要删除的RiskPersonRiskSyncInfo对象的id
    * @return 返回被删除的RiskPersonRiskSyncInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int deleteRiskPersonRiskSyncInfoById(int id);

    /**
    * 根据id更新RiskPersonRiskSyncInfo
    *
    * @param riskPersonRiskSyncInfo 需要更新的RiskPersonRiskSyncInfo对象
    * @return 返回被更新的RiskPersonRiskSyncInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int updateRiskPersonRiskSyncInfo(RiskPersonRiskSyncInfo riskPersonRiskSyncInfo);

}
