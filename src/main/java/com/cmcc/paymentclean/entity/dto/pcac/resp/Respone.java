package com.cmcc.paymentclean.entity.dto.pcac.resp;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "Respone")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {"Head", "Body"})
@Data
public class Respone {
  private Head Head;

  private Body Body;
}
