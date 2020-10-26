package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

// 个人的证件类型
public enum PerdocTypeEnum {
  // 个人类型
  PERDOCTYPEENUM_1("01", "00"),
  PERDOCTYPEENUM_ELSE("99", null);

  private final String desc;
  private final String code;

  PerdocTypeEnum(String desc, String code) {
    this.code = code;
    this.desc = desc;
  }

  public static String getPerdocTypeEnumDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (PerdocTypeEnum merdocCode : PerdocTypeEnum.values()) {
      if (merdocCode.getCode() != null && merdocCode.getCode().equals(PERDOCTYPEENUM_1.getCode())) {
        return merdocCode.getDesc();
      } else {
        return PERDOCTYPEENUM_ELSE.getDesc();
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
