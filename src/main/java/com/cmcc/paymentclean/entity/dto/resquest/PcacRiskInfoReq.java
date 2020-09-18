package com.cmcc.paymentclean.entity.dto.resquest;

import com.cmcc.paymentclean.utils.PageVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lumma on 2020/9/11.
 */
@Data
@ApiModel(value = "协会风险商户查询请求参数")
public class PcacRiskInfoReq extends PageVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商户名称")
    private String regName;

    @ApiModelProperty(value = "法定代表人证件号码")
    private String legDocCode;

    @ApiModelProperty(value = "法人证件号码")
    private String docCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    @ApiModelProperty(value = "推送开始时间")
    private Date pushStartTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    @ApiModelProperty(value = "推送结束时间")
    private Date pushEndTime;

    @ApiModelProperty(value = "法人证件类型")
    private String docType;

    @ApiModelProperty(value = "法定代表人证件类型（负责人）")
    private String legDocType;
}
