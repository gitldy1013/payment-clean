package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import java.io.Serializable;

@Data
public class PcacList implements Serializable {

    private int Count;

    private String UpDate;

    private RiskInfo RiskInfo;

    private BaseInfo BaseInfo;

    private EntInfo EntInfo;

}
