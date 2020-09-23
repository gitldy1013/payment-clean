package com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcacwapper;

import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac033.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Head;
import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * Created by lumma on 2020/9/23.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "head",
        "body"
})
@XmlRootElement(name = "Request")
public class Request033Wapper {
    @XmlElement(name = "Head", required = true)
    protected Head head;
    @XmlElementRef(name = "body")
    protected Body body;
}
