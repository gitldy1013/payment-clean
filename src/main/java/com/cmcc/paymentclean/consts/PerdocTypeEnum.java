package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

// 个人的证件类型
public enum PerdocTypeEnum {
  // 个人类型
  PERDOCTYPEENUM_1("01", "身份证", "00"),
  PERDOCTYPEENUM_ELSE("99", "其他", null);

  private final String desc;
  private final String localDesc;
  private final String code;

  PerdocTypeEnum(String desc, String localDesc, String code) {
    this.code = code;
    this.localDesc = localDesc;
    this.desc = desc;
  }

  public static String getPerdocTypeEnumDesc(String code) {
    if (PERDOCTYPEENUM_1.getCode().equals(code)) {
      return PERDOCTYPEENUM_1.getDesc();
    } else {
      return PERDOCTYPEENUM_ELSE.getDesc();
    }
  }

  public static String getPerdocTypeEnumLocalDesc(String code) {
    if (PERDOCTYPEENUM_1.getCode().equals(code)) {
      return PERDOCTYPEENUM_1.getLocalDesc();
    } else {
      return PERDOCTYPEENUM_ELSE.getLocalDesc();
    }
  }

  public String getCode() {
    return this.code;
  }

  public String getDesc() {
    return this.desc;
  }

  public String getLocalDesc() {
    return localDesc;
  }
}
