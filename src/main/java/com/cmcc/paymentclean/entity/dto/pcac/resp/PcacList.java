package com.cmcc.paymentclean.entity.dto.pcac.resp;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "PcacList")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "Count",
        "UpDate",
        "RiskInfo",
        "BenList",
})
@Data
public class PcacList implements Serializable {

    private int Count;

    private String UpDate;

    private RiskInfo RiskInfo;

    private BenList BenList;

}
