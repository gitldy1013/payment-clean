package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

// 地域
public enum SysLanLocalEnum {
  // 地域
  SysLanLocalEnum_100000("1", "全国", "基地", "0"),
  SysLanLocalEnum_110000("110000", "北京市", "北京", "01"),
  SysLanLocalEnum_120000("120000", "天津市", "天津", "02"),
  SysLanLocalEnum_130000("130000", "河北省", "河北省", "03"),
  SysLanLocalEnum_140000("140000", "山西省", "山西省", "04"),
  SysLanLocalEnum_150000("150000", "内蒙古自治区", "内蒙古", "05"),
  SysLanLocalEnum_210000("210000", "辽宁省", "辽宁省", "06"),
  SysLanLocalEnum_220000("220000", "吉林省", "吉林省", "07"),
  SysLanLocalEnum_230000("230000", "黑龙江省", "黑龙江省", "08"),
  SysLanLocalEnum_310000("310000", "上海市", "上海", "09"),
  SysLanLocalEnum_320000("320000", "江苏省", "江苏省", "10"),
  SysLanLocalEnum_330000("330000", "浙江省", "浙江省", "11"),
  SysLanLocalEnum_340000("340000", "安徽省", "安徽省", "12"),
  SysLanLocalEnum_350000("350000", "福建省", "福建省", "13"),
  SysLanLocalEnum_360000("360000", "江西省", "江西省", "14"),
  SysLanLocalEnum_370000("370000", "山东省", "山东省", "15"),
  SysLanLocalEnum_410000("410000", "河南省", "河南省", "16"),
  SysLanLocalEnum_420000("420000", "湖北省", "湖北省", "17"),
  SysLanLocalEnum_430000("430000", "湖南省", "湖南省", "18"),
  SysLanLocalEnum_440000("440000", "广东省", "广东省", "19"),
  SysLanLocalEnum_450000("450000", "广西壮族自治区", "广西省", "20"),
  SysLanLocalEnum_460000("460000", "海南省", "海南省", "21"),
  SysLanLocalEnum_510000("510000", "四川省", "四川省", "22"),
  SysLanLocalEnum_520000("520000", "贵州省", "贵州省", "23"),
  SysLanLocalEnum_530000("530000", "云南省", "云南省", "24"),
  SysLanLocalEnum_540000("540000", "西藏自治区", "西藏省", "25"),
  SysLanLocalEnum_610000("610000", "陕西省", "陕西省", "26"),
  SysLanLocalEnum_620000("620000", "甘肃省", "甘肃省", "27"),
  SysLanLocalEnum_630000("630000", "青海省", "青海省", "28"),
  SysLanLocalEnum_640000("640000", "宁夏回族自治区", "宁夏", "29"),
  SysLanLocalEnum_650000("650000", "新疆维吾尔自治区", "新疆", "30"),
  SysLanLocalEnum_500000("500000", "重庆市", "重庆", "31");

  private final String code;
  private final String local;
  private final String desc;
  private final String pcode;

  SysLanLocalEnum(String code, String local, String desc, String pcode) {
    this.code = code;
    this.local = local;
    this.desc = desc;
    this.pcode = pcode;
  }

  //商户给协会
  public static String getSysLanLocalEnumCode(String pCode) {
    if (StringUtils.isEmpty(pCode)) {
      return "";
    }
    for (SysLanLocalEnum sysLanEnum : SysLanLocalEnum.values()) {
      if (sysLanEnum.getDesc().equalsIgnoreCase(pCode)) {
        return sysLanEnum.getCode();
      }
    }
    return pCode;
  }

  //商户给风控
  public static String getSysLanLocalMerDesc(String pcode) {
    for (SysLanLocalEnum sysLanEnum : SysLanLocalEnum.values()) {
      if (!StringUtils.isEmpty(pcode) && sysLanEnum.getPcode().equalsIgnoreCase(pcode)) {
        return sysLanEnum.getLocal();
      }
    }
    return pcode;
  }

  //个人给风控
  public static String getSysLanLocalPerDesc(String code) {
    for (SysLanLocalEnum sysLanEnum : SysLanLocalEnum.values()) {
      if (!StringUtils.isEmpty(code) && sysLanEnum.getPcode().equalsIgnoreCase(code)) {
        return sysLanEnum.getLocal();
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

  public String getPcode() {
    return this.pcode;
  }

  public String getLocal() {
    return this.local;
  }
}
