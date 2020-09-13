package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

@Data
public class Document {
    @XmlElement()
    private Request Request;

    private String Signature;
}
