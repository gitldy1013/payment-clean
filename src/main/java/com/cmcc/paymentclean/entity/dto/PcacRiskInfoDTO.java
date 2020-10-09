package com.cmcc.paymentclean.entity.dto;

import com.cmcc.paymentclean.annotation.ExcelExportField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/** Created by lumma on 2020/9/15. */
@Data
@EqualsAndHashCode(callSuper = false)
public class PcacRiskInfoDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "id序号")
  private String pcacRiskInfoId;

  @ApiModelProperty(value = "推送名单类型")
  private String pushListType;

  @ExcelExportField(name = "推送日期", index = 1)
  @ApiModelProperty(value = "推送日期")
  private String upDate;

  @ExcelExportField(name = "商户名称", index = 2)
  @ApiModelProperty(value = "商户名称")
  private String regName;

  @ExcelExportField(name = "商户简称", index = 3)
  @ApiModelProperty(value = "商户简称")
  private String cusName;

  @ExcelExportField(name = "法人证件类型", index = 4)
  @ApiModelProperty(value = "法人证件类型")
  private String docType;

  @ExcelExportField(name = "法人证件号码", index = 5)
  @ApiModelProperty(value = "法人证件号码")
  private String docCode;

  @ExcelExportField(name = "法定代表人姓名", index = 6)
  @ApiModelProperty(value = "法定代表人姓名")
  private String legDocName;

  @ExcelExportField(name = "法定代表人类型", index = 7)
  @ApiModelProperty(value = "法定代表人类型")
  private String legDocType;

  @ExcelExportField(name = "法定代表人（负责人） 证件号码", index = 8)
  @ApiModelProperty(value = "法定代表人（负责人） 证件号码")
  private String legDocCode;

  @ExcelExportField(name = "风险信息等级", index = 9)
  @ApiModelProperty(value = "风险信息等级")
  private String level;

  @ExcelExportField(name = "风险类型", index = 10)
  @ApiModelProperty(value = "风险类型")
  private String riskType;

  @ExcelExportField(name = "有效期", index = 11)
  @ApiModelProperty(value = "有效期")
  private String validDate;

  @ExcelExportField(name = "有效性", index = 12)
  @ApiModelProperty(value = "有效性")
  private String validStatus;

  @ExcelExportField(name = "商户类型", index = 13)
  @ApiModelProperty(value = "商户类型")
  private String cusType;

  @ExcelExportField(name = "风险事件发生地域", index = 14)
  @ApiModelProperty(value = "风险事件发生地域，省级/地市，可多选，逗号隔开")
  private String occurarea;

  @ExcelExportField(name = "银行结算账户", index = 15)
  @ApiModelProperty(value = "银行结算账户")
  private String bankNo;

  @ExcelExportField(name = "网址", index = 16)
  @ApiModelProperty(value = "网址")
  private String url;

  @ExcelExportField(name = "商户注册号", index = 17)
  @ApiModelProperty(value = "商户注册号")
  private String registeredCode;

  @ApiModelProperty(value = "推送状态0为未推送，1为已推送")
  private String pushStatus;
}
