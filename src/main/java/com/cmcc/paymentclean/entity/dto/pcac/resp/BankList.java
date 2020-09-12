package com.cmcc.paymentclean.entity.dto.pcac.resp;

import com.cmcc.paymentclean.entity.dto.pcac.resq.BankInfo;
import lombok.Data;

@Data
public class BankList {
    private String Count;

    private BankInfo BankInfo;
}
