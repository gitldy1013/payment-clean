package com.cmcc.paymentclean.controller;

import com.cmcc.paymentclean.consts.IsBlackEnum;
import com.cmcc.paymentclean.entity.PcacRiskInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.*;
import com.cmcc.paymentclean.mapper.PcacRiskInfoMapper;
import com.cmcc.paymentclean.service.PcacRiskInfoService;
import com.cmcc.paymentclean.utils.BeanUtilsEx;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String  blackList(String xmlStr){
        log.debug("接收协会黑名单报文：{}",xmlStr);
        Document document = (Document) XmlJsonUtils.convertXmlStrToObject(Document.class, xmlStr);
        String signature = document.getSignature();
        document.setSignature(null);
        String noSignatureXml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.debug("验签使用的原数据xml：{}",noSignatureXml);
        boolean isSign = CFCACipherUtils.verifySignature(noSignatureXml, signature);
        if(isSign){
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
                PcacRiskInfo pcacRiskInfo = new PcacRiskInfo();
                BeanUtilsEx.copyProperties(pcacRiskInfo,riskInfo);
                log.debug("BeanUtilsEx.copyProperties方法封装进对象后黑名单信息：{}",pcacRiskInfo);
                pcacRiskInfo.setUpDate(upDate);
                //设置类型为黑名单
                pcacRiskInfo.setPushListType(IsBlackEnum.ISBLACKE_01.getCode());
                pcacRiskInfoList.add(pcacRiskInfo);

            }
            log.info("需要入库黑名单信息：",pcacRiskInfoList);
            pcacRiskInfoService.insertBatchPcacRiskInfo(pcacRiskInfoList);


        }
        return null;
    }
}
