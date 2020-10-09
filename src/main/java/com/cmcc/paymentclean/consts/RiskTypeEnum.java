package com.cmcc.paymentclean.consts;

public enum RiskTypeEnum {
  RiskTypeEnum_01("01", "虚假申请"),
  RiskTypeEnum_02("02", "套现、套积分"),
  RiskTypeEnum_03("03", "违法违规经营"),
  RiskTypeEnum_04("04", "销赃或协助转移赃款"),
  RiskTypeEnum_05("05", "买卖或租借银行（支付）账户"),
  RiskTypeEnum_06("06", "侧录点(恶意)"),
  RiskTypeEnum_07("07", "伪卡集中使用点(恶意)"),
  RiskTypeEnum_08("08", "泄露账户及交易信息"),
  RiskTypeEnum_09("09", "恶意倒闭"),
  RiskTypeEnum_10("10", "恶意分单"),
  RiskTypeEnum_11("11", "移机"),
  RiskTypeEnum_12("12", "高风险商户"),
  RiskTypeEnum_13("13", "商户合谋欺诈"),
  RiskTypeEnum_14("14", "破产或停业商户"),
  RiskTypeEnum_15("15", "强迫交易"),
  RiskTypeEnum_17("17", "频繁变更服务机构"),
  RiskTypeEnum_18("18", "关联商户涉险"),
  RiskTypeEnum_19("19", "买卖银行卡信息"),
  RiskTypeEnum_20("20", "拒刷信用卡"),
  RiskTypeEnum_21("21", "转嫁手续费"),
  RiskTypeEnum_22("22", "支付敏感信息泄露"),
  RiskTypeEnum_23("23", "非法改装终端"),
  RiskTypeEnum_24("24", "切机"),
  RiskTypeEnum_25("25", "二清"),
  RiskTypeEnum_26("26", "套码"),
  RiskTypeEnum_27("27", "冒用申请"),
  RiskTypeEnum_28("28", "侧录点(非恶意)"),
  RiskTypeEnum_29("29", "洗钱行为"),
  RiskTypeEnum_30("30", "套汇"),
  RiskTypeEnum_31("31", "逃汇"),
  RiskTypeEnum_32("32", "骗汇"),
  RiskTypeEnum_33("33", "分拆交易"),
  RiskTypeEnum_34("34", "按金交易"),
  RiskTypeEnum_35("35", "境内外有权机构发布名单"),
  RiskTypeEnum_36("36", "发卡侧风险"),
  RiskTypeEnum_37("37", "恶意注册"),
  RiskTypeEnum_38("38", "伪造、变造票据"),
  RiskTypeEnum_39("39", "伪造、变造签章"),
  RiskTypeEnum_40("40", "跨境支付虚假、盗用或冒用申请"),
  RiskTypeEnum_41("41", "跨境支付大额交易客户、异常客户"),
  RiskTypeEnum_42("42", "跨境赌博"),
  RiskTypeEnum_43("43", "跨境赌博资金中转"),
  RiskTypeEnum_44("44", "伪卡集中使用点(非恶意)"),
  RiskTypeEnum_45("45", "受理终端(网络支付接口、收款码)挪作违法违规用途"),
  RiskTypeEnum_46("46", "赌博"),
  RiskTypeEnum_47("47", "赌博资金中转"),
  RiskTypeEnum_99("99", "其他");

  private final String code;

  private final String desc;

  RiskTypeEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getRiskTypeDesc(String code) {
    for (RiskTypeEnum riskTypeEnum : RiskTypeEnum.values()) {
      if (riskTypeEnum.getCode().equalsIgnoreCase(code)) {
        return riskTypeEnum.getDesc();
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
