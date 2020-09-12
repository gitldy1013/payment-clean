package com.cmcc.paymentclean.entity.dto.pcac.resp;

import lombok.Data;

import java.io.Serializable;

@Data
public class PcacList implements Serializable {

    private int Count;

    private String UpDate;

    private RiskInfo RiskInfo;

    private BenList BenList;

}
