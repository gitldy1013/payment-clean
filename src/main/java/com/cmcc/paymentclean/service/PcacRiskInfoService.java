package com.cmcc.paymentclean.service;

import com.cmcc.paymentclean.entity.PcacRiskInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* <p>
* 商户黑名单提示信息表 服务类
* </p>
*
* @author cmcc
* @since 2020-09-07
*/
public interface PcacRiskInfoService {

    /**
    * 分页查询PcacRiskInfo
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author cmcc
    * @since 2020-09-07
    */
    Page<PcacRiskInfo> listPcacRiskInfosByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询PcacRiskInfo
    *
    * @param id 需要查询的PcacRiskInfo的id
    * @return 返回对应id的PcacRiskInfo对象
    * @author cmcc
    * @since 2020-09-07
    */
    PcacRiskInfo getPcacRiskInfoById(int id);

    /**
    * 插入PcacRiskInfo
    *
    * @param pcacRiskInfo 需要插入的PcacRiskInfo对象
    * @return 返回插入成功之后PcacRiskInfo对象的id
    * @author cmcc
    * @since 2020-09-07
    */
    int insertPcacRiskInfo(PcacRiskInfo pcacRiskInfo);

    /**
    * 根据id删除PcacRiskInfo
    *
    * @param id 需要删除的PcacRiskInfo对象的id
    * @return 返回被删除的PcacRiskInfo对象的id
    * @author cmcc
    * @since 2020-09-07
    */
    int deletePcacRiskInfoById(int id);

    /**
    * 根据id更新PcacRiskInfo
    *
    * @param pcacRiskInfo 需要更新的PcacRiskInfo对象
    * @return 返回被更新的PcacRiskInfo对象的id
    * @author cmcc
    * @since 2020-09-07
    */
    int updatePcacRiskInfo(PcacRiskInfo pcacRiskInfo);

}
