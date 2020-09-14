package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "WarningList")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "RegName",
        "CusName",
        "DocType",
        "DocCode",
        "LegDocName",
        "LegDocType",
        "LegDocCode",
        "Level",
        "RiskType",
        "ValidDate",
        "ValidStatus",
        "CusType",
        "Occurarea",
})
@Data
public class WarningList
{
    private String RegName;

    private String CusName;

    private String DocType;

    private String DocCode;

    private String LegDocName;

    private String LegDocType;

    private String LegDocCode;

    private String Level;

    private String RiskType;

    private String ValidDate;

    private String ValidStatus;

    private String CusType;

    private String Occurarea;

}
