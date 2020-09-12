package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.RiskMerchantRiskSyncInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.resquest.RiskMerchantRiskSyncInfoReq;

import java.util.List;

/**
* <p>
* 风控商户风险信息同步表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
public interface RiskMerchantRiskSyncInfoService {

    /**
    * 分页查询RiskMerchantRiskSyncInfo
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author cmcc
    * @since 2020-09-10
    */
    Page<RiskMerchantRiskSyncInfo> listRiskMerchantRiskSyncInfosByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询RiskMerchantRiskSyncInfo
    *
    * @param id 需要查询的RiskMerchantRiskSyncInfo的id
    * @return 返回对应id的RiskMerchantRiskSyncInfo对象
    * @author cmcc
    * @since 2020-09-10
    */
    RiskMerchantRiskSyncInfo getRiskMerchantRiskSyncInfoById(int id);

    /**
    * 插入RiskMerchantRiskSyncInfo
    *
    * @param riskMerchantRiskSyncInfo 需要插入的RiskMerchantRiskSyncInfo对象
    * @return 返回插入成功之后RiskMerchantRiskSyncInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int insertRiskMerchantRiskSyncInfo(RiskMerchantRiskSyncInfo riskMerchantRiskSyncInfo);

    /**
    * 根据id删除RiskMerchantRiskSyncInfo
    *
    * @param id 需要删除的RiskMerchantRiskSyncInfo对象的id
    * @return 返回被删除的RiskMerchantRiskSyncInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int deleteRiskMerchantRiskSyncInfoById(int id);

    /**
    * 根据id更新RiskMerchantRiskSyncInfo
    *
    * @param riskMerchantRiskSyncInfo 需要更新的RiskMerchantRiskSyncInfo对象
    * @return 返回被更新的RiskMerchantRiskSyncInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int updateRiskMerchantRiskSyncInfo(RiskMerchantRiskSyncInfo riskMerchantRiskSyncInfo);

    /**
     * 风险商户同步请求接口
     * @param riskMerchantList
     * @return Page<Boolean>
     */
    ResultBean<Boolean> addMerchant(List<RiskMerchantRiskSyncInfoReq> riskMerchantList);

}
