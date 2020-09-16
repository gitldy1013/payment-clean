package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "RiskInfo")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "CusType",
        "CusProperty",
        "RiskType",
        "CusNature",
        "CusName",
        "RegName",
        "CusCode",
        "DocType",
        "DocCode",
        "LegRepName",
        "LegDocType",
        "LegDocCode",
        "BankList",
        "Url",
        "ServerIp",
        "MobileNo",
        "Address",
        "Icp",
        "Level",
        "Occurtimeb",
        "Occurtimee",
        "Occurchan",
        "Occurarea",
        "Note",
        "ValidDate",
        "OrgId",
        "RepDate",
        "RepType",
        "RepPerson",
        "RegisteredArea",
        "RegisteredCode",
        "SourceChannel",
        "Currency",
        "Amount",
        "RiskFindTime",
        "LegControlName",
        "LegControlCardType",
        "LegControlCardCode",
        "Remarks",
        "BenList",
        "Mac",
        "Imei",
        "BankNo",
        "OpenBank",
        "Ip",
        "Telephone",
        "RecHostArea",
        "Email",
        "DiskNumber",
        "TaxRegCer",
        "TelePhone",
        "RegAddress",
        "BusinessScope",
        "LegDocName",
        "ValidStatus",
        "PushDate",
        "HandleResult",
        "HandleTime",
        "Id",
        "HandleNote",
})
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

    private String Mac;

    private String Imei;

    private String BankNo;

    private String OpenBank;

    private String Ip;

    private String Telephone;

    private String RecHostArea;

    private String Email;

    private String DiskNumber;

    private String TaxRegCer;

    private String TelePhone;

    private String RegAddress;

    private String BusinessScope;

    private String LegDocName;

    private String ValidStatus;

    private String PushDate;

    private String HandleResult;

    private String HandleTime;

    private String Id;

    private String HandleNote;


}

