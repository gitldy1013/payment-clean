package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "EntInfo")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "CusCode",
        "RegName",
        "LegDocName",
        "Differents",
})
@Data
public class EntInfo {
    private String CusCode;
    private String RegName;
    private String LegDocName;
    private Differents Differents;
}
