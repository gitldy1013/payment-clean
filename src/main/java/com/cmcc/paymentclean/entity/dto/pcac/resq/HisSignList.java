package com.cmcc.paymentclean.entity.dto.pcac.resq;

import com.cmcc.paymentclean.annotation.ExcelExportField;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "HisSignList")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "OrgName",
        "Status",
        "StartTime",
        "EndTime",
        "RiskStatus",
        "OpenType",
})
@Data
public class HisSignList {
    @ExcelExportField(name = "机构名称", index = 1)
    private String OrgName;

    @ExcelExportField(name = "商户状态", index = 2)
    private String Status;

    @ExcelExportField(name = "服务起始时间", index = 3)
    private String StartTime;

    @ExcelExportField(name = "服务终止时间", index = 4)
    private String EndTime;

    @ExcelExportField(name = "合规风险状况", index = 5)
    private String RiskStatus;

    @ExcelExportField(name = "开通业务种类", index = 6)
    private String OpenType;

}
