package com.cmcc.paymentclean.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cmcc.paymentclean.entity.PcacPersonRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.response.RiskPersonResp;
import com.cmcc.paymentclean.entity.dto.resquest.RiskPersonReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 协会个人风险信息上报表 Mapper 接口
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Mapper
@Repository
public interface PcacPersonRiskSubmitInfoMapper extends BaseMapper<PcacPersonRiskSubmitInfo> {

  Page<RiskPersonResp> pagePcacPersonRiskSubmitInfo(Page page, @Param("req") RiskPersonReq req);

  List<PcacPersonRiskSubmitInfo> selectPcacPersonRiskSubmitInfoList();

  void updateByPcacPersonRiskSubmitInfo(PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo);
}
