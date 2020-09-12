package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pcac implements Serializable {

    private int Count;

    private RiskInfo RiskInfo;

}
