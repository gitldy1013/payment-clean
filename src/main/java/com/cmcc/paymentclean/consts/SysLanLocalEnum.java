package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

// 地域
public enum SysLanLocalEnum {
  // 地域
  SysLanLocalEnum_100000("1", "全国", "基地", "0"),
  SysLanLocalEnum_110000("1", "北京市", "北京", "01"),
  SysLanLocalEnum_120000("1", "天津市", "天津", "02"),
  SysLanLocalEnum_130000("1", "河北省", "河北省", "03"),
  SysLanLocalEnum_140000("1", "山西省", "山西省", "04"),
  SysLanLocalEnum_150000("1", "内蒙古自治区", "内蒙古", "05"),
  SysLanLocalEnum_210000("1", "辽宁省", "辽宁省", "06"),
  SysLanLocalEnum_220000("1", "吉林省", "吉林省", "07"),
  SysLanLocalEnum_230000("1", "黑龙江省", "黑龙江省", "08"),
  SysLanLocalEnum_310000("1", "上海市", "上海", "09"),
  SysLanLocalEnum_320000("1", "江苏省", "江苏省", "10"),
  SysLanLocalEnum_330000("1", "浙江省", "浙江省", "11"),
  SysLanLocalEnum_340000("1", "安徽省", "安徽省", "12"),
  SysLanLocalEnum_350000("1", "福建省", "福建省", "13"),
  SysLanLocalEnum_360000("1", "江西省", "江西省", "14"),
  SysLanLocalEnum_370000("1", "山东省", "山东省", "15"),
  SysLanLocalEnum_410000("1", "河南省", "河南省", "16"),
  SysLanLocalEnum_420000("1", "湖北省", "湖北省", "17"),
  SysLanLocalEnum_430000("1", "湖南省", "湖南省", "18"),
  SysLanLocalEnum_440000("1", "广东省", "广东省", "19"),
  SysLanLocalEnum_450000("1", "广西壮族自治区", "广西省", "20"),
  SysLanLocalEnum_460000("1", "海南省", "海南省", "21"),
  SysLanLocalEnum_510000("1", "四川省", "四川省", "22"),
  SysLanLocalEnum_520000("1", "贵州省", "贵州省", "23"),
  SysLanLocalEnum_530000("1", "云南省", "云南省", "24"),
  SysLanLocalEnum_540000("1", "西藏自治区", "西藏省", "25"),
  SysLanLocalEnum_610000("1", "陕西省", "陕西省", "26"),
  SysLanLocalEnum_620000("1", "甘肃省", "甘肃省", "27"),
  SysLanLocalEnum_630000("1", "青海省", "青海省", "28"),
  SysLanLocalEnum_640000("1", "宁夏回族自治区", "宁夏", "29"),
  SysLanLocalEnum_650000("1", "新疆维吾尔自治区", "新疆", "30"),
  SysLanLocalEnum_500000("1", "重庆市", "重庆", "31");

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

  public static String getSysLanLocalEnumCode(String desc) {
    if (StringUtils.isEmpty(desc)) {
      return "";
    }
    for (SysLanLocalEnum sysLanEnum : SysLanLocalEnum.values()) {
      if (sysLanEnum.getDesc().equalsIgnoreCase(desc)) {
        return sysLanEnum.getCode();
      }
    }
    return desc;
  }

  public static String getSysLanLocalEnumPcode(String desc) {
    if (StringUtils.isEmpty(desc)) {
      return "";
    }
    for (SysLanLocalEnum sysLanEnum : SysLanLocalEnum.values()) {
      if (sysLanEnum.getDesc().equalsIgnoreCase(desc)) {
        return sysLanEnum.getPcode();
      }
    }
    return desc;
  }

  public static String getSysLanLocalDesc(String pcode) {
    for (SysLanLocalEnum sysLanEnum : SysLanLocalEnum.values()) {
      if (!StringUtils.isEmpty(pcode) && sysLanEnum.getPcode().equalsIgnoreCase(pcode)) {
        return sysLanEnum.getLocal();
      }
    }
    return pcode;
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
