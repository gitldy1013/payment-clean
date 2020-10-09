package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

// 法人证件类型
public enum LegPersonDocEnum {
  LEGPERSONDOCENUM_01("01", "营业执照编码"),
  LEGPERSONDOCENUM_02("02", "统一社会信息代码"),
  LEGPERSONDOCENUM_03("03", "组织机构代码证"),
  LEGPERSONDOCENUM_04("04", "经营许可证"),
  LEGPERSONDOCENUM_05("05", "税务登记证"),
  LEGPERSONDOCENUM_99("99", "其他");

  private final String code;
  private final String desc;

  LegPersonDocEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getLegPersonDocEnum(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (LegPersonDocEnum legPersonDocEnum : LegPersonDocEnum.values()) {
      if (legPersonDocEnum.getCode().equalsIgnoreCase(code)) {
        return legPersonDocEnum.getDesc();
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
