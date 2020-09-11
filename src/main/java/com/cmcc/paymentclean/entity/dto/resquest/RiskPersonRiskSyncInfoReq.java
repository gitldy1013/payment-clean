package com.cmcc.paymentclean.entity.dto.resquest;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by lumma on 2020/9/9.
 * @author lumma
 */
@Data
@ApiModel(value="RiskPerson对象", description="风控个人风险信息同步表")
@TableName("risk_person_risk_sync_info")
public class RiskPersonRiskSyncInfoReq implements Serializable {
     private static final long serialVersionUID = 1L;

     @NotNull(message = "风险类型不能为空")
     @ApiModelProperty(value = "风险类型")
     private String riskType;

     @ApiModelProperty(value = "内部用户号")
     private String usrNo;

     @NotNull(message = "有效期不能为空")
     @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
     @ApiModelProperty(value = "有效期")
     private LocalDate validDate ;

     @NotNull(message = "风险事件发生时间不能为空")
     @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
     @ApiModelProperty(value = "风险事件发生时间")
     private LocalDate occurtimeb ;

     @NotNull(message = "风险事件结束时间不能为空")
     @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
     @ApiModelProperty(value = "风险事件结束时间")
     private LocalDate occurtimee ;

     @NotNull(message = "风险事件发生渠道不能为空")
     @ApiModelProperty(value = "风险事件发生渠道")
     private String occurchan;

     @ApiModelProperty(value = "风险事件描述")
     private String note;

     @NotNull(message = "风险信息来源不能为空")
     @ApiModelProperty(value = "风险信息来源")
     private String sourceChannel;

     @NotNull(message = "风险事件不能为空")
     @ApiModelProperty(value = "风险事件发生地域")
     private String  occurarea;

     @NotNull(message = "操作人不能为空")
     @ApiModelProperty(value = "操作人")
     private String operator;

}
