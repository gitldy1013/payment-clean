package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 协会企业风险信息上报表
 * </p>
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="PcacEnterpriseRiskSubmitInfo对象", description="协会企业风险信息上报表 ")
public class PcacEnterpriseRiskSubmitInfo extends Model<PcacEnterpriseRiskSubmitInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id序号")
    @TableId(value = "pcac_enterprise_risk_submit_info_id", type = IdType.AUTO)
    private Integer pcacEnterpriseRiskSubmitInfoId;

    @ApiModelProperty(value = "客户属性")
    private String cusProperty;

    @ApiModelProperty(value = "风险类型")
    private String riskType;

    @ApiModelProperty(value = "企业简称")
    private String cusName;

    @ApiModelProperty(value = "法人证件类型")
    private String docType;

    @ApiModelProperty(value = "法人证件号码")
    private String docCode;

    @ApiModelProperty(value = "法定代表人姓名")
    private String legRepName;

    @ApiModelProperty(value = "税务登记证（必须为 15 或 20 位数字组税务登记证（必须为 15 或 20 位数字组成）")
    private String taxRegcer;

    @ApiModelProperty(value = "法定代表人（负责人） 证件类型")
    private String legDocType;

    @ApiModelProperty(value = "法定代表人（负责人）证件号码")
    private String legDocCode;

    @ApiModelProperty(value = "实控人证件类型")
    private String legControlCardType;

    @ApiModelProperty(value = "实控人证件号")
    private String legControlCardCode;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "企业注册地址")
    private String regAddress;

    @ApiModelProperty(value = "商户实际办公地")
    private String address;

    @ApiModelProperty(value = "固定电话")
    private String telePhone;

    @ApiModelProperty(value = "企业经营范围")
    private String businessScope;

    @ApiModelProperty(value = "实控人姓名")
    private String legControlName;

    @ApiModelProperty(value = "风险事件结束时间")
    private LocalDate occurtimee;

    @ApiModelProperty(value = "风险信息来源")
    private String sourceChannel;

    @ApiModelProperty(value = "风险事件发现时间")
    private LocalDate riskFindTime;

    @ApiModelProperty(value = "有效期")
    private LocalDate validDate;

    @ApiModelProperty(value = "风险事件发生地域")
    private String occurarea;

    @ApiModelProperty(value = "企业名称")
    private String regName;

    @ApiModelProperty(value = "机构代码，最长不能超过 32 个字符")
    private String cusCode;

    @ApiModelProperty(value = "银行结算账号")
    private String bankNo;

    @ApiModelProperty(value = "法定代表人（负责人） 手机号")
    private String mobileNo;

    @ApiModelProperty(value = "风险事件描述")
    private String note;

    @ApiModelProperty(value = "风险事件发生时间")
    private LocalDate occurtimeb;

    @ApiModelProperty(value = "上报机构")
    private String orgId;

    @ApiModelProperty(value = "上报日期")
    private LocalDate repDate;

    @ApiModelProperty(value = "上传方式（值： 03）")
    private String repType;

    @ApiModelProperty(value = "上传人")
    private String repPerson;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作时间")
    private LocalDate operateTime;

    @ApiModelProperty(value = "上报时间")
    private LocalDate submitTime;

    @ApiModelProperty(value = "报送状态")
    private String submitStatus;

    @ApiModelProperty(value = "交易结果")
    private String resultStatus;

    @ApiModelProperty(value = "交易返回码")
    private String resultCode;

    @ApiModelProperty(value = "错误详情")
    private String msgDetail;


    @Override
    protected Serializable pkVal() {
        return this.pcacEnterpriseRiskSubmitInfoId;
    }

}
