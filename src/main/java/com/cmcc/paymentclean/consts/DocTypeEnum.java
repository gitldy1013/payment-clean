package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/**
 * @author zhaolei
 * @date 2020-09-14 15:02
 */
public enum DocTypeEnum {
//    01:营业执照编码 02:统一社会信息代码 03:组织机构代码证 04:经营许可证 05：税务登记证 99:其他
    DOCTYPEENUM_01("01", "营业执照编码"),
    DOCTYPEENUM_02("02", "统一社会信息代码"),
    DOCTYPEENUM_03("03", "组织机构代码证"),
    DOCTYPEENUM_04("04", "经营许可证"),
    DOCTYPEENUM_05("05", "税务登记证"),
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
