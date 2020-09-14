package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "BenList")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "Count",
        "BenInfo",
})
@Data
public class BenList {
    private String Count = "1";

    private BenInfo BenInfo;
}
