package com.cmcc.paymentclean.entity.dto.resquest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "本地关联风险商户反馈请求参数")
public class AssociatedRiskMerchantInfoBackReq implements Serializable {
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "法人证件类型：01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他")
  private String docType;

  @ApiModelProperty(value = "法人证件号码")
  private String docCode;

  @ApiModelProperty(value = "涉及结算金额(后台计算)")
  private String Amount;

  @ApiModelProperty(
      value =
          "处理结果：01. 终止合作 02. 拒绝拓展 03. 暂停办理资金结算 04. 冻结账户 05. 调整结算周期 06. 延迟资金结算 07. 设置收款限额 08. 暂停银行卡交易 09. 收回受理终端 (关闭网络支付接口) 10. 暂未采取控制措施,持续关注客户 11. 报送反洗钱可疑交易 99. 其他")
  private String handleResult;

  @ApiModelProperty(value = "操作人")
  private String operator;
}
