package com.cmcc.paymentclean.entity.dto.resquest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "批量商户风险信息导入查询请求参数")
public class QueryPcacMerchantRiskReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户属性:01：个人 02：商户 03: ETC 04：企业")
    private String cusProperty;

    @ApiModelProperty(value = "关键字：01：商户简称 03：法人证件号码 04：服务器 IP 05：法定代表人（负责人）手机号 06：商户名称 07：法定代表人（负责人）证件号码 08：银行结算账号 09：网址 10：ICP 备案编号")
    private String keyWord;

    @ApiModelProperty(value = "查询条件信息（多条数据以逗号分隔）")
    private String infos;
}
