package com.cmcc.paymentclean.entity.dto.response;

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
@ApiModel(value = "风险个人查询结果参数")
public class RiskPersonResp implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "内部用户号")
    private String usrNo;

    @ApiModelProperty(value = "手机号")
    private String mobileNo;

    @ApiModelProperty(value = "个人姓名")
    private String cusName;

    @ApiModelProperty(value = "客户属性 ：01：个人 02：商户 03: ETC 04：企业")
    private String cusProperty;

    @ApiModelProperty(value = "风险类型 ：01：虚假申请（受害人信息） 02：虚假申请（嫌疑人信息） 03：伪卡（受害人信息） 04：失窃卡（受害人信息）" +
            " 05：未达卡（受害人信息） 06：银行卡转移（受害人信息） 07：盗用银行卡（嫌疑人信息） 08：银行卡网络欺诈（受害人信息） 09：银行卡网络欺诈（嫌疑人信息）" +
            " 10：虚拟账户被盗（受害人信息） 11：盗用虚拟账户（嫌疑人信息） 12：套现(嫌疑人信息) 13 ：协助转移赃款 14 ：买卖或租借银行（支付）账户 15：专案风险信息" +
            " 17: 套利行为 18:发卡侧风险 19:伪造、变造票据 20:伪造、变造签章 21:ETC 恶意欠款(客车) 22:ETC 恶意欠款(货车) 23:套取 ETC 设备(嫌疑人信息) " +
            "24:套取 ETC 设备(受害人信息) 25:ETC 专案风险信息 26:跨境赌博账户 (受害人) 27:跨境赌博付款账户(参赌嫌疑人) 28:跨境赌博资金中转账户 (受害人) " +
            "29:跨境赌博资金中转账户(赌博庄家共同嫌疑人) 30：跨境赌博收款账户(赌博庄家) 31：电信网络诈骗 99 ：其他")
    private String riskType;

    @ApiModelProperty(value = "证件类型 ： 01:身份证 02:护照 03:军官证 04:户口簿 05:士兵证 06:港澳居民来往内地通行证 07:台湾同胞来往内地通行证 08:临时身份证 " +
            "09:外国人居留证 10:警官证 11:港澳居民居住证 12:台湾居民居住证 99:其他")
    private String docType;

    @ApiModelProperty(value = "证件号码")
    private String docCode;

    @ApiModelProperty(value = "付款账户/付款银行卡号（支付账户）")
    private String bankNo;

    @ApiModelProperty(value = "开户机构")
    private String openBank;

    @ApiModelProperty(value = "有效期")
    private Date validDate;

    @ApiModelProperty(value = "有效性 ： 01：有效 02：失效")
    private String validStatus;

    @ApiModelProperty(value = "风险事件发生时间")
    private Date occurtimeb;

    @ApiModelProperty(value = "风险事件发生地域")
    private String occurarea;

    @ApiModelProperty(value = "风险事件描述")
    private String note;

    @ApiModelProperty(value = "风险信息来源渠道 ：GA:公检法等外部行政机构 RH:人民银行等监管机构 HY:会员机构 QS:清算机构 XH:协会风险模型预警 LHG:联合国 " +
            "OFAC:美国财政部海外资产控制办公室 QT:其他")
    private String sourceChannel;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作时间")
    private Date operateTime;

    @ApiModelProperty(value = "上报时间")
    private Date submitTime;

    @ApiModelProperty(value = "报送状态")
    private String submitStatus;

    @ApiModelProperty(value = "失败原因")
    private String failureReason;
}
