package com.cmcc.paymentclean.entity.dto.resquest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author zhaolei
 * @date 2020-09-17 17:25
 */
@Data
@ApiModel(value = "补发风险信息请求参数")
public class ReissueRiskInfoReq implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "申请补发类型， 01 黑名单 02 风险提示信息 03 ETC 风险信息")
    @NotBlank(message = "申请补发类型不能为空")
    String riskType;

    @ApiModelProperty(value = "请求重新推送日期，格式 YYYY-MM-DD")
    @NotBlank(message = "请求重新推送日期不能为空")
    @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}", message = "请求重新推送日期，格式 YYYY-MM-DD")
    String ReqDate;

    @ApiModelProperty(value = "请求重新推送结束日期，格式YYYY-MM-DD")
    @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}", message = "请求重新推送日期，格式 YYYY-MM-DD")
    String ReqDateEnd;


}
