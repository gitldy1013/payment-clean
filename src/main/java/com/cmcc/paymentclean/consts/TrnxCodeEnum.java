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
    RISK_INFO_REISSUE("TS0004","风险信息补发");

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
