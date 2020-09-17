package com.cmcc.paymentclean.entity.dto.resquest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by lumma on 2020/9/17.
 */
@Data
@ApiModel(value = "批量企业商户查询请求参数")
public class BusinessInfoReq implements Serializable {

    @ApiModelProperty(value = "法人证件号码")
    private String docCode;

    @ApiModelProperty(value = "商户名称/企业名称")
    private String regName;

    @ApiModelProperty(value = "法定代表人（负责人） 证件类型")
    private String legDocType;

    @ApiModelProperty(value = "法定代表人（负责人）证件号码")
    private String legDocCode;

}
