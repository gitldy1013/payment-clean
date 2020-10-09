package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

// 风险发生渠道
public enum OccurChanEnum {
  OCCURCHANENUM_01("01", "线上"),
  OCCURCHANENUM_02("02", "线下"),
  OCCURCHANENUM_03("03", "线上兼线下");

  private final String code;
  private final String desc;

  OccurChanEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getOccurChanEnum(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (OccurChanEnum occurChanEnum : OccurChanEnum.values()) {
      if (occurChanEnum.getCode().equalsIgnoreCase(code)) {
        return occurChanEnum.getDesc();
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
