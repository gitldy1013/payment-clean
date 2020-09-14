package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "ConditionList")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "Count",
        "ResultSequence",
        "Condition",
})
@Data
public class ConditionList {
    private String Count;

    private String ResultSequence;

    private Condition Condition;

}
