package com.cmcc.paymentclean.entity.dto;

import com.cmcc.paymentclean.exception.bizException.BizException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: $ 统一响应结果对象
 * @author: ldy
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean<T> implements Serializable {


    // 处理成功的状态码
    public static final String SUCCESS_CODE = "000";
    // 发生未知错误的状态码
    public static final String UNSPECIFIED_CODE = "500";
    // 服务暂不可用
    public static final String SERVICE_OUT = "002";
    // 未知的方法
    public static final String UNKNOWE_MED = "003";
    // 请求参数无效
    public static final String PARAM_ERR = "100";
    // 无效的IP参数
    public static final String IP_ERR = "114";
    // 无效的操作方法
    public static final String OPT_ERR = "801";
    // 数据库操作出错，请重试
    public static final String DATABASE_TIMEOUT = "805";

    public static final String BIND_CODE = "4005";

    @Builder.Default
    private String resMsg = "success";
    @Builder.Default
    private String resCode = ResultBean.SUCCESS_CODE;

    private T data;

    public ResultBean(String msg, String resCode) {
        this.resMsg = msg;
        this.resCode = resCode;
    }

    public ResultBean(T data) {
        this.data = data;
    }

    public ResultBean(String resCode, T data) {
        this.resCode = resCode;
        this.data = data;
    }

    /**
     * @Description : 此时系统发生未知异常
     * @Param : [e]
     * @Return :
     * @Date : 2019-10-11
     */
    public ResultBean(Throwable e) {
        super();
        this.resMsg = "发生未知错误，请稍后重试!";
        this.resCode = ResultBean.UNSPECIFIED_CODE;
    }

    public ResultBean(BizException e) {
        super();
        this.resMsg = e.getMessage();
        this.resCode = e.getCode();
    }


}
