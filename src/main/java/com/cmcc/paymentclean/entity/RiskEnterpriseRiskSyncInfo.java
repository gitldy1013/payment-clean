package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 风控企业风险信息同步表 
 * </p>
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="RiskEnterpriseRiskSyncInfo对象", description="风控企业风险信息同步表 ")
public class RiskEnterpriseRiskSyncInfo extends Model<RiskEnterpriseRiskSyncInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id序号")
    @TableId(value = "risk_enterprise_risk_sync_info_id", type = IdType.AUTO)
    private Integer riskEnterpriseRiskSyncInfoId;

    @ApiModelProperty(value = "风险类型")
    private String riskType;

    @ApiModelProperty(value = "单位支付账户编号")
    @TableField("payAccountNo")
    private String payAccountNo;

    @ApiModelProperty(value = "风险事件发生时间")
    private LocalDate occurtimeb;

    @ApiModelProperty(value = "风险事件结束时间")
    private LocalDate occurtimee;

    @ApiModelProperty(value = "风险事件描述")
    private String note;

    @ApiModelProperty(value = "风险信息来源")
    private String sourceChannel;

    @ApiModelProperty(value = "有效期")
    private LocalDate validDate;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作时间")
    private LocalDate operateTime;


    @Override
    protected Serializable pkVal() {
        return this.riskEnterpriseRiskSyncInfoId;
    }

}
