package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

// 商户系统的证件类型
public enum MerdocTypeEnum {
  // 商户类型
  MERDOCTYPEENUM_1("99", "1"),
  MERDOCTYPEENUM_2("02", "2"),
  MERDOCTYPEENUM_3("99", "3"),
  MERDOCTYPEENUM_4("99", "4"),
  MERDOCTYPEENUM_5("99", "5"),
  MERDOCTYPEENUM_6("03", "6"),
  MERDOCTYPEENUM_7("99", "7"),
  MERDOCTYPEENUM_8("99", "8"),
  MERDOCTYPEENUM_9("99", "9"),
  MERDOCTYPEENUM_10("99", "10"),
  MERDOCTYPEENUM_11("99", "11"),
  MERDOCTYPEENUM_12("99", "12"),
  MERDOCTYPEENUM_13("99", "13"),
  MERDOCTYPEENUM_14("02", "14"),
  MERDOCTYPEENUM_null("02", null);

  private final String desc;
  private final String code;

  MerdocTypeEnum(String desc, String code) {
    this.code = code;
    this.desc = desc;
  }

  public static String getMerdocTypeEnumDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (MerdocTypeEnum merdocCodeEnum : MerdocTypeEnum.values()) {
      if (merdocCodeEnum.getCode() == null || merdocCodeEnum.getCode().equalsIgnoreCase(code)) {
        return merdocCodeEnum.getDesc();
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
