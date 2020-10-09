package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

public enum PcacResultCode {
  S00000("S00000", "交易处理成功"),
  S00001("S00001", "查询无此记录"),
  F00001("F00001", "数据库连接异常"),
  F00002("F00002", "增加风险信息异常"),
  F00003("F00003", "查询风险信息异常"),
  F00004("F00004", "变更风险信息异常"),
  F00005("F00005", "验证签名失败"),
  F00006("F00006", "数据签名失败"),
  F00007("F00007", "报文解密失败"),
  F00008("F00008", "报文加密失败"),
  F00009("F00009", "交易码错误"),
  F00010("F00010", "交易处理超时"),
  F00011("F00011", "未知异常"),
  BX0001("BX0001", "报文无法解析"),
  BX0002("BX0002", "报文超出最大长度"),
  BX0003("BX0003", "报文格式不正确"),
  BX0004("BX0004", "数字签名无效"),
  BX0005("BX0005", "签名者证书无效"),
  BX0006("BX0006", "签名者非业务发起方"),
  BD0001("BD0001", "报文头，版本号不能为空"),
  BD0002("BD0002", "报文头，版本号非法"),
  BD0003("BD0003", "报文头，证书ID不能为空"),
  BD0004("BD0004", "报文头，证书ID非法"),
  BD0005("BD0005", "报文头，报文唯一标识不能为空"),
  BD0006("BD0006", "报文头，报文唯一标识格式不正确"),
  BD0007("BD0007", "报文头，收单机构机构号不能为空"),
  BD0008("BD0008", "报文头，收单机构机构号格式不正确"),
  BD0009("BD0009", "报文头，收单机构机构号非法"),
  BD0010("BD0010", "报文头，收单机构发送系统号不能为空"),
  BD0011("BD0011", "报文头，协会系统编号不能为空"),
  BD0012("BD0012", "报文头，协会系统编号非法"),
  BD0013("BD0013", "报文头，交易码不能为空"),
  BD0014("BD0014", "报文头，交易时间不能空"),
  BD0015("BD0015", "报文头，交易时间格式不正确"),
  BD0016("BD0016", "报文头，密钥不能为空"),
  BD0017("BD0017", "个人风险信息，客户属性不能为空"),
  BD0018("BD0018", "个人风险信息，客户属性格式不正确"),
  BD0019("BD0019", "个人风险信息，风险类型不能为空"),
  BD0020("BD0020", "个人风险信息，风险类型格式不正确"),
  BD0021("BD0021", "个人风险信息，手机格式不正确"),
  BD0022("BD0022", "个人风险信息，MAC地址格式不正确"),
  BD0023("BD0023", "个人风险信息，Iemi格式不正确"),
  BD0024("BD0024", "个人风险信息，银行账/卡号格式不正确"),
  BD0025("BD0025", "个人风险信息，开户行不允许大于64位字符"),
  BD0026("BD0026", "个人风险信息，收款银行账/卡号格式不正确"),
  BD0027("BD0027", "个人风险信息，证件类型格式不正确"),
  BD0028("BD0028", "个人风险信息，收货地址不允许大于128位字符"),
  BD0029("BD0029", "个人风险信息，证件号码格式不正确"),
  BD0030("BD0030", "个人风险信息，固定电话格式不正确"),
  BD0031("BD0031", "个人风险信息，客户姓名不允许大于64位字符"),
  BD0032("BD0032", "个人风险信息，IP地址格式不正确"),
  BD0033("BD0033", "个人风险信息，邮箱格式不正确"),
  BD0034("BD0034", "个人风险信息，有效期不能为空"),
  BD0035("BD0035", "个人风险信息，有效期格式不正确"),
  BD0036("BD0036", "个人风险信息，信息级别格式不正确"),
  BD0037("BD0037", "个人风险信息，上报机构不能为空"),
  BD0038("BD0038", "个人风险信息，上报机构格式不正确"),
  BD0039("BD0039", "个人风险信息，上报日期不能为空"),
  BD0040("BD0040", "个人风险信息，上报日期格式不正确"),
  BD0041("BD0041", "个人风险信息，上传方式不能为空"),
  BD0042("BD0042", "个人风险信息，上传方式格式不正确"),
  BD0043("BD0043", "个人风险信息，上传人不能为空"),
  BD0044("BD0044", "个人风险信息，上传人不允许大于32位字符"),
  BD0045("BD0045", "个人风险信息，备注不允许大于1024位字符"),
  BD0046("BD0046", "手机号、MAC、Imei、银行账/卡号、（客户姓名）身份证证件号码、IP地址、收款银行账/卡号7项要素不得全部为空"),
  BD0047("BD0047", "商户风险信息，客户属性不能为空"),
  BD0048("BD0048", "商户风险信息，客户属性格式不正确"),
  BD0049("BD0049", "商户风险信息，风险类型不能为空"),
  BD0050("BD0050", "商户风险信息，风险类型格式不正确"),
  BD0051("BD0051", "商户风险信息，商户姓名不允许大于64位字符"),
  BD0052("BD0052", "商户风险信息，组织机构代码格式不正确"),
  BD0053("BD0053", "商户风险信息，营业执照编码格式不正确"),
  BD0054("BD0054", "商户风险信息，税务登记证格式不正确"),
  BD0055("BD0055", "商户风险信息，法人证件号码不允许大于18位字符"),
  BD0056("BD0056", "商户风险信息，法人证件号码格式不正确"),
  BD0057("BD0057", "商户风险信息，银行账号格式不正确"),
  BD0058("BD0058", "商户风险信息，银行账号不允许大于32位字符"),
  BD0059("BD0059", "商户风险信息，开户行不允许大于64位字符"),
  BD0060("BD0060", "商户风险信息，网址格式不正确"),
  BD0061("BD0061", "商户风险信息，网址不允许大于512位字符"),
  BD0062("BD0062", "商户风险信息，服务器IP格式不正确"),
  BD0063("BD0063", "商户风险信息，固定格式不正确"),
  BD0064("BD0064", "商户风险信息，手机格式不正确"),
  BD0065("BD0065", "商户风险信息，地域不允许大于128位字符"),
  BD0066("BD0066", "商户风险信息，ICP编号格式不正确"),
  BD0067("BD0067", "商户风险信息，有效期不能为空且不能小于当前时间"),
  BD0068("BD0068", "商户风险信息，有效期格式不正确"),
  BD0069("BD0069", "商户风险信息，备注不允许大于1024位字符"),
  BD0070("BD0070", "商户风险信息，信息级别格式不正确"),
  BD0071("BD0071", "商户风险信息，上报机构不能为空"),
  BD0072("BD0072", "商户风险信息，上报机构格式不正确"),
  BD0073("BD0073", "商户风险信息，上报日期不能为空"),
  BD0074("BD0074", "商户风险信息，上报日期格式不正确"),
  BD0075("BD0075", "商户风险信息，上传方式不能为空"),
  BD0076("BD0076", "商户风险信息，上传方式格式不正确"),
  BD0077("BD0077", "商户风险信息，上传人不能为空"),
  BD0078("BD0078", "商户风险信息，上传人不允许大于32位字符"),
  BD0079(
      "BD0079",
      "商户户名称、商户名称、统一社会信用代码、组织机构代码、营业执照编码、法定代表人（负责人）身份证件号码、银行结算账号、网址、服务器IP、法定代表人手机号、ICP编号11项项要素不得全部为空"),
  BD0080("BD0080", "其它异常信息"),
  BD0081("BD0081", "签名域不能为空"),
  BD0082("BD0082", "总行数与上报实际信息不匹配"),
  BD0083("BD0083", "服务器端返回报文格式不正确"),
  BD0084("BD0084", "证件类型、证件号要同时为空或同时不为空"),
  BD0085("BD0085", "身份证格式不正确"),
  BD0086("BD0086", "报文信息包含BOM header（即EF BB BF）"),
  BD0087("BD0087", "手机号、MAC、Imei、银行账/卡号、（客户姓名）身份证证件号码、IP地址、收款银行账/卡号查询条件不能全部为空"),
  BD0088("BD0088", "客户名称、组织机构代码、营业执照编码、税务登记证、法人证件号码、银行账号、开户行、网址、服务器IP、手机、地域、ICP编号查询条件不能全部为空"),
  BD0089("BD0089", "手机号、MAC、Imei、风险类型不得全部为空"),
  BD0090("BD0090", "变更查询条件不得全部为空"),
  BD0092("BD0092", "报文头错误"),
  BD0093("BD0093", "风险事件发生地域代码错误"),
  BD1001("BD1001", "用户登录失败"),
  BD1002("BD1002", "系统拒绝用户登录"),
  BD1003("BD1003", "用户已登录"),
  BD1004("BD1004", "个人批量信息导入关键为空"),
  BD1005("BD1005", "个人批量信息导入关键字错误"),
  BD1006("BD1006", "商户批量信息导入关键为空"),
  BD1007("BD1007", "商户批量信息导入关键字错误"),
  BD1008("BD1008", "报文元素内容超出长度限制，其中中文为2个字符"),
  BD1009("BD1009", "商户信息导入时，商户类型为非自然人时，法人证件类型和法人证件号码必填；"),
  BD1020("BD1020", "商户风险信息失效时，如失效黑名单，则失效说明必填"),
  BD1021("BD1021", "降级信息中有非黑名单数据"),
  BD2002("BD2002", "商户注册地址(省)代码错误"),
  BD2003("BD2003", "商户经营地址(省)代码错误"),
  BD2004("BD2004", "商户经营地区范围代码错误"),
  BD2005("BD2005", "清算网络代码错误"),
  BD2006("BD2006", "开通业务种类代码错误"),
  BD2007("BD2007", "拓展方式为外包服务机构推荐时, 外包服务机构法人证件类型,外包服务机构法人证件号码,外包服务机构法定代表人证件类型和外包服务机构法定代表人证件号码必填"),
  BD2008("BD2008", "身份证号码格式错误"),
  BD2009("BD2009", "商户状态不是启用状态时，服务终止时间为必填项"),
  BD2010("BD2010", "商户属性选择网络特约商户，“商户主页URL”、“IP地址”、“ICP备案编号”为必填"),
  BD2011("BD2011", "商户属性不是网络特约商户时，商户注册地址(省)、商户注册地址、商户经营地址(省)、商户经营地址、商户经营地区范围、开通类型和计费类型不能为空"),
  BD2012("BD2012", "风险事件发生时间开始时间不能晚于结束时间"),
  BD2013("BD2013", "服务起始时间不能大于服务终止时间时，"),
  BD2014("BD2014", "信息补发时间不能大于当前日期"),
  BD2015("BD2015", "支持账户类型代码错误"),
  H00001("H00001", "用户未登录"),
  H00002("H00002", "变更数据权限有误"),
  H00003("H00003", "单位请求权限错误，无该请求（xx）权限"),
  H00004("H00004", "风险提示补发申请不在受理时间范围内，受理时间为xx"),
  H00005("H00005", "结果获取标识不存在");

  private final String code;

  private final String desc;

  PcacResultCode(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public static String getPcacResultCode(String code) {
    if (StringUtils.isEmpty(code)) {
      return "";
    }
    for (PcacResultCode pcacResultCode : PcacResultCode.values()) {
      if (pcacResultCode.getCode().equalsIgnoreCase(code)) {
        return pcacResultCode.getDesc();
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
