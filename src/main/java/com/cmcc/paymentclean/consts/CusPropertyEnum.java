package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

//商户类型
public enum CusPropertyEnum {
    CUSPROPERTYENUM_01("01","个人"),
    CUSPROPERTYENUM_02("02","商户"),
    CUSPROPERTYENUM_03("03","ETC"),
    CUSPROPERTYENUM_04("04","企业");


    private final String code;
    private final String desc;

    private CusPropertyEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static String getCusPropertyEnum(String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (CusPropertyEnum cusPropertyEnum : CusPropertyEnum.values()) {
            if (cusPropertyEnum.getCode().equalsIgnoreCase(code)) {
                return cusPropertyEnum.getDesc();
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
