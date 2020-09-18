package com.cmcc.paymentclean.controller;

import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.exception.ParamInvalidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lumma on 2020/9/11.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(ParamInvalidException.class)
    public ResultBean<Object> handleException(HttpServletRequest request, ParamInvalidException ex) {
        final String detailMessage = StringUtils.collectionToDelimitedString(ex.getErrors(), "\n");

        return createResultVO(ResultCodeEnum.ERROR, detailMessage);
    }

    private ResultBean<Object> createResultVO(ResultCodeEnum resultCodeEnum, String detailMessage) {

        return new ResultBean(resultCodeEnum.getCode(), resultCodeEnum.getDesc(), detailMessage);
    }


    /**
     * vatlidated校验异常处理
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean handlerBindException(BindException e) {
        ResultBean resultBean = new ResultBean(ResultBean.PARAM_ERR,
                e.getBindingResult().getFieldError().getDefaultMessage());
        log.error("响应码:{},响应信息:{}", resultBean.getResCode(), resultBean.getResMsg());
        return resultBean;
    }

}
