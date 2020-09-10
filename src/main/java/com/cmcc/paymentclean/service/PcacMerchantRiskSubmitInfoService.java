package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.PcacMerchantRiskSubmitInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 协会商户风险信息上报表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
public interface PcacMerchantRiskSubmitInfoService {

    /**
    * 分页查询PcacMerchantRiskSubmitInfo
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author cmcc
    * @since 2020-09-10
    */
    Page<PcacMerchantRiskSubmitInfo> listPcacMerchantRiskSubmitInfosByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询PcacMerchantRiskSubmitInfo
    *
    * @param id 需要查询的PcacMerchantRiskSubmitInfo的id
    * @return 返回对应id的PcacMerchantRiskSubmitInfo对象
    * @author cmcc
    * @since 2020-09-10
    */
    PcacMerchantRiskSubmitInfo getPcacMerchantRiskSubmitInfoById(int id);

    /**
    * 插入PcacMerchantRiskSubmitInfo
    *
    * @param pcacMerchantRiskSubmitInfo 需要插入的PcacMerchantRiskSubmitInfo对象
    * @return 返回插入成功之后PcacMerchantRiskSubmitInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int insertPcacMerchantRiskSubmitInfo(PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo);

    /**
    * 根据id删除PcacMerchantRiskSubmitInfo
    *
    * @param id 需要删除的PcacMerchantRiskSubmitInfo对象的id
    * @return 返回被删除的PcacMerchantRiskSubmitInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int deletePcacMerchantRiskSubmitInfoById(int id);

    /**
    * 根据id更新PcacMerchantRiskSubmitInfo
    *
    * @param pcacMerchantRiskSubmitInfo 需要更新的PcacMerchantRiskSubmitInfo对象
    * @return 返回被更新的PcacMerchantRiskSubmitInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int updatePcacMerchantRiskSubmitInfo(PcacMerchantRiskSubmitInfo pcacMerchantRiskSubmitInfo);

}
