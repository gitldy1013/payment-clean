package com.cmcc.paymentclean.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaolei
 * @date 2020-09-16 11:07
 */
@Data
@NoArgsConstructor
public class LoginResult {

    private String resultStatus;

    private String resultCode;

    private  String userToken;

    public LoginResult(String userToken) {
        this.userToken = userToken;
        this.resultCode="S00000";
        this.resultStatus="01";

    }
    public LoginResult(String resultCode,String resultStatus) {
        this.resultCode=resultCode;
        this.resultStatus=resultStatus;

    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "resultStatus='" + resultStatus + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", userToken='" + userToken + '\'' +
                '}';
    }
}
