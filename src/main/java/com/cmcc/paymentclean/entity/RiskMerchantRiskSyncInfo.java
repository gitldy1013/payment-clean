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
 * 风控商户风险信息同步表
 * </p>
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="RiskMerchantRiskSyncInfo对象", description="风控商户风险信息同步表 ")
public class RiskMerchantRiskSyncInfo extends Model<RiskMerchantRiskSyncInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id序号")
    @TableId(value = "risk_merchant_risk_sync_info_id", type = IdType.AUTO)
    private Integer riskMerchantRiskSyncInfoId;

    @ApiModelProperty(value = "商户类型")
    private String cusType;

    @ApiModelProperty(value = "风险类型")
    private String riskType;

    @ApiModelProperty(value = "商户属性")
    private String cusNature;

    @ApiModelProperty(value = "商户编号")
    private String cusNumber;

    @ApiModelProperty(value = "风险信息等级")
    private String level;

    @ApiModelProperty(value = "有效期")
    private LocalDate validDate;

    @ApiModelProperty(value = "风险事件发生时间")
    private LocalDate occurtimeb;

    @ApiModelProperty(value = "风险事件结束时间")
    private LocalDate occurtimee;

    @ApiModelProperty(value = "风险事件描述")
    private String note;

    @ApiModelProperty(value = "风险信息来源")
    private String sourceChannel;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作时间")
    private LocalDate operateTime;


    @Override
    protected Serializable pkVal() {
        return this.riskMerchantRiskSyncInfoId;
    }

}
