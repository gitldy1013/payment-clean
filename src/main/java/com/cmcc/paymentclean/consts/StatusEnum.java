package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/** Created by lumma on 2020/9/18. */
public enum StatusEnum {
  STATUS_01("01", "启用"),
  STATUS_02("02", "关闭（暂停）"),
  STATUS_03("03", "注销");

  private final String code;

  private final String desc;

  StatusEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getStatusDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (StatusEnum statusEnum : StatusEnum.values()) {
      if (statusEnum.getCode().equalsIgnoreCase(code)) {
        return statusEnum.getDesc();
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
