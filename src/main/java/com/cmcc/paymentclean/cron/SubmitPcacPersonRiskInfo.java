
package com.cmcc.paymentclean.cron;

import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.consts.DocTypeEnum;
import com.cmcc.paymentclean.consts.ResultCodeEnum;
import com.cmcc.paymentclean.consts.TrnxCodeEnum;
import com.cmcc.paymentclean.entity.PcacPersonRiskSubmitInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.RespInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Respone;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001.BankInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001.BankList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac001.RiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Head;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.exception.SubmitPCACException;
import com.cmcc.paymentclean.mapper.PcacPersonRiskSubmitInfoMapper;
import com.cmcc.paymentclean.utils.BeanUtilsEx;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.InnerCipherUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    @Autowired
    private PcacConfig pcacConfig;

    /**
     * 个人风险信息上报清算协会
     * 个人风险信息需要加密字段：个人风险信息关键字：手机号、银行帐/卡号、客户姓名、身份证件号码、 固定电话、收款银
     * 行帐/卡号
     */

   /* @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {*/
    public void submit() {
        List<PcacPersonRiskSubmitInfo> pcacPersonRiskList = pcacPersonRiskSubmitInfoMapper.selectPcacPersonRiskSubmitInfoList();
        Date date = new Date();
        log.debug("查询个人风险信息结果：{}", pcacPersonRiskList);
        if (pcacPersonRiskList.size() == 0) {
            log.info("当前没有可上报的个人风险信息");
            return;
        }
        //获取随机加密密码
        byte[] symmetricKeyEncoded = CFCACipherUtils.getSymmetricKeyEncoded();
        String secretKey = CFCACipherUtils.getSecretKey(symmetricKeyEncoded);

        log.debug("-------开始封装xml报文实体对象------");
        ArrayList<RiskInfo> riskInfos = new ArrayList<>();
        for (PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo : pcacPersonRiskList) {

            //判断是身份证类型需要先进行内部解密，再进行清算协会加密
            String encryptDocCode = null;
            String encryptBankNo = null;
            if (!StringUtils.isEmpty(pcacPersonRiskSubmitInfo.getDocType()) && DocTypeEnum.DOCTYPEENUM_01.getCode().equals(pcacPersonRiskSubmitInfo.getDocType())) {
                //内部解密
                String docCode = InnerCipherUtils.decrypt(pcacPersonRiskSubmitInfo.getDocCode());
                //协会加密
                encryptDocCode = CFCACipherUtils.encrypt(symmetricKeyEncoded, docCode);
            }
            if (!StringUtils.isEmpty(pcacPersonRiskSubmitInfo.getBankNo())) {
                //内部解密
                String bankNo = InnerCipherUtils.decrypt(pcacPersonRiskSubmitInfo.getBankNo());
                //协会加密
                encryptBankNo = CFCACipherUtils.encrypt(symmetricKeyEncoded, bankNo);
            }
            pcacPersonRiskSubmitInfo.setBankNo(encryptBankNo);
            pcacPersonRiskSubmitInfo.setDocCode(encryptDocCode);
            String encryptMobileNo = CFCACipherUtils.encrypt(symmetricKeyEncoded, pcacPersonRiskSubmitInfo.getMobileNo());
            pcacPersonRiskSubmitInfo.setMobileNo(encryptMobileNo);
            String encryptCusName = CFCACipherUtils.encrypt(symmetricKeyEncoded, pcacPersonRiskSubmitInfo.getCusName());
            pcacPersonRiskSubmitInfo.setCusName(encryptCusName);
            String encryptTelephone = CFCACipherUtils.encrypt(symmetricKeyEncoded, pcacPersonRiskSubmitInfo.getTelephone());
            pcacPersonRiskSubmitInfo.setTelephone(encryptTelephone);


            RiskInfo riskInfo = new RiskInfo();
            BeanUtils.copyProperties(pcacPersonRiskSubmitInfo, riskInfo);
            //validDate、repDate在两个对象中类型不同，所以无法复制属性，需要自己set
            Date validDate = pcacPersonRiskSubmitInfo.getValidDate();
            String validDateStr = DateUtils.formatTime(validDate, "yyyy-MM-dd");
            riskInfo.setValidDate(validDateStr);
            String repDateStr = DateUtils.formatTime(date, "yyyy-MM-dd HH:mm:ss");
            riskInfo.setRepDate(repDateStr);
            log.info("riskInfo复制的对象属性包括：{}", riskInfo);

            BankList bankList = new BankList();
            BankInfo bankInfo = new BankInfo();
            /*bankInfo.setIsTransfer("");
            bankInfo.setRecName("");
            bankInfo.setRecDocType("");
            bankInfo.setRecDocCode("");
            bankInfo.setBankNo("");
            bankInfo.setOpenBank("");*/
            BeanUtilsEx.copyProperties(bankInfo, pcacPersonRiskSubmitInfo);
            bankList.setCount("1");
            riskInfo.setBankList(bankList);
            riskInfos.add(riskInfo);
        }
        PcacList pcacLists = new PcacList();
        pcacLists.setCount(riskInfos.size() + "");
        pcacLists.setRiskInfo(riskInfos);
        Body body = new Body();
        body.setPcacList(pcacLists);

        Head head = getHead(secretKey, date);

        Request request = new Request();
        request.setHead(head);
        request.setBody(body);
        Document document = new Document();
        document.setRequest(request);
        //注意生成签名的时候设置空串显示<Signature>,不设置空串默认null，就不显示<Signature>
        //document.setSignature("");
        String noSignXml = XmlJsonUtils.convertObjectToXmlStr(document);
        String signature = CFCACipherUtils.doSignature(noSignXml);
        document.setSignature(signature);
        String doXml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("个人风险信息上报支付清算协会请求xml报文：{}", doXml);
        try {
            boolean validate = ValidateUtils.validateXMLByXSD(doXml, "pcac.ries.001");
            if (validate) {
                //String result = HttpClientUtils.sendHttpsPost("http://210.12.239.161:10001/ries_interface/httpServlet", doXml);
                String result = HttpClientUtils.sendHttpsPost(pcacConfig.getUrl(), doXml);
                log.info("个人风险信息上报支付清算协会响应xml报文：", result);
                com.cmcc.paymentclean.entity.dto.pcac.resp.Document documentResp =
                        (com.cmcc.paymentclean.entity.dto.pcac.resp.Document) com.cmcc.paymentclean.utils.XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class, result);
                String signatureResp = documentResp.getSignature();
                log.info("响应报文的签名串signature：{}", signatureResp);
                documentResp.setSignature(null);
                String noSignXmlResp = XmlJsonUtils.convertObjectToXmlStr(documentResp);
                log.info("不加签名信息的响应报文xml串：{}", noSignXmlResp);
                boolean isSign = CFCACipherUtils.verifySignature(noSignXmlResp, signatureResp);
                if (isSign) {
                    Respone respone = documentResp.getRespone();
                    RespInfo respInfo = respone.getBody().getRespInfo();
                    if ("S00000".equals(respInfo.getResultCode()) && "01".equals(respInfo.getResultStatus())) {
                        //上报成功，修改数据库状态
                        PcacPersonRiskSubmitInfo pcacPersonRiskSubmitInfo = new PcacPersonRiskSubmitInfo();
                        BeanUtils.copyProperties(respInfo, pcacPersonRiskSubmitInfo);
                        pcacPersonRiskSubmitInfo.setSubmitTime(date);
                        pcacPersonRiskSubmitInfo.setSubmitStatus("1");
                        pcacPersonRiskSubmitInfo.setMsgDetail("已上报");
                        log.info("更新数据库表时间和状态信息：{}", pcacPersonRiskSubmitInfo);
                        pcacPersonRiskSubmitInfoMapper.updateByPcacPersonRiskSubmitInfo(pcacPersonRiskSubmitInfo);

                    }

                } else {
                    log.info("------响应报文验签失败-------");
                    throw new SubmitPCACException(ResultCodeEnum.SIGNATURE_FALSE.getCode(), ResultCodeEnum.SIGNATURE_FALSE.getDesc());

                }

            } else {
                log.info("----------xsd文件校验xml格式失败-------");
                throw new SubmitPCACException(ResultCodeEnum.XSD_FILE_VALID_FALSE.getCode(), ResultCodeEnum.XSD_FILE_VALID_FALSE.getDesc());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Head getHead(String secretKey, Date date) {
        Head head = new Head();
        log.info("请求清算协会版本号：{}", pcacConfig.getVersion());
        head.setVersion(pcacConfig.getVersion());
        //报文唯一标识（8 位日期+10 顺序号）
        int random = new Random().nextInt(1000) + 1000;
        String identification = DateUtils.formatTime(date, "yyyyMMdd") + "100000" + random;
        head.setIdentification(identification);
        //收单机构收单机构机构号（字母、数字、下划线）
        head.setOrigSender(pcacConfig.getOrigSender());
        //收单机构收单机构发送系统号（字母、数字、下划线）
        head.setOrigSenderSID(pcacConfig.getOrigSenderSid());
        //协会系统编号， 特约商户信息上报和删除请求时填 SECB01，其余均为 R0001
        head.setRecSystemId("R0001");
        //交易码，见 5.1 报文分类列表（数字、字母）
        head.setTrnxCode(TrnxCodeEnum.PERSON_RISK_INFO_SUBMIT.getCode());
        String trnxTime = DateUtils.formatTime(date, "yyyyMMddHHmmss");
        head.setTrnxTime(trnxTime);
        head.setUserToken(pcacConfig.getUserToken());
        head.setSecretKey(secretKey);
        return head;
    }


}

