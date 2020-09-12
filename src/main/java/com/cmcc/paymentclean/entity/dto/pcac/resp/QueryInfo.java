package com.cmcc.paymentclean.entity.dto.pcac.resp;

import lombok.Data;

@Data
public class QueryInfo {
    private String RiskType;
    private String ReqDate;
    private String ReqDateEnd;

    private String MobileNo;
    private String Mac;
    private String Imei;
    private String BankNo;
    private String OpenBank;
    private String CusName;
    private String DocType;
    private String DocCode;
    private String Ip;
    private String Address;
    private String Telephone;
    private String RecBankNo;
    private String RecOpenBank;
    private String Email;
    private String Occurtimeb;
    private String Occurtimee;
    private String Occurchan;
    private String Occurarea;
    private String RecHostArea;
    private String Scope;
    private String ValidStatus;

    private String CusNature;
    private String RegName;
    private String CusCode;
    private String LegRepName;
    private String LegDocCode;
    private String Url;
    private String ServerIp;
    private String Icp;
    private String Level;
    private String RegisteredArea;
    private String RegisteredCode;
}
