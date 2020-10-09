package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/** Created by lumma on 2020/9/19. */
public enum OpenTypeEnum {
  OPENTYPE_01("01", "POS"),
  OPENTYPE_02("02", "条码"),
  OPENTYPE_99("99", "其他");

  private final String code;
  private final String desc;

  OpenTypeEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getOpenTypeDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (OpenTypeEnum openTypeEnum : OpenTypeEnum.values()) {
      if (openTypeEnum.getCode().equalsIgnoreCase(code)) {
        return openTypeEnum.getDesc();
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
