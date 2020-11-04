package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

public enum BlackHandleResultEnum {
    //02.处理中 03.已清退 04.拒绝拓展
    BLACKHANDLERESULTENUM_02("02", "处理中"),
    BLACKHANDLERESULTENUM_03("03", "已清退"),
    BLACKHANDLERESULTENUM_01("04", "拒绝拓展");

    private final String code;

    private final String desc;

    BlackHandleResultEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getBlackHandleResultDesc(String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (BlackHandleResultEnum blackHandleResultEnum : BlackHandleResultEnum.values()) {
            if (blackHandleResultEnum.getCode().equalsIgnoreCase(code)) {
                return blackHandleResultEnum.getDesc();
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
