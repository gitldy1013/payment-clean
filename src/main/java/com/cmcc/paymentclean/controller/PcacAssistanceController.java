package com.cmcc.paymentclean.controller;

import com.cmcc.paymentclean.service.PcacAssistanceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaolei
 * @date 2020-09-19 11:25 商户信息比对协查推送
 */
@Controller
@RequestMapping("/localRisk")
@Slf4j
public class PcacAssistanceController {

  @Autowired private PcacAssistanceInfoService pcacAssistanceInfoService;

  /** 商户信息比对协查推送 需要解密关键字：商户信息比对协查：商户代码、商户名称、法定代表人姓名 */
  /*  @ApiOperation(value = "商户信息比对协查推送", notes = "商户信息比对协查推送")
  @RequestMapping(value = "/assistanceInfo", method = {RequestMethod.POST, RequestMethod.GET})
  @ResponseBody
  public String assistanceInfo(@RequestParam(value = "xml") String xmlStr) {
      log.info("接收协会比对协查信息请求报文：{}", xmlStr);
      String doXml = saveAssistanceInfo(xmlStr);
      log.info("接收协会比对协查信息响应报文：{}", doXml);
      return doXml;
  }

  private String saveAssistanceInfo(String xmlStr) {
      Document028Wapper document = (Document028Wapper) XmlJsonUtils.convertXmlStrToObject(xmlStr, Document028Wapper.class);
      String signature = document.getSignature();
      document.setSignature(null);
      String noSignatureXml = XmlJsonUtils.convertObjectToXmlStr(document);
      log.debug("验签使用的原数据xml：{}", noSignatureXml);
      boolean isSign = CFCACipherUtils.verifySignature(noSignatureXml, signature);
      log.info("-------商户信息比对协查推送验证签名结果为：{}", isSign);
      Request028Wapper request = document.getRequest();
      Head head = request.getHead();
      String secretKey = head.getSecretKey();
      //获取报文唯一表示，响应清算协会时需使用
      String identification = head.getIdentification();
      log.info("报文唯一表示：{}",identification);
      Body body = request.getBody();
      PcacList pcacList = body.getPcacList();
      String upDate = pcacList.getUpDate();
      List<EntInfo> entInfoList = pcacList.getEntInfo();
      ArrayList<PcacAssistanceInfo> pcacAssistanceInfoList = new ArrayList<>();
      for (EntInfo entInfo : entInfoList) {
          log.info("协会返回比对协查信息：{}", entInfo);
          List<Differents> differents = entInfo.getDifferents();
          if (differents.size() > 0) {

              for (Differents different : differents) {
                  PcacAssistanceInfo  pcacAssistanceInfo = new PcacAssistanceInfo();
                  //对关键字进行解密
                  pcacAssistanceInfo.setCusCode(CFCACipherUtils.decrypt(secretKey, entInfo.getCusCode()));
                  pcacAssistanceInfo.setRegName(CFCACipherUtils.decrypt(secretKey, entInfo.getRegName()));
                  pcacAssistanceInfo.setLegDocName(CFCACipherUtils.decrypt(secretKey, entInfo.getLegDocName()));
                  pcacAssistanceInfo.setDifCusCode(CFCACipherUtils.decrypt(secretKey, different.getCusCode()));
                  pcacAssistanceInfo.setDifRegName(CFCACipherUtils.decrypt(secretKey, different.getRegName()));
                  pcacAssistanceInfo.setDifLegDocName(CFCACipherUtils.decrypt(secretKey, different.getLegDocName()));
                  pcacAssistanceInfo.setUpDate(upDate);
                  pcacAssistanceInfoList.add(pcacAssistanceInfo);
              }
          }


      }

      return pcacAssistanceInfoService.saveAssistanceInfo(pcacAssistanceInfoList,identification);
  }*/

}
