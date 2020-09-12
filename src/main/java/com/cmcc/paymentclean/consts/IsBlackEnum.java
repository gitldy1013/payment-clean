package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/**
 * Created by lumma on 2020/9/12.
 */
public enum IsBlackEnum {
    ISBLACKENUM_0("0", "是"),
    ISBLACKENUM_1("1", "否");


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
