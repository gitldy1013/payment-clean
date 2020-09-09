package com.cmcc.paymentclean.consts;

/**
 * Created by lumma on 2020/9/9.
 */
public enum ResultCodeEnum {
    SUCCESS("000", "成功"), ERROR("500", "未知错误"), THE_SERVICE_IS_TEMPORARILY_UNAVAILABLE("002", "服务暂不可用"), UNKNOWN_METHOD(
            "003", "未知的方法"),    INVALID_REQUEST_PARAMETER("100", "请求参数无效"), INVALID_IP_PARAMETER("114",
            "无效的ip参数"), INVALID_OPERATION_METHOD("801", "无效的操作方法"), DATABASE_OPERATION_ERROR("805", "数据库操作出错，请重试");

    private final String code;

    private final String desc;

    private ResultCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
