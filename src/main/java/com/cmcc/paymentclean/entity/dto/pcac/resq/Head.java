package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

@Data
public class Head {
    private String Version;

    private String Identification;

    private String OrigSender;

    private String OrigSenderSID;

    private String RecSystemId;

    private String TrnxCode;

    private String TrnxTime;

    private String UserToken;

    private String SecretKey;
}
