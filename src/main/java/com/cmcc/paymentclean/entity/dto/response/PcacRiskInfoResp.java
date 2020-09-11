package com.cmcc.paymentclean.entity.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by lumma on 2020/9/11.
 */
@Data
@ApiModel(value = "协会风险商户结果出参参数")
public class PcacRiskInfoResp implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "推送名单类型")
    private String pushListType;

    @ApiModelProperty(value = "推送日期")
    private String upDate;

    @ApiModelProperty(value = "风险信息等级")
    private String level;

    @ApiModelProperty(value = "风险类型 ：01 ：虚假申请 02 ：套现、套积分 03 ：违法违规经营 04 ：销赃或协助转移赃款 05 ： 买卖或租借银行（支付）账户 " +
            "06 ：侧录点(恶意) 07 ：伪卡集中使用点(恶意) 08 ：泄露账户及交易信息 09 ：恶意倒闭 10：恶意分单 11 ：移机 12 ：高风险商户 13 ：商户合谋欺诈 " +
            "14 ：破产或停业商户 15 ：强迫交易 17：频繁变更服务机构 18：关联商户涉险 19：买卖银行卡信息 20：拒刷信用卡 21：转嫁手续费 22:支付敏感信息泄露 " +
            "23:非法改装终端 24:切机 25:二清 26:套码 27:冒用申请 28:侧录点(非恶意) 29:洗钱行为 30:套汇 31:逃汇 32:骗汇 33:分拆交易 34:按金交易 " +
            "35:境内外有权机构发布名单 36:发卡侧风险 37:恶意注册 38:伪造、变造票据 39:伪造、变造签章 40:跨境支付虚假、盗用或冒用申请 41:跨境支付大额交易客户、异常客户 " +
            "42:跨境赌博 43:跨境赌博资金中转 44:伪卡集中使用点(非恶意) 45:受理终端(网络支付接口、收款码)挪作违法违规用途 46：赌博 47：赌博资金中转 99：其他")
    private String riskType;

    @ApiModelProperty(value = "商户简称")
    private String cusName;

    @ApiModelProperty(value = "商户名称")
    private String regName;

    @ApiModelProperty(value = "法人证件类型 ：01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他")
    private String docType;

    @ApiModelProperty(value = "法人证件号码")
    private String docCode;

    @ApiModelProperty(value = "法人（负责人）代表姓名")
    private String legRepName;

    @ApiModelProperty(value = "法人（负责人）证件类型")
    private String legDocType;

    @ApiModelProperty(value = "法人（负责人）证件号码")
    private String legDocCode;

    @ApiModelProperty(value = "有效期")
    private String validDate;

    @ApiModelProperty(value = "有效性")
    private String validStatus;

    @ApiModelProperty(value = "商户类型")
    private String cusType;

    @ApiModelProperty(value = "风险事件发生地域")
    private String occurarea;

}
