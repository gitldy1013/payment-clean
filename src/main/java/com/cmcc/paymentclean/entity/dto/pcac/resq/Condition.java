package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "Condition")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "QueryInfo",
        "Count",
        "ResultCondition",
})
@Data
public class Condition {
    private QueryInfo QueryInfo;

    private String Count;

    private ResultCondition ResultCondition;

}
