package com.cmcc.paymentclean.entity.dto.resquest;

import com.cmcc.paymentclean.utils.PageVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lumma on 2020/9/9.
 *
 * @author lumma
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "风险个人查询请求参数")
@ToString
public class RiskPersonReq extends PageVO implements Serializable {
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "内部用户号")
  private String usrNo;

  @ApiModelProperty(value = "手机号")
  private String mobileNo;

  @ApiModelProperty(value = "证件类型")
  private String docType;

  @ApiModelProperty(value = "证件号码")
  private String docCode;

  @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
  @ApiModelProperty(value = "操作开始时间")
  private Date operateStartTime;

  @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
  @ApiModelProperty(value = "操作结束时间")
  private Date operateEndTime;

  @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
  @ApiModelProperty(value = "上报开始时间")
  private Date submitStartTime;

  @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
  @ApiModelProperty(value = "上报结束时间")
  private Date submitEndTime;

  @ApiModelProperty(value = "报送状态")
  private String submitStatus;

  @ApiModelProperty(value = "操作人")
  private String operator;
}
