package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/**
 * Created by lumma on 2020/9/19.
 */
public enum ExpandTypeEnum {
    EXPANDTYPE_01("01", "自主拓展"),
    EXPANDTYPE_02("02", "外包服务机构推荐")
    ;

    private final String code;

    private final String desc;

    private ExpandTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getExpandTypeDesc (String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (ExpandTypeEnum expandTypeEnum : ExpandTypeEnum.values()) {
            if (expandTypeEnum.getCode().equalsIgnoreCase(code)) {
                return expandTypeEnum.getDesc();
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
