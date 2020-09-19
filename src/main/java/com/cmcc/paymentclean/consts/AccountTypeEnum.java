package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/**
 * Created by lumma on 2020/9/19.
 */
public enum AccountTypeEnum {
    ACCOUNTTYPE_01("01","借记卡"),
    ACCOUNTTYPE_02("02","贷记卡"),
    ACCOUNTTYPE_03("03","支付账户");

    private final String code;
    private final String desc;

    private AccountTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static String getAccountTypeDesc (String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (AccountTypeEnum accountTypeEnum : AccountTypeEnum.values()) {
            if (accountTypeEnum.getCode().equalsIgnoreCase(code)) {
                return accountTypeEnum.getDesc();
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
