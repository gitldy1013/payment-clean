package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "Body")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "PcacList",
        "RiskType",
        "ReqDate",
        "ReqDateEnd",
        "CusProperty",
        "KeyWord",
        "Infos",
        "ConditionList",
})
@Data
public class Body {

    private PcacList PcacList;

    private String RiskType;
    private String ReqDate;
    private String ReqDateEnd;

    private String CusProperty;
    private String KeyWord;
    private String Infos;

    private List<ConditionList> ConditionList;

}
