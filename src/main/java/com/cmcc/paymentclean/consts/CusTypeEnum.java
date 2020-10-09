package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

// 商户类型
public enum CusTypeEnum {
  CUSTYPEENUM_01("01", "自然人"),
  CUSTYPEENUM_02("02", "企业商户"),
  CUSTYPEENUM_03("03", "个体工商户"),
  CUSTYPEENUM_04("04", "境外企业商户");

  private final String code;
  private final String desc;

  CusTypeEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getCusTypeEnum(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (CusTypeEnum cusTypeEnum : CusTypeEnum.values()) {
      if (cusTypeEnum.getCode().equalsIgnoreCase(code)) {
        return cusTypeEnum.getDesc();
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
