package com.cmcc.paymentclean.entity.dto.response;

import com.cmcc.paymentclean.annotation.ExcelExportField;
import com.cmcc.paymentclean.consts.PcacResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/** Created by lumma on 2020/9/14. */
@Data
@ApiModel(value = "商户风险信息查询使用情况查询结果参数")
@ToString
public class QueryPcacMerchantRiskInfoResp implements Serializable {
  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "queryPcacMerchantRiskInfoId")
  private String queryPcacMerchantRiskInfoId;

  @ApiModelProperty(value = "id")
  private String id;

  @ExcelExportField(name = "风险反馈主键编码", index = 0)
  @ApiModelProperty(value = "pcacId")
  private String pcacId;

  @ExcelExportField(name = "商户类型", index = 1)
  @ApiModelProperty(value = "商户类型")
  private String cusType;

  @ExcelExportField(name = "客户属性", index = 2)
  @ApiModelProperty(value = "客户属性")
  private String cusProperty;

  @ExcelExportField(name = "风险类型", index = 3)
  @ApiModelProperty(value = "风险类型")
  private String riskType;

  @ExcelExportField(name = "商户属性", index = 4)
  @ApiModelProperty(value = "商户属性")
  private String cusNature;

  @ExcelExportField(name = "商户名称/企业名称", index = 5)
  @ApiModelProperty(value = "商户名称/企业名称")
  private String regName;

  @ExcelExportField(name = "商户代码", index = 6)
  @ApiModelProperty(value = "商户代码，最长不能超过 32 个字符")
  private String cusCode;

  @ApiModelProperty(value = "风控商户编码")
  private String pcacCusCode;

  @ExcelExportField(name = "法人证件类型", index = 7)
  @ApiModelProperty(value = "法人证件类型")
  private String docType;

  @ExcelExportField(name = "法人证件号码", index = 8)
  @ApiModelProperty(value = "法人证件号码")
  private String docCode;

  @ExcelExportField(name = "法定代表人姓名", index = 9)
  @ApiModelProperty(value = "法定代表人姓名")
  private String legRepName;

  @ExcelExportField(name = "法定代表人（负责人） 证件类型", index = 10)
  @ApiModelProperty(value = "法定代表人（负责人） 证件类型")
  private String legDocType;

  @ExcelExportField(name = "法定代表人（负责人）证件号码", index = 11)
  @ApiModelProperty(value = "法定代表人（负责人）证件号码")
  private String legDocCode;

  @ExcelExportField(name = "返回数量", index = 12)
  @ApiModelProperty(value = "返回数量")
  private String count;

  @ExcelExportField(name = "中转或收款", index = 13)
  @ApiModelProperty(value = "中转或收款 0 收款 1 中转")
  private String isTransfer;

  @ExcelExportField(name = "银行结算账号", index = 14)
  @ApiModelProperty(value = "银行结算账号")
  private String bankNo;

  @ExcelExportField(name = "开户行", index = 15)
  @ApiModelProperty(value = "开户行（支付账户开立机构）")
  private String openBank;

  @ExcelExportField(name = "网址", index = 16)
  @ApiModelProperty(value = "网址")
  private String url;

  @ExcelExportField(name = "服务器 IP", index = 17)
  @ApiModelProperty(value = "服务器 IP")
  private String serverIp;

  @ExcelExportField(name = "法定代表人（负责人） 手机号", index = 18)
  @ApiModelProperty(value = "法定代表人（负责人） 手机号")
  private String mobileNo;

  @ExcelExportField(name = "商户实际办公地", index = 19)
  @ApiModelProperty(value = "商户实际办公地")
  private String address;

  @ExcelExportField(name = "ICP 备案编号", index = 20)
  @ApiModelProperty(value = "ICP 备案编号")
  private String icp;

  @ExcelExportField(name = "风险信息等级", index = 21)
  @ApiModelProperty(value = "风险信息等级")
  private String level;

  @ExcelExportField(name = "风险事件发生时间", index = 22)
  @ApiModelProperty(value = "风险事件发生时间")
  private Date occurtimeb;

  @ExcelExportField(name = "风险事件结束时间", index = 23)
  @ApiModelProperty(value = "风险事件结束时间")
  private Date occurtimee;

  @ExcelExportField(name = "风险事件发生渠道", index = 24)
  @ApiModelProperty(value = "风险事件发生渠道")
  private String occurchan;

  @ExcelExportField(name = "风险事件发生地域", index = 25)
  @ApiModelProperty(value = "风险事件发生地域")
  private String occurarea;

  @ExcelExportField(name = "风险事件描述", index = 26)
  @ApiModelProperty(value = "风险事件描述")
  private String note;

  @ExcelExportField(name = "有效性", index = 27)
  @ApiModelProperty(value = "有效性")
  private String validStatus;

  @ExcelExportField(name = "有效期", index = 28)
  @ApiModelProperty(value = "有效期")
  private Date validDate;

  @ExcelExportField(name = "终止合作的机构数量", index = 29)
  @ApiModelProperty(value = "终止合作的机构数量")
  private String stopNum;

  @ExcelExportField(name = "涉及机构数", index = 30)
  @ApiModelProperty(value = "涉及机构数")
  private String totalOrganNum;

  @ExcelExportField(name = "拒绝拓展的机构数量", index = 31)
  @ApiModelProperty(value = "拒绝拓展的机构数量")
  private String refuseNum;

  @ExcelExportField(name = "暂停办理资金结算的机构数量", index = 32)
  @ApiModelProperty(value = "暂停办理资金结算的机构数量")
  private String useRiseNum;

  @ExcelExportField(name = "冻结账户的机构数量", index = 33)
  @ApiModelProperty(value = "冻结账户的机构数量")
  private String frozenNum;

  @ExcelExportField(name = "调整结算周期的机构数量", index = 34)
  @ApiModelProperty(value = "调整结算周期的机构数量")
  private String adjustmentCycleNum;

  @ExcelExportField(name = "延迟资金结算的机构数量", index = 35)
  @ApiModelProperty(value = "延迟资金结算的机构数量")
  private String delayNum;

  @ExcelExportField(name = "设置收款限额的机构数量", index = 36)
  @ApiModelProperty(value = "设置收款限额的机构数量")
  private String quotaNum;

  @ExcelExportField(name = "暂停银行卡交易的机构数量", index = 37)
  @ApiModelProperty(value = "暂停银行卡交易的机构数量")
  private String suspendNum;

  @ExcelExportField(name = "收回受理终端 (关闭网络支付接口) 的机构数", index = 38)
  @ApiModelProperty(value = "收回受理终端 (关闭网络支付接口) 的机构数	            收回受理终端 (关闭网络支付接口) 的机构数量")
  private String closeNum;

  @ExcelExportField(name = "暂未采取控制措施,持续关注客户的机构数量", index = 39)
  @ApiModelProperty(value = "暂未采取控制措施,持续关注客户的机构数量")
  private String followNum;

  @ExcelExportField(name = "报送反洗钱可疑交易的机构数量", index = 40)
  @ApiModelProperty(value = "报送反洗钱可疑交易的机构数量")
  private String antiMoneyNum;

  @ExcelExportField(name = "其他的机构数量", index = 41)
  @ApiModelProperty(value = "其他的机构数量")
  private String otherNum;

  @ExcelExportField(name = "商户注册国家或地区", index = 42)
  @ApiModelProperty(value = "商户注册国家或地区")
  private String registeredArea;

  @ExcelExportField(name = "商户注册号码", index = 43)
  @ApiModelProperty(value = "商户注册号码")
  private String registeredCode;

  @ExcelExportField(name = "风险信息来源", index = 44)
  @ApiModelProperty(value = "风险信息来源")
  private String sourceChannel;

  @ExcelExportField(name = "交易金额", index = 45)
  @ApiModelProperty(value = "交易金额")
  private String amount;

  @ExcelExportField(name = "风险事件发现时间", index = 46)
  @ApiModelProperty(value = "风险事件发现时间")
  private Date riskFindTime;

  @ExcelExportField(name = "实控人姓名", index = 47)
  @ApiModelProperty(value = "实控人姓名")
  private String legControlName;

  @ExcelExportField(name = "实控人证件类型", index = 48)
  @ApiModelProperty(value = "实控人证件类型")
  private String legControlCardType;

  @ExcelExportField(name = "实控人证件号", index = 49)
  @ApiModelProperty(value = "实控人证件号")
  private String legControlCardCode;

  @ExcelExportField(name = "备注", index = 50)
  @ApiModelProperty(value = "备注")
  private String remarks;

  @ExcelExportField(name = "返回总数量", index = 51)
  @ApiModelProperty(value = "返回总数量")
  private String benListcount;

  @ExcelExportField(name = "受益人姓名", index = 52)
  @ApiModelProperty(value = "受益人姓名")
  private String legBenName;

  @ExcelExportField(name = "受益人证件类型", index = 53)
  @ApiModelProperty(value = "受益人证件类型")
  private String legBenCardType;

  @ExcelExportField(name = "受益人证件号", index = 54)
  @ApiModelProperty(value = "受益人证件号")
  private String legBenCardCode;

  @ExcelExportField(name = "商户编号", index = 55)
  @ApiModelProperty(value = "商户编号")
  private String mercIds;

  @ExcelExportField(name = "商户个数", index = 56)
  @ApiModelProperty(value = "商户个数")
  private String cusCodeCount;

  @ExcelExportField(name = "涉及结算金额", index = 57)
  @ApiModelProperty(value = "涉及结算金额(后台计算)")
  private String submitAmount;

  @ExcelExportField(name = "处理结果", index = 58)
  @ApiModelProperty(value = "处理结果")
  private String handleResult;

  @ExcelExportField(name = "反馈状态", index = 59)
  @ApiModelProperty(value = "反馈状态")
  private String feedbackStatus;

  @ExcelExportField(name = "反馈日期", index = 60)
  @ApiModelProperty(value = "反馈日期")
  private Date feedbackDate;

  @ExcelExportField(name = "操作人", index = 61)
  @ApiModelProperty(value = "操作人")
  private String operator;

  @ExcelExportField(name = "操作時間", index = 62)
  @ApiModelProperty(value = "操作時間")
  private String operateTime;

  @ExcelExportField(name = "失败原因", index = 63)
  @ApiModelProperty(value = "失败原因")
  private String errInfo;

  public String getTotalOrganNum() {
    return String.valueOf(
        Integer.parseInt(this.stopNum)
            + Integer.parseInt(this.refuseNum)
            + Integer.parseInt(this.useRiseNum)
            + Integer.parseInt(this.frozenNum)
            + Integer.parseInt(this.adjustmentCycleNum)
            + Integer.parseInt(this.delayNum)
            + Integer.parseInt(this.quotaNum)
            + Integer.parseInt(this.suspendNum)
            + Integer.parseInt(this.closeNum)
            + Integer.parseInt(this.followNum)
            + Integer.parseInt(this.antiMoneyNum)
            + Integer.parseInt(this.otherNum));
  }

  public String getErrInfo() {
    return PcacResultCodeEnum.getPcacResultCodeEnum(this.errInfo);
  }

  //    @ApiModelProperty(value = "交易币种")
  //    private String currency;
  //    @ApiModelProperty(value = "推送状态0为未推送，1为已推送")
  //    private String pushStatus;
  //    @ApiModelProperty(value = "交易结果")
  //    private String resultStatus;
  //
  //    @ApiModelProperty(value = "交易返回码")
  //    private String resultCode;

}
