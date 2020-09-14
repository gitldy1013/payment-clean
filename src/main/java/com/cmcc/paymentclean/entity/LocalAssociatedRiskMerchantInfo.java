package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>
 * 本地关联风险商户信息表
 * </p>
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="LocalAssociatedRiskMerchantInfo对象", description="本地关联风险商户信息表 ")
public class LocalAssociatedRiskMerchantInfo extends Model<LocalAssociatedRiskMerchantInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id序号")
    @TableId(value = "local_associated_risk_merchant_info_id", type = IdType.AUTO)
    private Integer localAssociatedRiskMerchantInfoId;

    @ApiModelProperty(value = "商户编号")
    private String cusNumber;

    @ApiModelProperty(value = "推送名单类型")
    private String pushListType;

    @ApiModelProperty(value = "推送日期")
    private String upDate;

    @ApiModelProperty(value = "风险信息等级")
    private String level;

    @ApiModelProperty(value = "风险类型")
    private String riskType;

    @ApiModelProperty(value = "商户简称")
    private String cusName;

    @ApiModelProperty(value = "商户名称")
    private String regName;

    @ApiModelProperty(value = "处理结果")
    private String handleResult;

    @ApiModelProperty(value = "反馈状态")
    private String feedbackStatus;

    @ApiModelProperty(value = "反馈日期")
    private Date feedbackDate;

    @ApiModelProperty(value = "法人证件类型")
    private String docType;

    @ApiModelProperty(value = "法人证件号码")
    private String docCode;

    @ApiModelProperty(value = "法人（负责人）代表姓名")
    private String legRepName;

    @ApiModelProperty(value = "法定代表人证件类型")
    private String legDocType;

    @ApiModelProperty(value = "法定代表人证件号码")
    private String legDocCode;

    @ApiModelProperty(value = "有效期")
    private Date validDate;

    @ApiModelProperty(value = "有效性")
    private String validStatus;

    @ApiModelProperty(value = "商户类型")
    private String cusType;

    @ApiModelProperty(value = "风险事件发生地域")
    private String occurarea;

    @ApiModelProperty(value = "关联商户编号")
    private String assMerNumber;

    @ApiModelProperty(value = "商户状态")
    private String status;

    @ApiModelProperty(value = "是否加黑")
    private String isBlack;

    @ApiModelProperty(value = "关联字段个数")
    private String assFieldCnt;

    @ApiModelProperty(value = "关联字段名称")
    private String assFieldName;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "失败原因")
    private String msgDetail;

    @ApiModelProperty(value = "涉及结算金额")
    private String amount;


    @Override
    protected Serializable pkVal() {
        return this.localAssociatedRiskMerchantInfoId;
    }

}
