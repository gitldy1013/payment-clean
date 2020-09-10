package com.cmcc.paymentclean.entity.dto.resquest;

import com.cmcc.paymentclean.utils.PageVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lumma on 2020/9/9.
 * @author lumma
 */
@Data
public class RiskPersonReq extends PageVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "内部用户号")
    private String usrNo;

    @ApiModelProperty(value = "手机号")
    private String mobileNo;

    @ApiModelProperty(value = "证件类型")
    private String docType;

    @ApiModelProperty(value = "证件号码")
    private String docCode;

    @ApiModelProperty(value = "操作开始时间")
    private Date operateStartTime;

    @ApiModelProperty(value = "操作结束时间")
    private Date operateEndTime;

    @ApiModelProperty(value = "上报开始时间")
    private Date submitStartTime;

    @ApiModelProperty(value = "上报结束时间")
    private Date submitEndTime;

    @ApiModelProperty(value = "报送状态")
    private String submitStatus;

    @ApiModelProperty(value = "操作人")
    private String operator;
}