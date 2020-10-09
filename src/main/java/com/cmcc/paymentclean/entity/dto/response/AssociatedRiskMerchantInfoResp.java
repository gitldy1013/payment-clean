package com.cmcc.paymentclean.entity.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/** Created by lumma on 2020/9/12. */
@Data
@ApiModel(value = "本地关联风险商户查询请求结果 参数")
public class AssociatedRiskMerchantInfoResp implements Serializable {
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "关联商户编号")
  private String cusCode;

  @ApiModelProperty(value = "推送名单类型")
  private String pushListType;

  @ApiModelProperty(value = "推送名单类型")
  private Date upDate;

  @ApiModelProperty(value = "风险信息等级")
  private String level;

  @ApiModelProperty(
      value =
          "风险类型:01 ：虚假申请 02 ：套现、套积分 03 ：违法违规经营 04 ：销赃或协助转移赃款 05 ： 买卖或租借银行（支付）账户 06 ：侧录点(恶意) "
              + "07 ：伪卡集中使用点(恶意) 08 ：泄露账户及交易信息 09 ：恶意倒闭 10：恶意分单 11 ：移机 12 ：高风险商户 13 ：商户合谋欺诈 14 ：破产或停业商户 15 ：强迫交易 "
              + "17：频繁变更服务机构 18：关联商户涉险 19：买卖银行卡信息 20：拒刷信用卡 21：转嫁手续费 22:支付敏感信息泄露 23:非法改装终端 24:切机 25:二清 26:套码 27:冒用申请 "
              + "28:侧录点(非恶意) 29:洗钱行为 30:套汇 31:逃汇 32:骗汇 33:分拆交易 34:按金交易 35:境内外有权机构发布名单 36:发卡侧风险 37:恶意注册 38:伪造、变造票据 "
              + "39:伪造、变造签章 40:跨境支付虚假、盗用或冒用申请 41:跨境支付大额交易客户、异常客户 42:跨境赌博 43:跨境赌博资金中转 44:伪卡集中使用点(非恶意) "
              + "45:受理终端(网络支付接口、收款码)挪作违法违规用途 46：赌博 47：赌博资金中转 99：其他")
  private String riskType;

  @ApiModelProperty(value = "商户简称")
  private String cusName;

  @ApiModelProperty(value = "商户名称")
  private String regName;

  @ApiModelProperty(
      value =
          "处理结果:01. 终止合作 02. 拒绝拓展 03. 暂停办理资金结算 04. 冻结账户 05. 调整结算周期 06. 延迟资金结算 07. 设置收款限额 08. 暂停银行卡交易 "
              + "09. 收回受理终端 (关闭网络支付接口) 10. 暂未采取控制措施,持续关注客户 11. 报送反洗钱可疑交易 99. 其他")
  private String handleResult;

  @ApiModelProperty(value = "反馈状态")
  private String feedbackStatus;

  @ApiModelProperty(value = "反馈日期")
  private Date feedbackDate;

  @ApiModelProperty(value = "法人证件类型:01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他")
  private String docType;

  @ApiModelProperty(value = "法人证件号码")
  private String docCode;

  @ApiModelProperty(value = "法人（负责人）代表姓名")
  private String legRepName;

  @ApiModelProperty(value = "法定代表人证件类型")
  private String legDocType;

  @ApiModelProperty(value = "法定代表人证件号码")
  private String legDocCode;

  @ApiModelProperty(value = "有效期")
  private Date validDate;

  @ApiModelProperty(value = "有效性 :01：有效 02：失效")
  private String validStatus;

  @ApiModelProperty(value = "商户类型 :01:自然人 02:企业商户 03:个体工商户 04:境外企业商户")
  private String cusType;

  @ApiModelProperty(value = "风险事件发生地域")
  private String occurarea;

  @ApiModelProperty(value = "关联商户编号")
  private String assMerNumber;

  @ApiModelProperty(value = "商户状态 :01.启用、 02.关闭（暂停） 03.注销")
  private String status;

  @ApiModelProperty(value = "是否加黑")
  private String isBlack;

  @ApiModelProperty(value = "关联字段个数")
  private String assFieldCnt;

  @ApiModelProperty(value = "关联字段名称")
  private String assFieldName;

  @ApiModelProperty(value = "操作人")
  private String operator;

  @ApiModelProperty(value = "失败原因")
  private String failureReason;

  @ApiModelProperty(value = "涉及结算金额")
  private String amount;
}
