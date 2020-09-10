package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.PcacEnterpriseRiskSubmitInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 协会企业风险信息上报表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
public interface PcacEnterpriseRiskSubmitInfoService {

    /**
    * 分页查询PcacEnterpriseRiskSubmitInfo
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author cmcc
    * @since 2020-09-10
    */
    Page<PcacEnterpriseRiskSubmitInfo> listPcacEnterpriseRiskSubmitInfosByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询PcacEnterpriseRiskSubmitInfo
    *
    * @param id 需要查询的PcacEnterpriseRiskSubmitInfo的id
    * @return 返回对应id的PcacEnterpriseRiskSubmitInfo对象
    * @author cmcc
    * @since 2020-09-10
    */
    PcacEnterpriseRiskSubmitInfo getPcacEnterpriseRiskSubmitInfoById(int id);

    /**
    * 插入PcacEnterpriseRiskSubmitInfo
    *
    * @param pcacEnterpriseRiskSubmitInfo 需要插入的PcacEnterpriseRiskSubmitInfo对象
    * @return 返回插入成功之后PcacEnterpriseRiskSubmitInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int insertPcacEnterpriseRiskSubmitInfo(PcacEnterpriseRiskSubmitInfo pcacEnterpriseRiskSubmitInfo);

    /**
    * 根据id删除PcacEnterpriseRiskSubmitInfo
    *
    * @param id 需要删除的PcacEnterpriseRiskSubmitInfo对象的id
    * @return 返回被删除的PcacEnterpriseRiskSubmitInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int deletePcacEnterpriseRiskSubmitInfoById(int id);

    /**
    * 根据id更新PcacEnterpriseRiskSubmitInfo
    *
    * @param pcacEnterpriseRiskSubmitInfo 需要更新的PcacEnterpriseRiskSubmitInfo对象
    * @return 返回被更新的PcacEnterpriseRiskSubmitInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int updatePcacEnterpriseRiskSubmitInfo(PcacEnterpriseRiskSubmitInfo pcacEnterpriseRiskSubmitInfo);

}
