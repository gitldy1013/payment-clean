package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 风控个人风险信息同步表
 *
 * @author cmcc
 * @since 2020-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "RiskPersonRiskSyncInfo对象", description = "风控个人风险信息同步表 ")
public class RiskPersonRiskSyncInfo extends Model<RiskPersonRiskSyncInfo> {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "id序号")
  @TableId(value = "risk_person_risk_sync_info_id", type = IdType.AUTO)
  private Integer riskPersonRiskSyncInfoId;

  @ApiModelProperty(value = "风险类型")
  private String riskType;

  @ApiModelProperty(value = "内部用户号")
  @TableField("usrNo")
  private String usrNo;

  @ApiModelProperty(value = "有效期")
  private Date validDate;

  @ApiModelProperty(value = "风险事件发生时间")
  private Date occurtimeb;

  @ApiModelProperty(value = "风险事件结束时间")
  private Date occurtimee;

  @ApiModelProperty(value = "风险事件发生渠道")
  private String occurchan;

  @ApiModelProperty(value = "风险事件描述")
  private String note;

  @ApiModelProperty(value = "风险信息来源")
  private String sourceChannel;

  @ApiModelProperty(value = "风险事件发生地域")
  private String occurarea;

  @ApiModelProperty(value = "操作人")
  private String operator;

  @ApiModelProperty(value = "操作时间")
  private Date operateTime;

  @Override
  protected Serializable pkVal() {
    return this.riskPersonRiskSyncInfoId;
  }
}
