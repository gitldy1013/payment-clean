package com.cmcc.paymentclean.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.PcacPersonRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;

/**
* <p>
* 协会个人风险信息上报表  服务类
* </p>
*
* @author zhaolei
* @since 2020-09-13
*/
public interface PcacPersonRiskSubmitInfoService {

    /**
    * 分页查询PcacPersonRiskSubmitInfo
    *
    * @param page     当前页数
    * @param pageSize 页的大小
    * @param factor  搜索关键词
    * @return 返回mybatis-plus的Page对象,其中records字段为符合条件的查询结果
    * @author zhaolei
    * @since 2020-09-13
    */
    Page<PcacPersonRiskSubmitInfo> listPcacPersonRiskSubmitInfosByPage(int page, int pageSize, String factor);

    /**
    * 根据id查询PcacPersonRiskSubmitInfo
    *
    * @param id 需要查询的PcacPersonRiskSubmitInfo的id
    * @return 返回对应id的PcacPersonRiskSubmitInfo对象
    * @author zhaolei
    * @since 2020-09-13
    */
    PcacPersonRiskSubmitInfo getPcacPersonRiskSubmitInfoById(int id);

    /**
    * 插入PcacPersonRiskSubmitInfo
    *
    * @param pcacPersonRiskSubmitInfo 需要插入的PcacPersonRiskSubmitInfo对象
    * @return 返回插入成功之后PcacPersonRiskSubmitInfo对象的id
    * @author zhaolei
    * @since 2020-09-13
    */
    int insertPcacPersonRiskSubmitInfo(PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo);

    /**
    * 根据id删除PcacPersonRiskSubmitInfo
    *
    * @param id 需要删除的PcacPersonRiskSubmitInfo对象的id
    * @return 返回被删除的PcacPersonRiskSubmitInfo对象的id
    * @author zhaolei
    * @since 2020-09-13
    */
    int deletePcacPersonRiskSubmitInfoById(int id);

    /**
    * 根据id更新PcacPersonRiskSubmitInfo
    *
    * @param pcacPersonRiskSubmitInfo 需要更新的PcacPersonRiskSubmitInfo对象
    * @return 返回被更新的PcacPersonRiskSubmitInfo对象的id
    * @author zhaolei
    * @since 2020-09-13
    */
    int updatePcacPersonRiskSubmitInfo(PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo);

    /**
     * 风险个人查询请求接口
     * @param riskPersonReq
     * @return Page<RiskPersonResp>
     */
    ResultBean<Page<RiskPersonResp>> pageRiskPerson(RiskPersonReq riskPersonReq);

}
