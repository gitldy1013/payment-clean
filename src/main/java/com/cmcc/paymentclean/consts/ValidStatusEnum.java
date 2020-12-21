package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/**
 * @author zhaolei
 * @date 2020-09-14 15:02
 */
public enum ValidStatusEnum {

  VALID("01", "有效"),
  UNVALID("02", "失效");

  private final String code;

  private final String desc;

  ValidStatusEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getValidStatusDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (ValidStatusEnum validStatusEnum : ValidStatusEnum.values()) {
      if (validStatusEnum.getCode().equalsIgnoreCase(code)) {
        return validStatusEnum.getDesc();
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
