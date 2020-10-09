package com.cmcc.paymentclean.exception.bizException;

/** @Description : 业务异常的错误代码接口 @Param : @Return : @Author : cmcc */
public interface BizExceptionCode {

  /** @Description : 获取错误代码 @Param : [] @Return : java.lang.String @Author : cmcc */
  String getCode();

  /** @Description : 获取错误信息 @Param : [] @Return : java.lang.String @Author : cmcc */
  String getMessage();
}
