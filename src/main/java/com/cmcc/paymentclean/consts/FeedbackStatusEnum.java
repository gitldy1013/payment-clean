package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/** Created by lumma on 2020/9/12. */
public enum FeedbackStatusEnum {
  //    FEEDBACKSTATUS_01("01", "终止合作"),
  //    FEEDBACKSTATUS_02("02", "拒绝拓展"),
  //    FEEDBACKSTATUS_03("03", "暂停办理资金结算"),
  //    FEEDBACKSTATUS_04("04", "冻结账户"),
  //    FEEDBACKSTATUS_05("05", "调整结算周期"),
  //    FEEDBACKSTATUS_06("06", "延迟资金结算"),
  //    FEEDBACKSTATUS_07("07", "设置收款限额"),
  //    FEEDBACKSTATUS_08("08", "暂停银行卡交易"),
  //    FEEDBACKSTATUS_09("09", "收回受理终端(关闭网络支付接口)"),
  //    FEEDBACKSTATUS_10("10", "暂未采取控制措施,持续关注客户"),
  //    FEEDBACKSTATUS_11("11", "报送反洗钱可疑交易"),
  //    FEEDBACKSTATUS_99("99", "其他");
  FEEDBACKSTATUS_01("0", "未反馈"),
  FEEDBACKSTATUS_02("1", "已反馈");
  private final String code;

  private final String desc;

  FeedbackStatusEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getFeedbackStatusDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (FeedbackStatusEnum feedbackStatusEnum : FeedbackStatusEnum.values()) {
      if (feedbackStatusEnum.getCode().equalsIgnoreCase(code)) {
        return feedbackStatusEnum.getDesc();
      }
    }
    return code;
  }

  public String getCode() {
    return this.code;
  }

  public String getDesc() {
    return this.desc;
  }
}
