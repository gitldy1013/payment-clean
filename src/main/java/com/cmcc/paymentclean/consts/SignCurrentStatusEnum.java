package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/**
 * @author zhaolei
 * @date 2020-09-14 15:02
 */
public enum SignCurrentStatusEnum {

  SIGN_CURRENT("01", "是"),
  NO_SIGN_CURRENT("02", "否");

  private final String code;

  private final String desc;

  SignCurrentStatusEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getSignCurrentStatusDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (SignCurrentStatusEnum signCurrentStatusEnum : SignCurrentStatusEnum.values()) {
      if (signCurrentStatusEnum.getCode().equalsIgnoreCase(code)) {
        return signCurrentStatusEnum.getDesc();
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
