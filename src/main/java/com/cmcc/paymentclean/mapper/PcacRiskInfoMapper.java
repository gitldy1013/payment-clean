package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.PcacRiskInfo;
import com.cmcc.paymentclean.entity.dto.response.PcacRiskInfoResp;
import com.cmcc.paymentclean.entity.dto.resquest.PcacRiskInfoReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* <p>
* 商户黑名单提示信息表 Mapper 接口
* </p>
*
* @author cmcc
* @since 2020-09-08
*/
@Mapper
@Repository
public interface PcacRiskInfoMapper extends BaseMapper<PcacRiskInfo> {

    Page<PcacRiskInfoResp> pagePcacRiskInfo(Page page, @Param("req") PcacRiskInfoReq req);

    void insertBatchPcacRiskInfo(@Param("items") ArrayList<PcacRiskInfo> pcacRiskInfoList);

    void updatePushStatus(@Param("ids")List<String> ids);

    //删除一日期范围内数据
    void deleteByDelMap(Map<String, String> deleteMap);
   //删除推送日一天数据
    void deleteByDayMap(Map<String,String> deleteMap);
}
