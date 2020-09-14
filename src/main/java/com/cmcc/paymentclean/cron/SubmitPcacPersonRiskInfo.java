
package com.cmcc.paymentclean.cron;

import com.cmcc.paymentclean.consts.DocTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.entity.PcacPersonRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.RespInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Respone;
import com.cmcc.paymentclean.entity.dto.pcac.resq.*;
import com.cmcc.paymentclean.exception.InnerCipherException;
import com.cmcc.paymentclean.exception.SubmitPCACException;
import com.cmcc.paymentclean.mapper.PcacPersonRiskSubmitInfoMapper;
import com.cmcc.paymentclean.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/*import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;*/


/**
 * @author zhaolei
 * @date 2020-09-11 12:16
 */

@Slf4j
@Component
public class SubmitPcacPersonRiskInfo /*implements Job*/ {
    @Autowired
    private PcacPersonRiskSubmitInfoMapper pcacPersonRiskSubmitInfoMapper;
    @Value("pcac.version")
    private String pcacVersion;

    @Value("orig-sender")
    private  String OrigSender;

    @Value("orig-sender-sid")
    private String OrigSenderSID;

    /**
     * 个人风险信息需要加密字段：个人风险信息关键字：手机号、银行帐/卡号、客户姓名、身份证件号码、 固定电话、收款银
     * 行帐/卡号
     */

   /* @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {*/
    public void submit()  {
        List<PcacPersonRiskSubmitInfo> pcacPersonRiskList = pcacPersonRiskSubmitInfoMapper.selectPcacPersonRiskSubmitInfoList();
        log.debug("查询个人风险信息结果：{}", pcacPersonRiskList);
        if (pcacPersonRiskList.size()==0){
            log.info("当前没有可上报的个人风险信息");
            return;
        }
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
            //判断是身份证类型需要先进行内部解密，再进行清算协会加密
            String encryptDocCode = null;
            if(DocTypeEnum.DOCTYPEENUM_01.getCode().equals(pcacPersonRiskSubmitInfo.getDocType())){
                    //内部解密
                    String docCode = InnerCipherUtils.decrypt(pcacPersonRiskSubmitInfo.getDocCode());
                    //协会加密
                    encryptDocCode = CFCACipherUtils.encrypt(symmetricKeyEncoded,docCode );
            }
            pcacPersonRiskSubmitInfo.setDocCode(encryptDocCode);

            PcacList pcacList = new PcacList();
            pcacList.setCount(pcacPersonRiskList.size());
            RiskInfo riskInfo = new RiskInfo();
            BeanUtils.copyProperties(pcacPersonRiskSubmitInfo, riskInfo);
            //validDate、repDate在两个对象中类型不同，所以无法复制属性，需要自己set
            Date validDate = pcacPersonRiskSubmitInfo.getValidDate();
            riskInfo.setValidDate(validDate.toString());

            Date repDate = new Date(System.currentTimeMillis());
            String repDateStr = DateUtils.formatTime(repDate, "yyyy-MM-DD HH:mm:ss");
            riskInfo.setRepDate(repDateStr);
            log.info("riskInfo复制的对象属性包括：{}", riskInfo);

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
        String trnxTime = DateUtils.formatTime(new Date(), "yyyyMMDDHH:mm:ss");
        head.setTrnxTime(trnxTime);
        head.setUserToken("");
        head.setSecretKey(secretKey);

        Request request = new Request();
        request.setHead(head);
        request.setBody(body);
        Document document = new Document();
        document.setRequest(request);

        String noSignXml = XmlJsonUtils.convertObjectToXmlStr(document);
        String signature = CFCACipherUtils.doSignature(noSignXml);
        document.setSignature(signature);
        String doXml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("个人风险信息上报支付清算协会请求xml报文：",doXml);
        try {
            boolean validate = ValidateUtils.validateXMLByXSD(doXml, "pcac.ries.001");
            if (validate){
                String result = HttpClientUtils.sendHttpsPost("接口地址", doXml);
                log.info("个人风险信息上报支付清算协会响应xml报文：",result);
                com.cmcc.paymentclean.entity.dto.pcac.resp.Document documentResp=
                        (com.cmcc.paymentclean.entity.dto.pcac.resp.Document) com.cmcc.paymentclean.utils.XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class, result);
                String signatureResp = documentResp.getSignature();
                log.info("响应报文的签名串signature：{}",signatureResp);
                documentResp.setSignature(null);
                String noSignXmlResp = XmlJsonUtils.convertObjectToXmlStr(documentResp);
                log.info("不加签名信息的响应报文xml串：{}",noSignXmlResp);
                boolean isSign = CFCACipherUtils.verifySignature(noSignXmlResp, signatureResp);
                if (isSign){
                    Respone respone = documentResp.getRespone();
                    RespInfo respInfo = respone.getBody().getRespInfo();
                    if("S00000".equals(respInfo.getResultCode())&&"01".equals(respInfo.getResultStatus())){
                        //上报成功，修改数据库状态
                        PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo = new PcacPersonRiskSubmitInfo();
                        BeanUtils.copyProperties(respInfo,pcacPersonRiskSubmitInfo);
                        pcacPersonRiskSubmitInfo.setSubmitTime(new Date());
                        pcacPersonRiskSubmitInfo.setSubmitStatus("1");
                        pcacPersonRiskSubmitInfo.setMsgDetail("已上报");
                        log.info("更新数据库表时间和状态信息：{}",pcacPersonRiskSubmitInfo);
                        pcacPersonRiskSubmitInfoMapper.updateByPcacPersonRiskSubmitInfo(pcacPersonRiskSubmitInfo);

                    }

                }else {
                    log.info("------响应报文验签失败-------");
                    throw new SubmitPCACException(ResultCodeEnum.SIGNATURE_FALSE.getCode(),ResultCodeEnum.SIGNATURE_FALSE.getDesc());

                }

            }else {
                log.info("----------xsd文件校验xml格式失败-------");
                throw new SubmitPCACException(ResultCodeEnum.XSD_FILE_VALID_FALSE.getCode(),ResultCodeEnum.XSD_FILE_VALID_FALSE.getDesc());
            }

        }

         catch (Exception e) {
            e.printStackTrace();
        }
    }



}

