package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.LocalAssociatedRiskMerchantInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.AssociatedRiskMerchantInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.AssociatedRiskMerchantInfoReq;

/**
* <p>
* 本地关联风险商户信息表  服务类
* </p>
*
* @author cmcc
* @since 2020-09-10
*/
public interface LocalAssociatedRiskMerchantInfoService {

    /**
    * 分页查询LocalAssociatedRiskMerchantInfo
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author cmcc
    * @since 2020-09-10
    */
    Page<LocalAssociatedRiskMerchantInfo> listLocalAssociatedRiskMerchantInfosByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询LocalAssociatedRiskMerchantInfo
    *
    * @param id 需要查询的LocalAssociatedRiskMerchantInfo的id
    * @return 返回对应id的LocalAssociatedRiskMerchantInfo对象
    * @author cmcc
    * @since 2020-09-10
    */
    LocalAssociatedRiskMerchantInfo getLocalAssociatedRiskMerchantInfoById(int id);

    /**
    * 插入LocalAssociatedRiskMerchantInfo
    *
    * @param localAssociatedRiskMerchantInfo 需要插入的LocalAssociatedRiskMerchantInfo对象
    * @return 返回插入成功之后LocalAssociatedRiskMerchantInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int insertLocalAssociatedRiskMerchantInfo(LocalAssociatedRiskMerchantInfo localAssociatedRiskMerchantInfo);

    /**
    * 根据id删除LocalAssociatedRiskMerchantInfo
    *
    * @param id 需要删除的LocalAssociatedRiskMerchantInfo对象的id
    * @return 返回被删除的LocalAssociatedRiskMerchantInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int deleteLocalAssociatedRiskMerchantInfoById(int id);

    /**
    * 根据id更新LocalAssociatedRiskMerchantInfo
    *
    * @param localAssociatedRiskMerchantInfo 需要更新的LocalAssociatedRiskMerchantInfo对象
    * @return 返回被更新的LocalAssociatedRiskMerchantInfo对象的id
    * @author cmcc
    * @since 2020-09-10
    */
    int updateLocalAssociatedRiskMerchantInfo(LocalAssociatedRiskMerchantInfo localAssociatedRiskMerchantInfo);

    /**
     * 协会风险商户查询请求接口
     * @param associatedRiskMerchantInfoReq
     * @return Page<RiskPersonResp>
     */
    ResultBean<Page<AssociatedRiskMerchantInfoResp>> pageLocalAssociatedRiskMerchantInfo(AssociatedRiskMerchantInfoReq associatedRiskMerchantInfoReq);

}
