package com.cmcc.paymentclean.entity.dto.resquest;

import com.cmcc.paymentclean.utils.PageVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 风险企业查询接口入参
 * </p>
 *
 * @author lumma
 * @since 2020-09-08
 * @version v1.0 */
@Data
@ApiModel(value = "风险商户查询请求参数")
public class RiskMerchantReq extends PageVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商户代码，最长不能超过 32 个字符")
    private String cusCode;

    @ApiModelProperty(value = "商户名称")
    private String regName;

    @ApiModelProperty(value = "法人证件类型：01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他")
    private String docType;

    @ApiModelProperty(value = "法人证件号码")
    private String docCode;

    @ApiModelProperty(value = "法定代表人证件类型：01:身份证02:护照03:军官证04:户口簿05:士兵证06:港澳居民来往内地通行证07:台湾同胞来往内地通行证08:临时身份证09:外国人居留证10:警官证11:港澳居民居住证12:台湾居民居住证99:其他")
    private String legDocType;

    @ApiModelProperty(value = "法定代表人证件号码")
    private String legDocCode;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "上报开始时间：YYYY-MM-DD")
    private Date submitStartTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "上报结束时间：YYYY-MM-DD")
    private Date submitEndTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "操作开始时间：YYYY-MM-DD")
    private Date operateStartTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "操作结束时间：YYYY-MM-DD")
    private Date operateEndTime;

    @ApiModelProperty(value = "报送状态 ：0为未报送，1为已报送")
    private String submitStatus;

    @ApiModelProperty(value = "操作人")
    private String operator;
}
