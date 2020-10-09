package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/** Created by lumma on 2020/9/18. */
public enum HandleResultEnum {
  //    01. 终止合作 02. 拒绝拓展 03. 暂停办理资金结算 04. 冻结账户 05. 调整结算周期 06. 延迟资金结算 07. 设置收款限额 08. 暂停银行卡交易 " +
  //            "09. 收回受理终端 (关闭网络支付接口) 10. 暂未采取控制措施,持续关注客户 11. 报送反洗钱可疑交易 99. 其他
  HANDLERESULT_01("01", "终止合作"),
  HANDLERESULT_02("02", "拒绝拓展"),
  HANDLERESULT_03("03", "暂停办理资金结算"),
  HANDLERESULT_04("04", "冻结账户"),
  HANDLERESULT_05("05", "调整结算周期"),
  HANDLERESULT_06("06", "延迟资金结算"),
  HANDLERESULT_07("07", "设置收款限额"),
  HANDLERESULT_08("08", "暂停银行卡交易"),
  HANDLERESULT_09("09", "收回受理终端(关闭网络支付接口)"),
  HANDLERESULT_10("10", "暂未采取控制措施,持续关注客户"),
  HANDLERESULT_11("11", "报送反洗钱可疑交易"),
  HANDLERESULT_99("99", "其他");

  private final String code;

  private final String desc;

  HandleResultEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getHandleResultDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (HandleResultEnum handleResultEnum : HandleResultEnum.values()) {
      if (handleResultEnum.getCode().equalsIgnoreCase(code)) {
        return handleResultEnum.getDesc();
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
