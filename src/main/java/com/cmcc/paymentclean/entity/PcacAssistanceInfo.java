package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商户信息比对协查信息表
 *
 * @author cmcc
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "PcacAssistanceInfo对象", description = "商户信息比对协查信息表")
public class PcacAssistanceInfo extends Model<PcacAssistanceInfo> {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "id序号")
  @TableId(value = "pcac_assistance_info_id", type = IdType.AUTO)
  private Integer pcacAssistanceInfoId;

  @ApiModelProperty(value = "推送日期")
  private String upDate;

  @ApiModelProperty(value = "商户代码")
  private String cusCode;

  @ApiModelProperty(value = "商户名称")
  private String regName;

  @ApiModelProperty(value = "法定代表人（负责人）姓名")
  private String legDocName;

  @ApiModelProperty(value = "商户代码")
  private String difCusCode;

  @ApiModelProperty(value = "商户名称")
  private String difRegName;

  @ApiModelProperty(value = "法定代表人（负责人）姓名")
  private String difLegDocName;

  @Override
  protected Serializable pkVal() {
    return this.pcacAssistanceInfoId;
  }
}
