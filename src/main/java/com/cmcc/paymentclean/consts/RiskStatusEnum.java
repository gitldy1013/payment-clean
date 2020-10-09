package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/** Created by lumma on 2020/9/19. */
public enum RiskStatusEnum {
  RISKSTATUS_01("01", "合规"),
  RISKSTATUS_02("02", "风险");

  private final String code;

  private final String desc;

  RiskStatusEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getRiskStatusDesc(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (RiskStatusEnum riskStatusEnum : RiskStatusEnum.values()) {
      if (riskStatusEnum.getCode().equalsIgnoreCase(code)) {
        return riskStatusEnum.getDesc();
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
