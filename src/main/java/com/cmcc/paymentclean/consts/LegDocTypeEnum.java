package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/**
 * Created by lumma on 2020/9/12.
 */
public enum LegDocTypeEnum {
    LEGDOCTYPEENUM_01("01", "身份证"),
    LEGDOCTYPEENUM_02("02", "护照"),
    LEGDOCTYPEENUM_03("03", "军官证"),
    LEGDOCTYPEENUM_04("04", "户口簿"),
    LEGDOCTYPEENUM_05("05", "士兵证"),
    LEGDOCTYPEENUM_06("06", "港澳居民来往内地通行证"),
    LEGDOCTYPEENUM_07("07", "台湾同胞来往内地通行证"),
    LEGDOCTYPEENUM_08("08", "临时身份证"),
    LEGDOCTYPEENUM_09("09", "外国人居留证"),
    LEGDOCTYPEENUM_10("10", "警官证"),
    LEGDOCTYPEENUM_11("11", "港澳居民居住证"),
    LEGDOCTYPEENUM_12("12", "台湾居民居住证"),
    LEGDOCTYPEENUM_99("99", "其他")

    ;

    private final String code;

    private final String desc;

    private LegDocTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getLegDocTypeDesc (String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (LegDocTypeEnum legDocTypeEnum : LegDocTypeEnum.values()) {
            if (legDocTypeEnum.getCode().equalsIgnoreCase(code)) {
                return legDocTypeEnum.getDesc();
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
