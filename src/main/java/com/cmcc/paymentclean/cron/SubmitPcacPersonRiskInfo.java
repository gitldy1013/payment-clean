/*
package com.cmcc.paymentclean.cron;

import com.cmcc.paymentclean.entity.PcacPersonRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.*;
import com.cmcc.paymentclean.mapper.PcacPersonRiskSubmitInfoMapper;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @author zhaolei
 * @date 2020-09-11 12:16
 *//*

@Slf4j
public class SubmitPcacPersonRiskInfo implements Job {
    @Autowired
    private PcacPersonRiskSubmitInfoMapper pcacPersonRiskSubmitInfoMapper;

    */
/**
     * 个人风险信息需要加密字段：个人风险信息关键字：手机号、银行帐/卡号、客户姓名、身份证件号码、 固定电话、收款银
     * 行帐/卡号
     * *//*

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       List<PcacPersonRiskSubmitInfo> pcacPersonRiskList = pcacPersonRiskSubmitInfoMapper.selectPcacPersonRiskSubmitInfoList();
       log.debug("查询个人风险信息结果：{}",pcacPersonRiskList);
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        String secretKey = CFCACipherUtils.getSecretKey(symmetricKeyEncoded);

        log.debug("-------开始封装xml报文实体对象------");
        ArrayList<PcacList> pcacLists = new ArrayList<>();
        for (PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo : pcacPersonRiskList) {
            //Map<String, String> toBeEncMap = new HashMap<>();
            //非必填数据本次不加密不上报
           // toBeEncMap.put("mobileNo",pcacPersonRiskSubmitInfo.getMobileNo());
            //toBeEncMap.put("bankNo",pcacPersonRiskSubmitInfo.getBankNo());
            //toBeEncMap.put("cusName",pcacPersonRiskSubmitInfo.getCusName());
            //toBeEncMap.put("docCode",pcacPersonRiskSubmitInfo.getDocCode());
            //toBeEncMap.put("telephone",pcacPersonRiskSubmitInfo.getTelephone());
            //获取随机加密密码

            String encryptDocCode= CFCACipherUtils.encrypt(symmetricKeyEncoded, pcacPersonRiskSubmitInfo.getDocCode());
            pcacPersonRiskSubmitInfo.setDocCode(encryptDocCode);
            PcacList pcacList = new PcacList();

            pcacList.setCount(pcacPersonRiskList.size());
            RiskInfo riskInfo = new RiskInfo();
            BeanUtils.copyProperties(pcacPersonRiskSubmitInfo,riskInfo);
            //validDate、repDate在两个对象中类型不同，所以无法复制属性，需要自己set

            log.info("riskInfo复制的对象属性包括：{}",riskInfo);
            BankList bankList = new BankList();
            bankList.setCount("0");
            riskInfo.setBankList(bankList);
            pcacList.setRiskInfo(riskInfo);
            pcacLists.add(pcacList);

        }
        Body body = new Body();
        body.setPcacList(pcacLists);
        Head head = new Head();
    }
}
*/
