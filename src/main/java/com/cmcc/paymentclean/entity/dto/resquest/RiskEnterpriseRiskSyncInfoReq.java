package com.cmcc.paymentclean.entity.dto.resquest;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by lumma on 2020/9/9.
 */
@Data
@ApiModel(value="RiskEnterprise对象", description="风控企业风险信息同步表")
@TableName("risk_enterprise_risk_sync_info")
public class RiskEnterpriseRiskSyncInfoReq implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "风险类型不能为空")
    @ApiModelProperty(value = "风险类型")
    private String riskType;

    @NotNull(message = "机构代码不能为空")
    @ApiModelProperty(value = "机构代码")
    private String cusCode;

    @NotNull(message = "风险事件发生时间不能为空")
    @ApiModelProperty(value = "风险事件发生时间")
    private Date occurtimeb;

    @NotNull(message = "风险事件结束时间不能为空")
    @ApiModelProperty(value = "风险事件结束时间")
    private Date occurtimee;

    @ApiModelProperty(value = "风险事件描述")
    private String note;

    @NotNull(message = "风险信息来源不能为空")
    @ApiModelProperty(value = "风险信息来源")
    private String sourceChannel;

    @NotNull(message = "有效期不能为空")
    @ApiModelProperty(value = "有效期")
    private Date validDate;

    @NotNull(message = "操作人不能为空")
    @ApiModelProperty(value = "操作人")
    private String operator;
}
