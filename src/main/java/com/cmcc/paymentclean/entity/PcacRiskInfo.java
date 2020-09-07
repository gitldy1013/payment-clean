package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商户黑名单提示信息表
 * </p>
 *
 * @author cmcc
 * @since 2020-09-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="PcacRiskInfo对象", description="商户黑名单提示信息表")
public class PcacRiskInfo extends Model<PcacRiskInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id序号")
    @TableId(value = "pcac_risk_info_id", type = IdType.AUTO)
    private Integer pcacRiskInfoId;

    @ApiModelProperty(value = "推送日期")
    private String upDate;

    @ApiModelProperty(value = "商户名称")
    private byte[] regName;

    @ApiModelProperty(value = "商户简称")
    private String cusName;

    @ApiModelProperty(value = "法人证件类型")
    private String docType;

    @ApiModelProperty(value = "法人证件号码")
    private String docCode;

    @ApiModelProperty(value = "法定代表人姓名")
    private String legDocName;

    @ApiModelProperty(value = "法定代表人姓名")
    private String legDocType;

    @ApiModelProperty(value = "法定代表人（负责人） 证件号码")
    private String legDocCode;

    @ApiModelProperty(value = "风险信息等级")
    private String level;

    @ApiModelProperty(value = "风险类型")
    private String riskType;

    @ApiModelProperty(value = "有效期")
    private String validDate;

    @ApiModelProperty(value = "有效性")
    private String validStatus;

    @ApiModelProperty(value = "商户类型")
    private String cusType;

    @ApiModelProperty(value = "风险事件发生地域，省级/地市，可多选，逗号隔开")
    private String occurarea;

    @ApiModelProperty(value = "银行结算账户")
    private String bankNo;

    @ApiModelProperty(value = "网址")
    private String url;

    @ApiModelProperty(value = "商户注册号")
    private String registeredCode;


    @Override
    protected Serializable pkVal() {
        return this.pcacRiskInfoId;
    }

}
