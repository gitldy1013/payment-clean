package com.cmcc.paymentclean.entity.dto.pcac.resp;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "QueryInfo")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(
        propOrder = {
                "RiskType",
                "ReqDate",
                "ReqDateEnd",
                "MobileNo",
                "Mac",
                "Imei",
                "BankNo",
                "OpenBank",
                "CusName",
                "DocType",
                "DocCode",
                "Ip",
                "Address",
                "Telephone",
                "RecBankNo",
                "RecOpenBank",
                "Email",
                "Occurtimeb",
                "Occurtimee",
                "Occurchan",
                "Occurarea",
                "RecHostArea",
                "Scope",
                "ValidStatus",
                "CusNature",
                "RegName",
                "CusCode",
                "LegRepName",
                "LegDocCode",
                "Url",
                "ServerIp",
                "Icp",
                "Level",
                "RegisteredArea",
                "RegisteredCode",
                "LegDocName",
                "ResultSequence"
        })
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
    private String LegDocName;
    private String ResultSequence;
}
