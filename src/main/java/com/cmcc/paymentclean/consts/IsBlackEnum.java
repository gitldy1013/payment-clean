package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/**
 * Created by lumma on 2020/9/12.
 */
public enum IsBlackEnum {
    ISBLACKE_02("02", "风险提示信息"),
    ISBLACKE_01("01", "黑名单");


    private final String code;

    private final String desc;

    private IsBlackEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getIsBlackEnumDesc (String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (IsBlackEnum isBlackEnum : IsBlackEnum.values()) {
            if (isBlackEnum.getCode().equalsIgnoreCase(code)) {
                return isBlackEnum.getDesc();
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
