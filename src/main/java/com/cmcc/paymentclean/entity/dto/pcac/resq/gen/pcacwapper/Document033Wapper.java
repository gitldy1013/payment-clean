package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcacwapper;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * Created by lumma on 2020/9/23.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "request",
        "signature"
})
@XmlRootElement(name = "Document")
public class Document033Wapper {
    @XmlElement(name = "Request", required = true)
    protected Request033Wapper request;
    @XmlElement(name = "Signature", required = true)
    protected String signature;
}
