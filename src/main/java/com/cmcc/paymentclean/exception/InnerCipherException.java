package com.cmcc.paymentclean.exception;

/**
 * @author zhaolei
 * @date 2020-09-11 22:58
 */
public class InnerCipherException extends Exception {

  private Integer respCode;
  private String respDesc;

  public InnerCipherException(Integer respCode, String respDesc) {
    this.respCode = respCode;
    this.respDesc = respDesc;
  }

  public InnerCipherException() {
    super();
  }

  public InnerCipherException(String message) {
    super(message);
  }

  @Override
  public String toString() {
    return "InnerCipherException{"
        + "respCode="
        + respCode
        + ", respDesc='"
        + respDesc
        + '\''
        + '}';
  }
}
