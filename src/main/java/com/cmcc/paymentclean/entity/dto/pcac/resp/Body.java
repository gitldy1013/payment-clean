package com.cmcc.paymentclean.entity.dto.pcac.resp;

import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "Body")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(
    propOrder = {
      "RespInfo",
      "QueryInfo",
      "PcacList",
      "ResultInfo"
    })
@Data
public class Body {
  private RespInfo RespInfo;

  private QueryInfo QueryInfo;

  private PcacList PcacList;

  private ResultInfo ResultInfo;

}
