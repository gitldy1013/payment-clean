package com.cmcc.paymentclean.exception;

import com.cmcc.paymentclean.exception.bizException.BizExceptionCode;
import com.cmcc.paymentclean.exception.bizException.BizExceptionCodeEnum;

/** @Description : 运行时业务中出现的异常 @Param : @Return : @Author : cmcc */
public class NoSuchAddressException extends RuntimeException {

  private static final long serialVersionUID = -7864604160297181941L;

  private final String code;

  /** @Description : 指定枚举类中的错误类 @Param : [errorCode] @Return : @Author : cmcc */
  public NoSuchAddressException(final BizExceptionCode exceptionCode) {
    super(exceptionCode.getMessage());
    this.code = exceptionCode.getCode();
  }
  /** @Description : 指定具体业务错误的信息 @Param : [detailedMessage] @Return : @Author : cmcc */
  public NoSuchAddressException(final String message) {
    super(message);
    this.code = BizExceptionCodeEnum.SPECIFIED.getCode();
  }

  public String getCode() {
    return code;
  }
}
