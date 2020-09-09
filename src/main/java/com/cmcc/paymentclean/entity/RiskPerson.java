package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lumma on 2020/9/9.
 * @author lumma
 */
@Data
@ApiModel(value="RiskPerson对象", description="风控个人风险信息同步表")
@TableName("risk_person_risk_sync_info")
public class RiskPerson implements Serializable {
     private static final long serialVersionUID = 1L;

     @ApiModelProperty(value = "id序号")
     @TableId(value = "risk_person_risk_sync_info_id", type = IdType.AUTO)
     private Integer riskPersonRiskSyncInfoId;

     @ApiModelProperty(value = "风险类型")
     private String riskType;

     @ApiModelProperty(value = "内部用户号")
     private String usrno;

     @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
     @ApiModelProperty(value = "有效期")
     private Date validDate ;

     @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
     @ApiModelProperty(value = "风险事件发生时间")
     private Date occurtimeb ;

     @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
     @ApiModelProperty(value = "风险事件结束时间")
     private Date occurtimee ;

     @ApiModelProperty(value = "风险事件发生渠道")
     private String occurchan;

     @ApiModelProperty(value = "风险事件描述")
     private String note;

     @ApiModelProperty(value = "风险信息来源")
     private String sourceChannel;

     @ApiModelProperty(value = "风险事件发生地域")
     private String  occurarea;

     @ApiModelProperty(value = "操作人")
     private String operator;

     @ApiModelProperty(value = "操作时间")
     private Date operateTime;
}
