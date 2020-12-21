package com.cmcc.paymentclean.entity.dto.response;


import com.cmcc.paymentclean.entity.dto.response.business.*;
import lombok.Data;



@Data
public class BusinessResultInfo {

    private BaseInfo baseInfo;
    private HisSignList hisSignList;
    private CurSignList curSignList;
    private BlackList blackList;
    private WarningList warningList;
    private LegBlackList legBlackList;
    private LegWarningList legWarningList;



}
