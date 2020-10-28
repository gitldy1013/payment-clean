package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

// 商户系统的证件类型
public enum MerdocTypeEnum {
  // 商户类型
  MERDOCTYPEENUM_1("99", "事业单位法人证书", "1"),
  MERDOCTYPEENUM_2("02", "统一社会信用代码证书", "2"),
  MERDOCTYPEENUM_3("99", "有偿服务许可证（军队医院适用）", "3"),
  MERDOCTYPEENUM_4("99", "医疗机构执业许可证（军队医院适用）", "4"),
  MERDOCTYPEENUM_5("99", "企业营业执照（挂靠企业的党组织适用）", "5"),
  MERDOCTYPEENUM_6("03", "组织机构代码证（政府机关适用）", "6"),
  MERDOCTYPEENUM_7("99", "社会团体法人登记证书", "7"),
  MERDOCTYPEENUM_8("99", "民办非企业单位登记证书", "8"),
  MERDOCTYPEENUM_9("99", "基金会法人登记证书", "9"),
  MERDOCTYPEENUM_10("99", "慈善组织公开募捐资格证书", "10"),
  MERDOCTYPEENUM_11("99", "农民专业合作社法人营业执照", "11"),
  MERDOCTYPEENUM_12("99", "宗教活动场所登记证", "12"),
  MERDOCTYPEENUM_13("99", "其他证书/批文/证明", "13"),
  MERDOCTYPEENUM_14("02", "营业执照", "14"),
  MERDOCTYPEENUM_null("02", "营业执照", null);

  private final String desc;
  private final String localDesc;
  private final String code;

  MerdocTypeEnum(String desc, String localDesc, String code) {
    this.code = code;
    this.localDesc = localDesc;
    this.desc = desc;
  }

  public static String getMerdocTypeEnumDesc(String code) {

    for (MerdocTypeEnum merdocCodeEnum : MerdocTypeEnum.values()) {
      if (StringUtils.isEmpty(code) || merdocCodeEnum.getCode().equalsIgnoreCase(code)) {
        return merdocCodeEnum.getDesc();
      }
    }
    return code;
  }

  //给风控
  public static String getMerdocTypeEnumLocalDesc(String code) {
    System.out.println("========================="+code);
    for (MerdocTypeEnum merdocCodeEnum : MerdocTypeEnum.values()) {
      if (StringUtils.isEmpty(code) || merdocCodeEnum.getCode().equalsIgnoreCase(code)) {
        return merdocCodeEnum.getLocalDesc();
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

  public String getLocalDesc() {
    return localDesc;
  }
}
