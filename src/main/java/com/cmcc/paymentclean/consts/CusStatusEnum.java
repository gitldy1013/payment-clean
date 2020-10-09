package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

// 商户状态
public enum CusStatusEnum {
  CUSSTATUSENUM_01("01", "启用"),
  CUSSTATUSENUM_02("02", "关闭（暂停）"),
  CUSSTATUSENUM_03("03", "注销");

  private final String code;
  private final String desc;

  CusStatusEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getCusStatusEnum(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (CusStatusEnum cusStatusEnum : CusStatusEnum.values()) {
      if (cusStatusEnum.getCode().equalsIgnoreCase(code)) {
        return cusStatusEnum.getDesc();
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
