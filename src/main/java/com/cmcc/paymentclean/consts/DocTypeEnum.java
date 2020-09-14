package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/**
 * @author zhaolei
 * @date 2020-09-14 15:02
 */
public enum DocTypeEnum {
    DOCTYPEENUM_01("01", "身份证"),
    DOCTYPEENUM_02("02", "护照"),
    DOCTYPEENUM_03("03", "军官证"),
    DOCTYPEENUM_04("04", "户口簿"),
    DOCTYPEENUM_05("05", "士兵证"),
    DOCTYPEENUM_06("06", "港澳居民来往内地通行证"),
    DOCTYPEENUM_07("07", "台湾同胞来往内地通行证"),
    DOCTYPEENUM_08("08", "临时身份证"),
    DOCTYPEENUM_09("09", "外国人居留证"),
    DOCTYPEENUM_10("10", "警官证"),
    DOCTYPEENUM_11("11", "港澳居民居住证"),
    DOCTYPEENUM_12("12", "台湾居民居住证"),
    DOCTYPEENUM_99("99", "其他")

    ;

    private final String code;

    private final String desc;

    private DocTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDocTypeDesc (String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (DocTypeEnum docTypeEnum : DocTypeEnum.values()) {
            if (docTypeEnum.getCode().equalsIgnoreCase(code)) {
                return docTypeEnum.getDesc();
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
