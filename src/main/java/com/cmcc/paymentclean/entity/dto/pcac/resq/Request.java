package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "Request")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "Head",
        "Body",
})
@Data
public class Request {
    private Head Head;

    private Body Body;
}
