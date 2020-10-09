package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

// 商户风险类型
public enum CusRiskTypeEnum {
  CUSRISKTYPEENUM_01("01", "企业开户行为异常"),
  CUSRISKTYPEENUM_02("02", "企业开户信息异常"),
  CUSRISKTYPEENUM_03("03", "境内外有权机构发布名单");

  private final String code;
  private final String desc;

  CusRiskTypeEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getCusRiskTypeEnum(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (CusRiskTypeEnum cusRiskTypeEnum : CusRiskTypeEnum.values()) {
      if (cusRiskTypeEnum.getCode().equalsIgnoreCase(code)) {
        return cusRiskTypeEnum.getDesc();
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
