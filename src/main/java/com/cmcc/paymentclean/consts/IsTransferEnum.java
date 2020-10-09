package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/** Created by lumma on 2020/9/15. */
public enum IsTransferEnum {
  ISTRANSFER_0("0", "收款"),
  ISTRANSFER_1("1", "中转");

  private final String code;

  private final String desc;

  IsTransferEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getIsTransferDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (IsTransferEnum isTransferEnum : IsTransferEnum.values()) {
      if (isTransferEnum.getCode().equalsIgnoreCase(code)) {
        return isTransferEnum.getDesc();
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
