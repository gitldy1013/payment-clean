package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 企业商户信息表
 * </p>
 *
 * @author cmcc
 * @since 2020-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BusinessInfo对象", description="企业商户信息表 ")
public class BusinessInfo extends Model<BusinessInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "序号id")
    @TableId(value = "business_info_id", type = IdType.AUTO)
    private Integer businessInfoId;

    @ApiModelProperty(value = "商户类型")
    private String cusType;

    @ApiModelProperty(value = "商户英文名称")
    private String cusNameEn;

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

    @ApiModelProperty(value = "商户行业类别")
    private String induType;

    @ApiModelProperty(value = "法定代表人姓名")
    private String legDocName;

    @ApiModelProperty(value = "商户注册地址省市")
    private String regAddrProv;

    @ApiModelProperty(value = "商户注册地址")
    private String regAddrDetail;

    @ApiModelProperty(value = "商户经营地址")
    private String addrDetail;

    @ApiModelProperty(value = "外包服务机构法人证件类型")
    private String outServiceCardType;

    @ApiModelProperty(value = "上报机构")
    private String orgId;

    @ApiModelProperty(value = "上报日期")
    private LocalDateTime repDate;

    @ApiModelProperty(value = "上传方式")
    private String repType;

    @ApiModelProperty(value = "上传人")
    private String repPerson;

    @ApiModelProperty(value = "外包服务机构法人证件号码")
    private String outServiceCardCode;

    @ApiModelProperty(value = "外包服务机构法定代表人证件类型")
    private String outServiceLegCardType;

    @ApiModelProperty(value = "外包服务机构法定代表人证件号码")
    private String outServiceLegCardCode;

    @ApiModelProperty(value = "单位性质")
    private String unitProp;

    @ApiModelProperty(value = "股东信息")
    private String shareHolder;

    @ApiModelProperty(value = "开通业务种类")
    private String openType;

    @ApiModelProperty(value = "计费类型")
    private String chageType;

    @ApiModelProperty(value = "支持账户类型")
    private String accountType;

    @ApiModelProperty(value = "拓展方式")
    private String expandType;

    @ApiModelProperty(value = "外包服务机构名称")
    private String outServiceName;

    @ApiModelProperty(value = "商户状态")
    private String status;

    @ApiModelProperty(value = "服务起始时间")
    private String startTime;

    @ApiModelProperty(value = "服务终止时间")
    private String endTime;

    @ApiModelProperty(value = "合规风险状况")
    private String riskStatus;

    @ApiModelProperty(value = "交易结果")
    private String resultStatus;

    @ApiModelProperty(value = "商户联系人")
    private String contName;

    @ApiModelProperty(value = "商户联系电话")
    private String contPhone;

    @ApiModelProperty(value = "商户 E-mail")
    private String cusEmail;

    @ApiModelProperty(value = "清算网络")
    private String networkType;

    @ApiModelProperty(value = "商户经营地址(省)")
    private String addrProv;

    @ApiModelProperty(value = "法定代表人（负责人） 证件类型")
    private String legDocType;

    @ApiModelProperty(value = "法定代表人（负责人）证件号码")
    private String legDocCode;

    @ApiModelProperty(value = "银行结算账号")
    private String bankNo;

    @ApiModelProperty(value = "开户行（支付账户开立机构）")
    private String openBank;

    @ApiModelProperty(value = "网址")
    private String url;

    @ApiModelProperty(value = "服务器 IP")
    private String serverIp;

    @ApiModelProperty(value = "ICP 备案编号")
    private String icp;

    @ApiModelProperty(value = "商户经营地区范围")
    private String occurarea;

    @ApiModelProperty(value = "报送状态0为未报送，1为已报送")
    private String submitStatus;

    @ApiModelProperty(value = "交易返回码")
    private String resultCode;

    @ApiModelProperty(value = "推送状态")
    private String pushStatus;


    @Override
    protected Serializable pkVal() {
        return this.businessInfoId;
    }

}
