package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 协会商户风险信息上报表
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PcacMerchantRiskSubmitInfo对象", description = "协会商户风险信息上报表 ")
public class PcacMerchantRiskSubmitInfo extends Model<PcacMerchantRiskSubmitInfo> {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "id序号")
  @TableId(value = "pcac_merchant_risk_submit_info_id", type = IdType.AUTO)
  private Integer pcacMerchantRiskSubmitInfoId;

  @ApiModelProperty(value = "商户类型")
  private String cusType;

  @ApiModelProperty(value = "客户属性")
  private String cusProperty;

  @ApiModelProperty(value = "风险类型")
  private String riskType;

  @ApiModelProperty(value = "商户属性")
  private String cusNature;

  @ApiModelProperty(value = "商户简称")
  private String cusName;

  @ApiModelProperty(value = "商户名称/企业名称")
  private String regName;

  @ApiModelProperty(value = "商户代码，最长不能超过 32 个字符")
  private String cusCode;

  @ApiModelProperty(value = "法人证件类型")
  private String docType;

  @ApiModelProperty(value = "法人证件号码")
  private String docCode;

  @ApiModelProperty(value = "法定代表人姓名")
  private String legRepName;

  @ApiModelProperty(value = "法定代表人（负责人） 证件类型")
  private String legDocType;

  @ApiModelProperty(value = "法定代表人（负责人）证件号码")
  private String legDocCode;

  @ApiModelProperty(value = "中转或收款 0 收款 1 中转")
  private String isTransfer;

  @ApiModelProperty(value = "银行结算账号")
  private String bankNo;

  @ApiModelProperty(value = "开户行（支付账户开立机构）")
  private String openBank;

  @ApiModelProperty(value = "服务器 IP")
  private String serverIp;

  @ApiModelProperty(value = "法定代表人（负责人） 手机号")
  private String mobileNo;

  @ApiModelProperty(value = "商户实际办公地")
  private String address;

  @ApiModelProperty(value = "ICP 备案编号")
  private String icp;

  @ApiModelProperty(value = "风险信息等级")
  private String level;

  @ApiModelProperty(value = "风险事件发生时间")
  private Date occurtimeb;

  @ApiModelProperty(value = "风险事件结束时间")
  private Date occurtimee;

  @ApiModelProperty(value = "风险事件发生渠道")
  private String occurchan;

  @ApiModelProperty(value = "风险事件发生地域")
  private String occurarea;

  @ApiModelProperty(value = "风险事件描述")
  private String note;

  @ApiModelProperty(value = "有效期")
  private Date validDate;

  @ApiModelProperty(value = "上报机构")
  private String orgId;

  @ApiModelProperty(value = "上报日期")
  private Date repDate;

  @ApiModelProperty(value = "上传方式（值： 03）")
  private String repType;

  @ApiModelProperty(value = "上传人")
  private String repPerson;

  @ApiModelProperty(value = "商户注册国家或地区")
  private String registeredArea;

  @ApiModelProperty(value = "商户注册号码")
  private String registeredCode;

  @ApiModelProperty(value = "风险信息来源")
  private String sourceChannel;

  @ApiModelProperty(value = "交易币种")
  private String currency;

  @ApiModelProperty(value = "交易金额")
  private String amount;

  @ApiModelProperty(value = "风险事件发现时间")
  private Date riskFindTime;

  @ApiModelProperty(value = "实控人姓名")
  private String legControlName;

  @ApiModelProperty(value = "实控人证件类型")
  private String legControlCardType;

  @ApiModelProperty(value = "实控人证件号")
  private String legControlCardCode;

  @ApiModelProperty(value = "备注")
  private String remarks;

  @ApiModelProperty(value = "受益人姓名")
  private String legBenName;

  @ApiModelProperty(value = "受益人证件类型")
  private String legBenCardType;

  @ApiModelProperty(value = "受益人证件号")
  private String legBenCardCode;

  @ApiModelProperty(value = "操作人")
  private String operator;

  @ApiModelProperty(value = "操作时间")
  private Date operateTime;

  @ApiModelProperty(value = "上报时间")
  private Date submitTime;

  @ApiModelProperty(value = "报送状态")
  private String submitStatus;

  @ApiModelProperty(value = "交易结果")
  private String resultStatus;

  @ApiModelProperty(value = "交易返回码")
  private String resultCode;

  @ApiModelProperty(value = "错误详情")
  private String msgDetail;

  @ApiModelProperty(value = "网址")
  private String url;

  @Override
  protected Serializable pkVal() {
    return this.pcacMerchantRiskSubmitInfoId;
  }
}
