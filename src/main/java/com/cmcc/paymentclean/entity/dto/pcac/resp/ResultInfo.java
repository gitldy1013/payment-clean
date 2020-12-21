//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.12.18 时间 03:03:44 PM CST 
//


package com.cmcc.paymentclean.entity.dto.pcac.resp;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RegName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DocType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DocCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ResultSequence" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "RegName",
    "DocType",
    "DocCode",
    "ResultSequence",
    "BaseInfo",
    "HisSignList",
    "CurSignList",
    "BlackList",
    "WarningList",
    "LegBlackList",
    "LegWarningList"
})
@XmlRootElement(name = "ResultInfo")
@Data
public class ResultInfo {

    private String RegName;
    private String DocType;
    private String DocCode;
    private String ResultSequence;

    private BaseInfo BaseInfo;
    private HisSignList HisSignList;
    private CurSignList CurSignList;
    private BlackList BlackList;
    private WarningList WarningList;
    private LegBlackList LegBlackList;
    private LegWarningList LegWarningList;



}
