package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "Head")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "Version",
        "Identification",
        "OrigSender",
        "OrigSenderSID",
        "RecSystemId",
        "TrnxCode",
        "TrnxTime",
        "UserToken",
        "SecretKey",
})
@Data
public class Head {
    private String Version;

    private String Identification;

    private String OrigSender;

    private String OrigSenderSID;

    private String RecSystemId;

    private String TrnxCode;

    private String TrnxTime;

    private String UserToken;

    private String SecretKey;
}
