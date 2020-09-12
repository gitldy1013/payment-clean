package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

@Data
public class BankInfo {
    private String IsTransfer;

    private String BankNo;

    private String OpenBank;

    private String RecName;

    private String RecDocType;

    private String RecDocCode;

    private String RecBankNo;

    private String RecOpenBank;
}
