package com.cmcc.paymentclean.entity.dto.response;

import com.cmcc.paymentclean.consts.SysLanEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/** Created by lumma on 2020/9/10. */
@Data
@ApiModel(value = "风险商户查询结果参数")
public class RiskMerchantResp implements Serializable {
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "商户代码")
  private String cusCode;

  @ApiModelProperty(value = "商户简称")
  private String cusName;

  @ApiModelProperty(value = "商户名称")
  private String regName;

  @ApiModelProperty(value = "商户类型")
  private String cusType = "03";

  @ApiModelProperty(value = "信息类型")
  private String cusProperty;

  @ApiModelProperty(value = "风险类型")
  private String riskType;

  @ApiModelProperty(value = "风险信息等级")
  private String level;

  @ApiModelProperty(value = "商户属性")
  private String cusNature;

  @ApiModelProperty(value = "法人证件类型")
  private String docType;

  @ApiModelProperty(value = "法人证件号码")
  private String docCode;

  @ApiModelProperty(value = "法定代表人（负责人）姓名")
  private String legRepName;

  @ApiModelProperty(value = "法定代表人（负责人）证件类型")
  private String legDocType;

  @ApiModelProperty(value = "法定代表人（负责人）证件号码")
  private String legDocCode;

  @ApiModelProperty(value = "银行结算账号（支付账户）")
  private String bankNo;

  @ApiModelProperty(value = "开户行")
  private String openBank;

  @ApiModelProperty(value = "有效期")
  private Date validDate;

  @ApiModelProperty(value = "有效性")
  private String validStatus;

  @ApiModelProperty(value = "风险事件发生时间")
  private Date occurtimeb;

  @ApiModelProperty(value = "风险事件发生地域")
  private String occurarea;

  @ApiModelProperty(value = "风险事件描述")
  private String note;

  @ApiModelProperty(value = "风险信息来源")
  private String sourceChannel;

  @ApiModelProperty(value = "操作人")
  private String operator;

  @ApiModelProperty(value = "操作时间")
  private Date operateTime;

  @ApiModelProperty(value = "上报时间")
  private Date submitTime;

  @ApiModelProperty(value = "报送状态")
  private String submitStatus;

  @ApiModelProperty(value = "失败原因")
  private String failureReason;

  @ApiModelProperty(value = "信息类型")
  private String msgType;

  @ApiModelProperty(value = "本地商户类型")
  private String mercTyp;

  public String getOccurarea() {
    if ("1".equals(mercTyp) || "3".equals(mercTyp)) {
      occurarea = SysLanEnum.SysLanEnum_1.getDesc();
    }
    return occurarea;
  }
}
