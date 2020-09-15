package com.cmcc.paymentclean.entity.dto.resquest;

import com.cmcc.paymentclean.utils.PageVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lumma on 2020/9/14.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "商户风险信息查询使用情况查询请求参数")
public class QueryPcacMerchantRiskInfoReq extends PageVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "风险反馈主键编码")
    private String id;

    @ApiModelProperty(value = "商户类型")
    private String cusType;

    @ApiModelProperty(value = "商户编号")
    private String cusCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    @ApiModelProperty(value = "反馈开始日期")
    private Date feedbackStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    @ApiModelProperty(value = "反馈结束日期")
    private Date feedbackEndDate;

    @ApiModelProperty(value = "反馈状态")
    private String feedbackStatus;

}
