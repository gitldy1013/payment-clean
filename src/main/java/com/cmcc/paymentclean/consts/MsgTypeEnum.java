package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/** Created by lumma on 2020/9/18. */
public enum MsgTypeEnum {
  MsgTypeEnum_01("01", "个人"),
  MsgTypeEnum_02("02", "商户"),
  MsgTypeEnum_03("03", "ETC"),
  MsgTypeEnum_04("04", "企业");

  private final String code;
  private final String desc;

  MsgTypeEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getMsgTypeDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (MsgTypeEnum msgTypeEnum : MsgTypeEnum.values()) {
      if (msgTypeEnum.getCode().equalsIgnoreCase(code)) {
        return msgTypeEnum.getDesc();
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
