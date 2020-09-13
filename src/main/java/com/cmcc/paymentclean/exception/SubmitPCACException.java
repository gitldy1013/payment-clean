package com.cmcc.paymentclean.exception;

/**
 * @author zhaolei
 * @date 2020-09-11 22:58
 */
public class SubmitPCACException extends RuntimeException {


    private String respCode;
    private String respDesc;

    public SubmitPCACException(String respCode, String respDesc) {
        this.respCode = respCode;
        this.respDesc = respDesc;
    }

    public SubmitPCACException() {
        super();
    }

    public SubmitPCACException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "InnerCipherException{" +
                "respCode=" + respCode +
                ", respDesc='" + respDesc + '\'' +
                '}';
    }
}
