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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaolei
 * @date 2020-09-11 12:16
 */
@Slf4j
@Component
public class SubmitPcacPersonRiskInfo implements Job {
    @Autowired
    private PcacPersonRiskSubmitInfoMapper pcacPersonRiskSubmitInfoMapper;
    @Value("pcacVersion")
    private String pcacVersion;

    /**
     * 个人风险信息需要加密字段：个人风险信息关键字：手机号、银行帐/卡号、客户姓名、身份证件号码、 固定电话、收款银
     * 行帐/卡号
     * */
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
            LocalDate validDate = pcacPersonRiskSubmitInfo.getValidDate();
            riskInfo.setValidDate(validDate.toString());

            LocalDateTime repDate = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-DD HH:mm:ss");
            String repDateStr = dateTimeFormatter.format(repDate);
            riskInfo.setRepDate(repDateStr);
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
        log.info("请求清算协会版本号：{}",pcacVersion);
        head.setVersion(pcacVersion);
        //报文唯一标识（8 位日期+10 顺序号）
        head.setIdentification("");
        //收单机构收单机构机构号（字母、数字、下划线）
        head.setOrigSender("");
        //收单机构收单机构发送系统号（字母、数字、下划线）
        head.setOrigSenderSID("");
        //协会系统编号， 特约商户信息上报和删除请求时填 SECB01，其余均为 R0001
        head.setRecSystemId("R0001");
        //交易码，见 5.1 报文分类列表（数字、字母）
        head.setTrnxCode("PR0001");
        LocalDateTime trnxTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMDDHH:mm:ss");
        String trnxTimeStr = dateTimeFormatter.format(trnxTime);
        head.setTrnxTime(trnxTimeStr);
        head.setUserToken("");
        head.setSecretKey(secretKey);

        Request request = new Request();
        request.setBody(body);
        new Document();
    }
}
