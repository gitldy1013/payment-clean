package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "BankInfo")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "IsTransfer",
        "BankNo",
        "OpenBank",
        "RecName",
        "RecDocType",
        "RecDocCode",
        "RecBankNo",
        "RecOpenBank",
})
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


