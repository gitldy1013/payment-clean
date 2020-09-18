package com.cmcc.paymentclean.entity.dto.resquest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "批量商户风险信息查询使用情况反馈请求参数")
public class QueryPcacMerchantRiskInfoBackReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "风险反馈主键编码")
    private String id;

    @ApiModelProperty(value = "商户类型 01:自然人 02:企业商户 03:个体工商户 04:境外企业商户")
    private String cusType;

    @ApiModelProperty(value = "涉及结算金额（参考查询时间，近90天内结算总金额")
    private String amount;

    @ApiModelProperty(value = "处理结果 01. 终止合作 02. 拒绝拓展 03. 暂停办理资金结算 04. 冻结账户 05. 调整结算周期 06. 延迟资金结算 07. 设置收款限额 08. 暂停银行卡交易 09. 收回受理终端 (关闭网络支付接口) 10. 暂未采取控制措施,持续关注客户 11. 报送反洗钱可疑交易 99. 其他")
    private String handleResult;

    @ApiModelProperty(value = "处理时间 YYYY-MM-DD")
    private String handleTime;

    @ApiModelProperty(value = "交易币种 CNY:人民币 USD:美元 EUR:欧元 GBP:英镑 AUD:澳元 ……")
    private String currency;
}
