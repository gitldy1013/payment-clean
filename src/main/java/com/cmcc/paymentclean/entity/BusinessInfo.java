package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.cmcc.paymentclean.annotation.ExcelExportField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业商户信息表
 *
 * @author cmcc
 * @since 2020-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "BusinessInfo对象", description = "企业商户信息表 ")
public class BusinessInfo extends Model<BusinessInfo> {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "序号id")
  @TableId(value = "business_info_id", type = IdType.AUTO)
  private Integer businessInfoId;

  @ExcelExportField(name = "商户类型", index = 1)
  @ApiModelProperty(value = "商户类型")
  private String cusType;

  @ExcelExportField(name = "商户英文名称", index = 2)
  @ApiModelProperty(value = "商户英文名称")
  private String cusNameEn;

  @ExcelExportField(name = "商户属性", index = 3)
  @ApiModelProperty(value = "商户属性")
  private String cusNature;

  @ExcelExportField(name = "商户简称", index = 4)
  @ApiModelProperty(value = "商户简称")
  private String cusName;

  @ExcelExportField(name = "商户名称/企业名称", index = 5)
  @ApiModelProperty(value = "商户名称/企业名称")
  private String regName;

  @ExcelExportField(name = "商户代码", index = 6)
  @ApiModelProperty(value = "商户代码，最长不能超过 32 个字符")
  private String cusCode;

  @ExcelExportField(name = "法人证件类型", index = 7)
  @ApiModelProperty(value = "法人证件类型")
  private String docType;

  @ExcelExportField(name = "法人证件号码", index = 8)
  @ApiModelProperty(value = "法人证件号码")
  private String docCode;

  @ExcelExportField(name = "商户行业类别", index = 9)
  @ApiModelProperty(value = "商户行业类别")
  private String induType;

  @ExcelExportField(name = "法定代表人姓名", index = 10)
  @ApiModelProperty(value = "法定代表人姓名")
  private String legDocName;

  @ExcelExportField(name = "商户注册地址省市", index = 11)
  @ApiModelProperty(value = "商户注册地址省市")
  private String regAddrProv;

  @ExcelExportField(name = "商户注册地址", index = 12)
  @ApiModelProperty(value = "商户注册地址")
  private String regAddrDetail;

  @ExcelExportField(name = "商户经营地址", index = 13)
  @ApiModelProperty(value = "商户经营地址")
  private String addrDetail;

  @ExcelExportField(name = "外包服务机构法人证件类型", index = 14)
  @ApiModelProperty(value = "外包服务机构法人证件类型")
  private String outServiceCardType;

  @ExcelExportField(name = "上报机构", index = 15)
  @ApiModelProperty(value = "上报机构")
  private String orgId;

  @ExcelExportField(name = "上报日期", index = 16)
  @ApiModelProperty(value = "上报日期")
  private Date repDate;

  @ExcelExportField(name = "上传方式", index = 17)
  @ApiModelProperty(value = "上传方式")
  private String repType;

  @ExcelExportField(name = "上传人", index = 18)
  @ApiModelProperty(value = "上传人")
  private String repPerson;

  @ExcelExportField(name = "外包服务机构法人证件号码", index = 19)
  @ApiModelProperty(value = "外包服务机构法人证件号码")
  private String outServiceCardCode;

  @ExcelExportField(name = "外包服务机构法定代表人证件类型", index = 20)
  @ApiModelProperty(value = "外包服务机构法定代表人证件类型")
  private String outServiceLegCardType;

  @ExcelExportField(name = "外包服务机构法定代表人证件号码", index = 21)
  @ApiModelProperty(value = "外包服务机构法定代表人证件号码")
  private String outServiceLegCardCode;

  @ExcelExportField(name = "单位性质", index = 22)
  @ApiModelProperty(value = "单位性质")
  private String unitProp;

  @ExcelExportField(name = "股东信息", index = 23)
  @ApiModelProperty(value = "股东信息")
  private String shareHolder;

  @ExcelExportField(name = "开通业务种类", index = 24)
  @ApiModelProperty(value = "开通业务种类")
  private String openType;

  @ExcelExportField(name = "计费类型", index = 25)
  @ApiModelProperty(value = "计费类型")
  private String chageType;

  @ExcelExportField(name = "支持账户类型", index = 26)
  @ApiModelProperty(value = "支持账户类型")
  private String accountType;

  @ExcelExportField(name = "拓展方式", index = 27)
  @ApiModelProperty(value = "拓展方式")
  private String expandType;

  @ExcelExportField(name = "外包服务机构名称", index = 28)
  @ApiModelProperty(value = "外包服务机构名称")
  private String outServiceName;

  @ExcelExportField(name = "商户状态", index = 29)
  @ApiModelProperty(value = "商户状态")
  private String status;

  @ExcelExportField(name = "服务起始时间", index = 30)
  @ApiModelProperty(value = "服务起始时间")
  private String startTime;

  @ExcelExportField(name = "服务终止时间", index = 31)
  @ApiModelProperty(value = "服务终止时间")
  private String endTime;

  @ExcelExportField(name = "合规风险状况", index = 32)
  @ApiModelProperty(value = "合规风险状况")
  private String riskStatus;

  @ExcelExportField(name = "交易结果", index = 33)
  @ApiModelProperty(value = "交易结果")
  private String resultStatus;

  @ExcelExportField(name = "商户联系人", index = 34)
  @ApiModelProperty(value = "商户联系人")
  private String contName;

  @ExcelExportField(name = "商户联系电话", index = 35)
  @ApiModelProperty(value = "商户联系电话")
  private String contPhone;

  @ExcelExportField(name = "商户 E-mail", index = 36)
  @ApiModelProperty(value = "商户 E-mail")
  private String cusEmail;

  @ExcelExportField(name = "清算网络", index = 37)
  @ApiModelProperty(value = "清算网络")
  private String networkType;

  @ExcelExportField(name = "商户经营地址(省)", index = 38)
  @ApiModelProperty(value = "商户经营地址(省)")
  private String addrProv;

  @ExcelExportField(name = "法定代表人（负责人） 证件类型", index = 39)
  @ApiModelProperty(value = "法定代表人（负责人） 证件类型")
  private String legDocType;

  @ExcelExportField(name = "法定代表人（负责人）证件号码", index = 40)
  @ApiModelProperty(value = "法定代表人（负责人）证件号码")
  private String legDocCode;

  @ExcelExportField(name = "银行结算账号", index = 41)
  @ApiModelProperty(value = "银行结算账号")
  private String bankNo;

  @ExcelExportField(name = "开户行（支付账户开立机构）", index = 42)
  @ApiModelProperty(value = "开户行（支付账户开立机构）")
  private String openBank;

  @ExcelExportField(name = "网址", index = 43)
  @ApiModelProperty(value = "网址")
  private String url;

  @ExcelExportField(name = "服务器 IP", index = 44)
  @ApiModelProperty(value = "服务器 IP")
  private String serverIp;

  @ExcelExportField(name = "ICP 备案编号", index = 45)
  @ApiModelProperty(value = "ICP 备案编号")
  private String icp;

  @ExcelExportField(name = "商户经营地区范围", index = 46)
  @ApiModelProperty(value = "商户经营地区范围")
  private String occurarea;

  @ExcelExportField(name = "报送状态", index = 47)
  @ApiModelProperty(value = "报送状态0为未报送，1为已报送")
  private String submitStatus;

  @ExcelExportField(name = "交易返回码", index = 48)
  @ApiModelProperty(value = "交易返回码")
  private String resultCode;

  @ExcelExportField(name = "推送状态", index = 49)
  @ApiModelProperty(value = "推送状态")
  private String pushStatus;

  @Override
  protected Serializable pkVal() {
    return this.businessInfoId;
  }
}
