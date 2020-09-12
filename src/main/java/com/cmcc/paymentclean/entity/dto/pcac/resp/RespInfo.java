package com.cmcc.paymentclean.entity.dto.pcac.resp;

import lombok.Data;

@Data
public class RespInfo {
    private String ResultStatus;

    private String ResultCode;

    private String MsgDetail;

    private String ResultSequence;
}
