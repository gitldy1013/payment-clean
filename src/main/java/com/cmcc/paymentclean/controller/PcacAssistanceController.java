package com.cmcc.paymentclean.controller;

import com.cmcc.paymentclean.entity.PcacAssistanceInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac028.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac028.EntInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcac028.PcacList;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Head;
import com.cmcc.paymentclean.entity.dto.pcac.resq.gen.pcaclogin.Request;
import com.cmcc.paymentclean.service.PcacAssistanceInfoService;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaolei
 * @date 2020-09-19 11:25
 * 商户信息比对协查推送
 */
@Controller
@RequestMapping("/localRisk")
@Slf4j
public class PcacAssistanceController {

    @Autowired
    private PcacAssistanceInfoService pcacAssistanceInfoService;

    /**
     * 商户信息比对协查推送
     * 需要解密关键字：商户信息比对协查：商户代码、商户名称、法定代表人姓名
     */
    @ApiOperation(value = "商户信息比对协查推送", notes = "商户信息比对协查推送")
    @RequestMapping(value = "/assistanceInfo", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String assistanceInfo(@RequestParam(value = "xml") String xmlStr) {
        log.debug("接收协会比对协查信息报文：{}", xmlStr);
        String doXml = saveAssistanceInfo(xmlStr);

        return doXml;
    }

    private String saveAssistanceInfo(String xmlStr) {
        Document document = (Document) XmlJsonUtils.convertXmlStrToObject(Document.class, xmlStr);
        String signature = document.getSignature();
        document.setSignature(null);
        String noSignatureXml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.debug("验签使用的原数据xml：{}", noSignatureXml);
        boolean isSign = CFCACipherUtils.verifySignature(noSignatureXml, signature);
        log.info("-------商户信息比对协查推送验证签名结果为：{}", isSign);
        Request request = document.getRequest();
        Head head = request.getHead();
        String secretKey = head.getSecretKey();
        Body body = (Body) request.getBody();
        PcacList pcacList = body.getPcacList();
        String upDate = pcacList.getUpDate();
        List<EntInfo> entInfoList = pcacList.getEntInfo();
        ArrayList<PcacAssistanceInfo> assistanceInfoList = new ArrayList<>();
        for (EntInfo entInfo:entInfoList){
            log.debug("协会返回比对协查信息：{}", entInfo);
            PcacAssistanceInfo pcacAssistanceInfo = new PcacAssistanceInfo();
            //对关键字进行解密
            pcacAssistanceInfo.setCusCode(CFCACipherUtils.decrypt(secretKey,entInfo.getCusCode()));
            pcacAssistanceInfo.setRegName(CFCACipherUtils.decrypt(secretKey,entInfo.getRegName()));
            pcacAssistanceInfo.setLegDocName(CFCACipherUtils.decrypt(secretKey,entInfo.getLegDocName()));
            pcacAssistanceInfo.setDifCusCode(CFCACipherUtils.decrypt(secretKey,entInfo.getDifferents().getCusCode()));
            pcacAssistanceInfo.setDifRegName(CFCACipherUtils.decrypt(secretKey,entInfo.getDifferents().getRegName()));
            pcacAssistanceInfo.setDifLegDocName(CFCACipherUtils.decrypt(secretKey,entInfo.getDifferents().getLegDocName()));
            pcacAssistanceInfo.setUpDate(upDate);
            assistanceInfoList.add(pcacAssistanceInfo);
        }

        String doXml =  pcacAssistanceInfoService.saveAssistanceInfo(assistanceInfoList);
        return doXml;
    }
}
