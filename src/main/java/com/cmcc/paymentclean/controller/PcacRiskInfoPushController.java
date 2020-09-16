package com.cmcc.paymentclean.controller;

import com.cmcc.paymentclean.consts.IsBlackEnum;
import com.cmcc.paymentclean.consts.LegDocTypeEnum;
import com.cmcc.paymentclean.entity.PcacRiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Head;
import com.cmcc.paymentclean.entity.dto.pcac.resq.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Request;
import com.cmcc.paymentclean.entity.dto.pcac.resq.RiskInfo;
import com.cmcc.paymentclean.service.PcacRiskInfoService;
import com.cmcc.paymentclean.utils.BeanUtilsEx;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.InnerCipherUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaolei
 * @date 2020-09-15 12:38
 */
@Controller
@RequestMapping("/pcacRiskInfo")
@Slf4j
public class PcacRiskInfoPushController {

    @Autowired
    private PcacRiskInfoService pcacRiskInfoService;


    /**
     * 协会推送黑名单信息
     * 黑名单推送关键字：商户名称、商户简称、 法人证件号码、法定代表人姓名、法定代表人证件号码
     *
     *
     * */
    @RequestMapping(value = "/blackList",method = RequestMethod.POST)
    @ResponseBody
    public String  blackList(@RequestParam(value = "xml") String xmlStr){
        log.debug("接收协会黑名单报文：{}",xmlStr);
        String doXml =null;
        Document document = (Document) XmlJsonUtils.convertXmlStrToObject(Document.class, xmlStr);
        String signature = document.getSignature();
        document.setSignature(null);
        String noSignatureXml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.debug("验签使用的原数据xml：{}",noSignatureXml);
        boolean isSign = CFCACipherUtils.verifySignature(noSignatureXml, signature);
        log.info("-------黑名单信息推送验证签名结果为：{}",isSign);
            Request request = document.getRequest();
            Head head = request.getHead();
            String secretKey = head.getSecretKey();
            Body body = request.getBody();
            PcacList pcacList = body.getPcacList();
            String upDate = pcacList.getUpDate();
            List<RiskInfo> riskInfoList = pcacList.getRiskInfo();
            ArrayList<PcacRiskInfo> pcacRiskInfoList = new ArrayList<>();
            for(RiskInfo riskInfo:riskInfoList){
                log.debug("协会返回黑名单信息：{}",riskInfo);
                //对关键字进行解密，证件号码和银行卡号加密
                //商户简称
                String decryptCusName = CFCACipherUtils.decrypt(secretKey, riskInfo.getCusName());
                riskInfo.setCusName(decryptCusName);
                //商户名称
                String decryptRegName = CFCACipherUtils.decrypt(secretKey, riskInfo.getRegName());
                riskInfo.setRegName(decryptRegName);
                //法人证件号码
                String decryptDocCode = CFCACipherUtils.decrypt(secretKey, riskInfo.getDocCode());
                riskInfo.setCusCode(decryptDocCode);
                //法定代表人姓名
                String decryptLegDocName = CFCACipherUtils.decrypt(secretKey, riskInfo.getLegDocName());
                riskInfo.setLegDocName(decryptLegDocName);
                //法定代表人证件号码
                String decryptLegDocCode = CFCACipherUtils.decrypt(secretKey, riskInfo.getLegDocCode());
                String encryptLegDocCode =null;
                //判断证件类型是身份证就进行内部加密
                if(!StringUtils.isEmpty(riskInfo.getLegDocCode())&&LegDocTypeEnum.LEGDOCTYPEENUM_01.getCode().equals(riskInfo.getLegDocCode())){
                    encryptLegDocCode = InnerCipherUtils.encrypt(decryptLegDocCode);
                }

                riskInfo.setLegDocCode(encryptLegDocCode);
                String encryptBankNo = InnerCipherUtils.encrypt(riskInfo.getBankNo());
                riskInfo.setBankNo(encryptBankNo);
                PcacRiskInfo pcacRiskInfo = new PcacRiskInfo();
                BeanUtilsEx.copyProperties(pcacRiskInfo,riskInfo);
                log.debug("BeanUtilsEx.copyProperties方法封装进对象后黑名单信息：{}",pcacRiskInfo);
                pcacRiskInfo.setUpDate(upDate);
                //设置类型为黑名单
                pcacRiskInfo.setPushListType(IsBlackEnum.ISBLACKE_01.getCode());
                pcacRiskInfoList.add(pcacRiskInfo);


            log.debug("需要入库黑名单信息：",pcacRiskInfoList);
             doXml = pcacRiskInfoService.insertBatchPcacRiskInfo(pcacRiskInfoList);


        }
        return doXml;
    }
}
