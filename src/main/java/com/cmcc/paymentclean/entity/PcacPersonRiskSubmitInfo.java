package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.cmcc.paymentclean.annotation.EncrField;
import com.cmcc.paymentclean.annotation.InnerEncrField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 协会个人风险信息上报表
 *
 * @author zhaolei
 * @since 2020-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PcacPersonRiskSubmitInfo对象", description = "协会个人风险信息上报表 ")
public class PcacPersonRiskSubmitInfo extends Model<PcacPersonRiskSubmitInfo> {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "id序号")
  @TableId(value = "pcac_person_risk_submit_info_id", type = IdType.AUTO)
  private Integer pcacPersonRiskSubmitInfoId;

  @ApiModelProperty(value = "客户属性")
  private String cusProperty;

  @ApiModelProperty(value = "风险类型")
  private String riskType;

  @EncrField
  @ApiModelProperty(value = "手机号")
  private String mobileNo;

  @ApiModelProperty(value = "MAC 地址")
  private String mac;

  @ApiModelProperty(value = "Imei（Imei 必须为小于或等于 32 位数字组成）")
  private String imei;

  @EncrField
  @ApiModelProperty(value = "付款账户/付款银行卡号（支付账户）")
  private String bankNo;

  @ApiModelProperty(value = "开户机构")
  private String openBank;

  @EncrField
  @ApiModelProperty(value = "个人姓名")
  private String cusName;

  @ApiModelProperty(value = "证件类型")
  private String docType;

  @InnerEncrField
  @ApiModelProperty(value = "证件号码")
  private String docCode;

  @ApiModelProperty(value = "IP 地址")
  private String ip;

  @ApiModelProperty(value = "收货地址")
  private String address;

  @EncrField
  @ApiModelProperty(value = "固定电话")
  private String telephone;

  @ApiModelProperty(value = "中转或收款 0 收款 1 中转")
  private String isTransfer;

  @ApiModelProperty(value = "中转或收款人姓名")
  private String recName;

  @ApiModelProperty(value = "中转或收款人证件类型")
  private String recDocType;

  @ApiModelProperty(value = "中转或收款人证件号")
  private String recDocCode;

  @ApiModelProperty(value = "中转或收款银行卡号（支付账户） ， 不校验格式")
  private String recBankNo;

  @ApiModelProperty(value = "中转或收款开户机构")
  private String recOpenBank;

  @ApiModelProperty(value = "收款人所在国家或地区")
  private String recHostArea;

  @ApiModelProperty(value = "邮箱")
  private String email;

  @ApiModelProperty(value = "有效期")
  private Date validDate;

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

  @ApiModelProperty(value = "上报机构")
  private String orgId;

  @ApiModelProperty(value = "上报日期")
  private Date repDate;

  @ApiModelProperty(value = "上传方式（值： 03）")
  private String repType;

  @ApiModelProperty(value = "上传人")
  private String repPerson;

  @ApiModelProperty(value = "风险信息来源")
  private String sourceChannel;

  @ApiModelProperty(value = "硬盘序列号")
  private String diskNumber;

  @ApiModelProperty(value = "交易币种")
  private String currency;

  @ApiModelProperty(value = "交易金额")
  private String amount;

  @ApiModelProperty(value = "风险事件发现时间")
  private Date riskFindTime;

  @ApiModelProperty(value = "内部用户号")
  @TableField("usrNo")
  private String usrNo;

  @ApiModelProperty(value = "操作人")
  private String operator;

  @ApiModelProperty(value = "操作时间")
  private Date operateTime;

  @ApiModelProperty(value = "上报时间")
  private Date submitTime;

  @ApiModelProperty(value = "报送状态0为未报送，1为已报送")
  private String submitStatus;

  @ApiModelProperty(value = "交易结果")
  private String resultStatus;

  @ApiModelProperty(value = "交易返回码")
  private String resultCode;

  @ApiModelProperty(value = "错误详情")
  private String msgDetail;

  @Override
  protected Serializable pkVal() {
    return this.pcacPersonRiskSubmitInfoId;
  }
}
