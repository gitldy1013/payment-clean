package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/**
 * @author zhaolei
 * @date 2020-09-17 09:39
 */
public enum  TrnxCodeEnum {

    LOGIN("LR0001","登录"),
    LOGOUT("LR0002","登出"),
    PERSON_RISK_INFO_SUBMIT("PR0001","个人风险信息上报"),
    MERCHANT_RISK_INFO_SUBMIT("ER0001","商户风险信息上报"),
    ENTERPRISE_RISK_INFO_SUBMIT("BR0001","企业风险信息上报"),
    BUSINESS_INFO_SUBMIT("EER001","企业商户信息上报"),
    BLACKLIST_PUSH("TS0001","黑名单推送请求"),
    RISK_TIPS_INFO_PUSH("TS0002","风险提示信息推送"),
    RISK_INFO_REISSUE("TS0004","风险信息补发"),
    LOCAL_ASSOCIATED_RISK_INFO_BACK("UP0006","商户黑名单信息反馈"),
    QUERY_MERCHANT_RISK_INFO_BACK("UP0005","批量商户风险信息查询使用情况反馈"),
    QUERY_MERCHANT_RISK_INFO("QR0003","批量查询商户风险信息"),
    BUSINESS_INFO_REQ("QE0004","企业商户批量查询请求"),
    MERCHANT_INFO_ASSISTANCE_PUSH("TS0003","商户信息比对协查推送"),
    BUSINESS_INFO_BATCH_QUERY_RESULT_PUSH("TS0007","企业商户批量查询结果推送");

    private final String code;
    private final String desc;

    private TrnxCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static String getTrnxCodeEnum (String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (TrnxCodeEnum trnxCodeEnum : TrnxCodeEnum.values()) {
            if (trnxCodeEnum.getCode().equalsIgnoreCase(code)) {
                return trnxCodeEnum.getDesc();
            }
        }
        return code;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

}
