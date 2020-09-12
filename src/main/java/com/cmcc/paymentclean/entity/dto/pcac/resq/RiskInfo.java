package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;


@Data
public class RiskInfo {
    private String CusType;

    private String CusProperty;

    private String RiskType;

    private String CusNature;

    private String CusName;

    private String RegName;

    private String CusCode;

    private String DocType;

    private String DocCode;

    private String LegRepName;

    private String LegDocType;

    private String LegDocCode;

    private BankList BankList;

    private String Url;

    private String ServerIp;

    private String MobileNo;

    private String Address;

    private String Icp;

    private String Level;

    private String Occurtimeb;

    private String Occurtimee;

    private String Occurchan;

    private String Occurarea;

    private String Note;

    private String ValidDate;

    private String OrgId;

    private String RepDate;

    private String RepType;

    private String RepPerson;

    private String RegisteredArea;

    private String RegisteredCode;

    private String SourceChannel;

    private String Currency;

    private String Amount;

    private String RiskFindTime;

    private String LegControlName;

    private String LegControlCardType;

    private String LegControlCardCode;

    private String Remarks;

    private BenList BenList;
}
