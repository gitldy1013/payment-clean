package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

public enum PushStatusEnum {
  // 推送状态
  PUSHSTATUSENUM_0("0", "未推送"),
  PUSHSTATUSENUM_1("1", "已推送");

  private final String code;

  private final String desc;

  PushStatusEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getPushStatusEnumDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (PushStatusEnum pushStatusEnum : PushStatusEnum.values()) {
      if (pushStatusEnum.getCode().equalsIgnoreCase(code)) {
        return pushStatusEnum.getDesc();
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
