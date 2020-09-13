package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import java.util.List;

@Data
public class Body {

    private List<PcacList> PcacList;

    private String RiskType;
    private String ReqDate;
    private String ReqDateEnd;

    private String CusProperty;
    private String KeyWord;
    private String Infos;

    private List<ConditionList> ConditionList;

}
