package com.cmcc.paymentclean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author zhaolei
 * @since 2020-09-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="QueryPcacMerchantRiskInfo对象", description="")
public class QueryPcacMerchantRiskInfo extends Model<QueryPcacMerchantRiskInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "序号id")
    @TableId(value = "query_pcac_merchant_risk_info_id", type = IdType.AUTO)
    private Integer queryPcacMerchantRiskInfoId;

    @ApiModelProperty(value = "风险反馈主键编码")
    private String Id;

    @ApiModelProperty(value = "商户类型")
    private String cusType;

    @ApiModelProperty(value = "客户属性")
    private String cusProperty;

    @ApiModelProperty(value = "风险类型")
    private String riskType;

    @ApiModelProperty(value = "商户属性")
    private String cusNature;

    @ApiModelProperty(value = "商户简称")
    private String cusName;

    @ApiModelProperty(value = "商户名称/企业名称")
    private String regName;

    @ApiModelProperty(value = "商户代码，最长不能超过 32 个字符")
    private String cusCode;

    @ApiModelProperty(value = "法人证件类型")
    private String docType;

    @ApiModelProperty(value = "法人证件号码")
    private String docCode;

    @ApiModelProperty(value = "法定代表人姓名")
    private String legRepName;

    @ApiModelProperty(value = "法定代表人（负责人） 证件类型")
    private String legDocType;

    @ApiModelProperty(value = "法定代表人（负责人）证件号码")
    private String legDocCode;

    @ApiModelProperty(value = "中转或收款 0 收款 1 中转")
    private String isTransfer;

    @ApiModelProperty(value = "银行结算账号")
    private String bankNo;

    @ApiModelProperty(value = "开户行（支付账户开立机构）")
    private String openBank;

    @ApiModelProperty(value = "网址")
    private String url;

    @ApiModelProperty(value = "服务器 IP")
    private String serverIp;

    @ApiModelProperty(value = "法定代表人（负责人） 手机号")
    private String mobileNo;

    @ApiModelProperty(value = "商户实际办公地")
    private String address;

    @ApiModelProperty(value = "ICP 备案编号")
    private String icp;

    @ApiModelProperty(value = "风险信息等级")
    private String level;

    @ApiModelProperty(value = "风险事件发生时间")
    private Date occurtimeb;

    @ApiModelProperty(value = "风险事件结束时间")
    private Date occurtimee;

    @ApiModelProperty(value = "风险事件发生渠道")
    private String occurchan;

    @ApiModelProperty(value = "终止合作的机构数量")
    private String stopNum;

    @ApiModelProperty(value = "拒绝拓展的机构数量")
    private String refuseNum;

    @ApiModelProperty(value = "暂停办理资金结算的机构数量")
    private String useRiseNum;

    @ApiModelProperty(value = "冻结账户的机构数量")
    private String frozenNum;

    @ApiModelProperty(value = "调整结算周期的机构数量")
    private String adjustmentCycleNum;

    @ApiModelProperty(value = "延迟资金结算的机构数量")
    private String delayNum;

    @ApiModelProperty(value = "设置收款限额的机构数量")
    private String quotaNum;

    @ApiModelProperty(value = "报送反洗钱可疑交易的机构数量")
    private String antiMoneyNum;

    @ApiModelProperty(value = "其他的机构数量")
    private String otherNum;

    @ApiModelProperty(value = "风险事件发现时间")
    private Date riskFindTime;

    @ApiModelProperty(value = "交易金额")
    private String amount;

    @ApiModelProperty(value = "暂停银行卡交易的机构数量")
    private String suspendNum;

    @ApiModelProperty(value = "收回受理终端 (关闭网络支付接口) 的机构数	            收回受理终端 (关闭网络支付接口) 的机构数量")
    private String closeNum;

    @ApiModelProperty(value = "暂未采取控制措施,持续关注客户的机构数量")
    private String followNum;

    @ApiModelProperty(value = "有效性")
    private String validStatus;

    @ApiModelProperty(value = "风险事件发生地域")
    private String occurarea;

    @ApiModelProperty(value = "风险事件描述")
    private String note;

    @ApiModelProperty(value = "有效期")
    private Date validDate;

    @ApiModelProperty(value = "商户注册国家或地区")
    private String registeredArea;

    @ApiModelProperty(value = "商户注册号码")
    private String registeredCode;

    @ApiModelProperty(value = "风险信息来源")
    private String sourceChannel;

    @ApiModelProperty(value = "交易币种")
    private String currency;

    @ApiModelProperty(value = "实控人姓名")
    private String legControlName;

    @ApiModelProperty(value = "实控人证件类型")
    private String legControlCardType;

    @ApiModelProperty(value = "实控人证件号")
    private String legControlCardCode;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "受益人姓名")
    private String legBenName;

    @ApiModelProperty(value = "受益人证件类型")
    private String legBenCardType;

    @ApiModelProperty(value = "受益人证件号")
    private String legBenCardCode;

    @ApiModelProperty(value = "推送状态0为未推送，1为已推送")
    private String pushStatus;

    @ApiModelProperty(value = "交易结果")
    private String resultStatus;

    @ApiModelProperty(value = "交易返回码")
    private String resultCode;

    @ApiModelProperty(value = "推送日期")
    private String upDate;

    @ApiModelProperty(value = "商户编号")
    private String mercIds;

    @ApiModelProperty(value = "操作時間")
    private Date operateTime;

    @Override
    protected Serializable pkVal() {
        return this.queryPcacMerchantRiskInfoId;
    }

}
