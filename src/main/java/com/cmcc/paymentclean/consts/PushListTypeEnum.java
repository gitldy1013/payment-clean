package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/** Created by lumma on 2020/9/12. */
public enum PushListTypeEnum {
  PUSHLISTTYPE_01("01", "黑名单"),
  PUSHLISTTYPE_02("02", "风险提示信息");

  private final String code;

  private final String desc;

  PushListTypeEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getPushListTypeDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (PushListTypeEnum pushListTypeEnum : PushListTypeEnum.values()) {
      if (pushListTypeEnum.getCode().equalsIgnoreCase(code)) {
        return pushListTypeEnum.getDesc();
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
