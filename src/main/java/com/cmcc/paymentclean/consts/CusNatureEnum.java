package com.cmcc.paymentclean.consts;
import org.springframework.util.StringUtils;

//商户属性
public enum CusNatureEnum {
    CusNatureEnum_01("01","实体特约商户"),
    CusNatureEnum_02("02","网络特约商户"),
    CusNatureEnum_03("03","实体兼网络特约商户");

    private final String code;
    private final String desc;

    private CusNatureEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static String getCusNatureEnum (String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (CusNatureEnum cusNatureEnum : CusNatureEnum.values()) {
            if (cusNatureEnum.getCode().equalsIgnoreCase(code)) {
                return cusNatureEnum.getDesc();
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
