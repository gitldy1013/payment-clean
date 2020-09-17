package com.cmcc.paymentclean.entity.dto.pcac.resq;

import com.cmcc.paymentclean.annotation.ExcelExportField;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "BaseInfo")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "CusType",
        "CusNature",
        "RegName",
        "CusName",
        "CusNameEn",
        "DocType",
        "DocCode",
        "LegDocName",
        "LegDocCode",
        "LegDocType",
        "CusCode",
        "InduType",
        "BankNo",
        "OpenBank",
        "RegAddrProv",
        "RegAddrDetail",
        "AddrProv",
        "AddrDetail",
        "Url",
        "ServerIp",
        "Icp",
        "ContName",
        "ContPhone",
        "CusEmail",
        "Occurarea",
        "NetworkType",
        "Status",
        "StartTime",
        "EndTime",
        "RiskStatus",
        "ShareHolder",
        "OpenType",
        "ChageType",
        "AccountType",
        "ExpandType",
        "OutServiceName",
        "OutServiceCardType",
        "OutServiceCardCode",
        "OutServiceLegCardType",
        "OutServiceLegCardCode",
        "OrgId",
        "RepDate",
        "RepType",
        "RepPerson",
        "UnitProp",
        "SignNum",
        "SignCurrentNum",
        "SignCurrentState",
        "BlackNum",
        "RiskNum",
})
@Data
public class BaseInfo {
    private String CusType;
    private String CusNature;
    private String RegName;
    private String CusName;
    private String CusNameEn;
    private String DocType;
    private String DocCode;
    private String LegDocName;
    private String LegDocType;
    private String LegDocCode;
    private String CusCode;
    private String InduType;
    private String BankNo;
    private String OpenBank;
    private String RegAddrProv;
    private String RegAddrDetail;
    private String AddrProv;
    private String AddrDetail;
    private String Url;
    private String ServerIp;
    private String Icp;
    private String ContName;
    private String ContPhone;
    private String CusEmail;
    private String Occurarea;
    private String NetworkType;
    private String Status;
    private String StartTime;
    private String EndTime;
    private String RiskStatus;
    private String ShareHolder;
    private String OpenType;
    private String ChageType;
    private String AccountType;
    private String ExpandType;
    private String OutServiceName;
    private String OutServiceCardType;
    private String OutServiceCardCode;
    private String OutServiceLegCardType;
    private String OutServiceLegCardCode;
    private String OrgId;
    private String RepDate;
    private String RepType;
    private String RepPerson;
    private String UnitProp;
    @ExcelExportField(name = "签约数量", index = 1)
    private String SignNum;
    @ExcelExportField(name = "当前签约数量", index = 2)
    private String SignCurrentNum;
    @ExcelExportField(name = "是否存在同时签约", index = 3)
    private String SignCurrentState;
    @ExcelExportField(name = "黑名单数量", index = 4)
    private String BlackNum;
    @ExcelExportField(name = "风险提示数量", index = 5)
    private String RiskNum;
}
