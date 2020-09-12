package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/**
 * Created by lumma on 2020/9/12.
 */
public enum LevelCodeEnum {
    LEVEL_01("01", "一级"),LEVEL_02("02", "二级"),LEVEL_03("03", "三级");

    private final String code;

    private final String desc;

    private LevelCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getLevelDesc (String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (LevelCodeEnum levelCodeEnum : LevelCodeEnum.values()) {
            if (levelCodeEnum.getCode().equalsIgnoreCase(code)) {
                return levelCodeEnum.getDesc();
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
