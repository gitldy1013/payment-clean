package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/** Created by lumma on 2020/9/12. */
public enum SubmitStatusEnum {
  ISBLACKENUM_0("0", "未报送"),
  ISBLACKENUM_1("1", "已报送"),
  ISBLACKENUM_3("3", "不报送");

  private final String code;

  private final String desc;

  SubmitStatusEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getSubmitStatusEnumDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (SubmitStatusEnum submitStatusEnum : SubmitStatusEnum.values()) {
      if (submitStatusEnum.getCode().equalsIgnoreCase(code)) {
        return submitStatusEnum.getDesc();
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
