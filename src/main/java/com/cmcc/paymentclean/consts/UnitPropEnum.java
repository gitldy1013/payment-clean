package com.cmcc.paymentclean.consts;

import org.springframework.util.StringUtils;

/**
 * Created by lumma on 2020/9/19.
 */
public enum UnitPropEnum {
    UNITPROP_01("01", "国家机关"),
    UNITPROP_02("02", "全额事业单位"),
    UNITPROP_03("03", "差额事业单位"),
    UNITPROP_04("04", "自收自支事业单位"),
    UNITPROP_05("05", "有限责任公司"),
    UNITPROP_06("06", "股份有限公司"),
    UNITPROP_07("07", "合伙企业"),
    UNITPROP_08("08", "办事处(代表处、联络处)"),
    UNITPROP_09("09", "社会团体"),
    UNITPROP_10("10", "独资企业"),
    UNITPROP_11("11", "民办非企业单位"),
    UNITPROP_12("12", "其他");

    private final String code;
    private final String desc;

    private UnitPropEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static String getUnitPropEnum (String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (UnitPropEnum unitPropEnum : UnitPropEnum.values()) {
            if (unitPropEnum.getCode().equalsIgnoreCase(code)) {
                return unitPropEnum.getDesc();
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
