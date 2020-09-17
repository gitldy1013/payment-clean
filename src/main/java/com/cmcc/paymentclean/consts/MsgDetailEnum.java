package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

public enum MsgDetailEnum {
    MSGDETAILENUM_00("00","未上报"),
    MSGDETAILENUM_01("01","已上报"),
    MSGDETAILENUM_02("02","上报失败");

    private final String code;
    private final String desc;

    private MsgDetailEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static String getOccurChanEnum(String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (OccurChanEnum occurChanEnum : OccurChanEnum.values()) {
            if (occurChanEnum.getCode().equalsIgnoreCase(code)) {
                return occurChanEnum.getDesc();
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
