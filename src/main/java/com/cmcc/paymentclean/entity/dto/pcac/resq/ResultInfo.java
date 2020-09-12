package com.cmcc.paymentclean.entity.dto.pcac.resq;

import lombok.Data;

import java.util.List;

@Data
public class ResultInfo {
    private BaseInfo BaseInfo;

    private List<HisSignList> HisSignList;

    private List<CurSignList> CurSignList;

    private List<BlackList> BlackList;

    private List<WarningList> WarningList;

    private List<LegBlackList> LegBlackList;

    private List<LegWarningList> LegWarningList;


}
