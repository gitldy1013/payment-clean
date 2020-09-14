package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "ResultInfo")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "BaseInfo",
        "HisSignList",
        "CurSignList",
        "BlackList",
        "WarningList",
        "LegBlackList",
        "LegWarningList",
})
@Data
public class ResultInfo {
    private BaseInfo BaseInfo;

    private List<HisSignList> HisSignList;

    private List<CurSignList> CurSignList;

    private List<BlackList> BlackList;

    private List<WarningList> WarningList;

    private List<LegBlackList> LegBlackList;

    private List<LegWarningList> LegWarningList;


}
