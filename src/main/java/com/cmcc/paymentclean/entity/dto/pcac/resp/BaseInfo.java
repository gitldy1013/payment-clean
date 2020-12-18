//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.12.18 时间 03:15:20 PM CST 
//


package com.cmcc.paymentclean.entity.dto.pcac.resp;

import lombok.Data;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="SignNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SignCurrentNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SignCurrentState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BlackNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RiskNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "SignNum",
    "SignCurrentNum",
    "SignCurrentState",
    "BlackNum",
    "RiskNum"
})
@XmlRootElement(name = "BaseInfo")
@Data
public class BaseInfo {

    protected String SignNum;
    protected String SignCurrentNum;
    protected String SignCurrentState;
    protected String BlackNum;
    protected String RiskNum;


}
