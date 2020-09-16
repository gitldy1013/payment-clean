package com.cmcc.paymentclean.consts;
import org.springframework.util.StringUtils;

//风险信息来源
public enum SourChaEnum {
    SourChaEnum_01("GA","公检法等外部行政机构"),
    SourChaEnum_02("RH","人民银行等监管机构"),
    SourChaEnum_03("HY","会员机构"),
    SourChaEnum_04("QS","清算机构"),
    SourChaEnum_05("XH","协会风险模型预警"),
    SourChaEnum_06("LHG","联合国"),
    SourChaEnum_07("OFAC","美国财政部海外资产控制办公室"),
    SourChaEnum_08("QT","其他");

    private final String code;
    private final String desc;

    private SourChaEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static String getSourChaEnum (String code) {
        if (StringUtils.isEmpty(code)) {
            return "";
        }
        for (SourChaEnum sourChaEnum : SourChaEnum.values()) {
            if (sourChaEnum.getCode().equalsIgnoreCase(code)) {
                return sourChaEnum.getDesc();
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
