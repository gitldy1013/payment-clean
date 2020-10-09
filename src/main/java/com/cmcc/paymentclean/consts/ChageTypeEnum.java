package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/** Created by lumma on 2020/9/19. */
public enum ChageTypeEnum {
  CHAGETYPE_01("01", "标准"),
  CHAGETYPE_02("02", "优惠"),
  CHAGETYPE_03("03", "减免");

  private final String code;
  private final String desc;

  ChageTypeEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getChageTypeDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (ChageTypeEnum chageTypeEnum : ChageTypeEnum.values()) {
      if (chageTypeEnum.getCode().equalsIgnoreCase(code)) {
        return chageTypeEnum.getDesc();
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
