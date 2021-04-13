package com.cmcc.paymentclean.entity.dto.resquest;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/** Created by lumma on 2020/9/9. */
@Data
@ApiModel(value = "RiskMerchant对象", description = "风控商户风险信息同步表")
@TableName("risk_merchant_risk_sync_info")
@ToString
public class RiskMerchantRiskSyncInfoReq implements Serializable {
  private static final long serialVersionUID = 1L;

  @NotNull(message = "商户类型不能为空")
  @ApiModelProperty(value = "商户类型")
  private String cusType;

  @NotNull(message = "风险类型不能为空")
  @ApiModelProperty(value = "风险类型")
  private String riskType;

  @NotNull(message = "商户属性不能为空")
  @ApiModelProperty(value = "商户属性")
  private String cusNature;

  @NotNull(message = "商户代码不能为空")
  @ApiModelProperty(value = "商户代码，最长不能超过 32 个字符")
  private String cusCode;

  @NotNull(message = "风险信息等级不能为空")
  @ApiModelProperty(value = "风险信息等级")
  private String level;

  @NotNull(message = "有效期不能为空")
  @ApiModelProperty(value = "有效期")
  @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
  private Date validDate;

  @NotNull(message = "风险事件发生时间不能为空")
  @ApiModelProperty(value = "风险事件发生时间")
  @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
  private Date occurtimeb;

  @NotNull(message = "风险事件结束时间不能为空")
  @ApiModelProperty(value = "风险事件结束时间")
  @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
  private Date occurtimee;

  @ApiModelProperty(value = "风险事件描述")
  private String note;

  @NotNull(message = "风险信息来源不能为空")
  @ApiModelProperty(value = "风险信息来源")
  private String sourceChannel;

  @NotNull(message = "操作人不能为空")
  @ApiModelProperty(value = "操作人")
  private String operator;
}
