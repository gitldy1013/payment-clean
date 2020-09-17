package com.cmcc.paymentclean.entity.dto.pcac.resq;

import com.cmcc.paymentclean.annotation.ExcelExportField;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "WarningList")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "RegName",
        "CusName",
        "DocType",
        "DocCode",
        "LegDocName",
        "LegDocType",
        "LegDocCode",
        "Level",
        "RiskType",
        "ValidDate",
        "ValidStatus",
        "CusType",
        "Occurarea",
})
@Data
public class WarningList
{
    @ExcelExportField(name = "商户名称", index = 1)
    private String RegName;

    @ExcelExportField(name = "商户简称", index = 2)
    private String CusName;

    @ExcelExportField(name = "法人证件类型", index = 3)
    private String DocType;

    @ExcelExportField(name = "法人证件号码", index = 4)
    private String DocCode;

    @ExcelExportField(name = "法定代表人姓名", index = 5)
    private String LegDocName;

    @ExcelExportField(name = "法定代表人证件类型", index = 6)
    private String LegDocType;

    @ExcelExportField(name = "法定代表人（负责人）证件号码", index = 7)
    private String LegDocCode;

    @ExcelExportField(name = "风险信息等级", index = 8)
    private String Level;

    @ExcelExportField(name = "风险类型", index = 9)
    private String RiskType;

    @ExcelExportField(name = "有效期", index = 10)
    private String ValidDate;

    @ExcelExportField(name = "有效性", index = 11)
    private String ValidStatus;

    @ExcelExportField(name = "商户类型", index = 12)
    private String CusType;

    @ExcelExportField(name = "风险事件发生地域", index = 13)
    private String Occurarea;
}
