package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.BusinessInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;

/**
* <p>
* 企业商户信息表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-15
*/
public interface BusinessInfoService {

    /**
    * 分页查询BusinessInfo
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author cmcc
    * @since 2020-09-15
    */
    Page<BusinessInfo> listBusinessInfosByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询BusinessInfo
    *
    * @param id 需要查询的BusinessInfo的id
    * @return 返回对应id的BusinessInfo对象
    * @author cmcc
    * @since 2020-09-15
    */
    BusinessInfo getBusinessInfoById(int id);

    /**
    * 插入BusinessInfo
    *
    * @param businessInfo 需要插入的BusinessInfo对象
    * @return 返回插入成功之后BusinessInfo对象的id
    * @author cmcc
    * @since 2020-09-15
    */
    int insertBusinessInfo(BusinessInfo businessInfo);

    /**
    * 根据id删除BusinessInfo
    *
    * @param id 需要删除的BusinessInfo对象的id
    * @return 返回被删除的BusinessInfo对象的id
    * @author cmcc
    * @since 2020-09-15
    */
    int deleteBusinessInfoById(int id);

    /**
    * 根据id更新BusinessInfo
    *
    * @param businessInfo 需要更新的BusinessInfo对象
    * @return 返回被更新的BusinessInfo对象的id
    * @author cmcc
    * @since 2020-09-15
    */
    int updateBusinessInfo(BusinessInfo businessInfo);

    ResultBean<Body> exportExcel();

    /**
     * 企业商户查询本地数据库推送至协会
     */
    void queryBusinessInfoAndPushPcac();
}
