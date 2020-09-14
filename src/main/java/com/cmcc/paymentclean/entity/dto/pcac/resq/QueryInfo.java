package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "QueryInfo")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "DocCode",
        "RegName",
        "LegDocCode",
        "LegDocName",
})
@Data
public class QueryInfo {
    private String DocCode;

    private String RegName;

    private String LegDocCode;

    private String LegDocName;

}
