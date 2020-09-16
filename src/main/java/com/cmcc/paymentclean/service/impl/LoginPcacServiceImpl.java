package com.cmcc.paymentclean.service.impl;

import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.entity.LoginResult;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resp.RespInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Respone;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Head;
import com.cmcc.paymentclean.entity.dto.pcac.resq.Request;
import com.cmcc.paymentclean.service.LoginPcacService;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.HttpClientUtils;
import com.cmcc.paymentclean.utils.ValidateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * <p>
 * 登录清算协会获取UserToken  实现类
 * </p>
 *
 * @author zhaolei
 * @since 2020-09-16
 */
@Service
@Slf4j
public class LoginPcacServiceImpl implements LoginPcacService {

    @Autowired
    private PcacConfig pcacConfig;

    @Override
    public LoginResult login() {
        RespInfo respInfo=null;
        Date date = new Date();
        Head head = getHead(date);
        Request request = new Request();
        request.setHead(head);
        Document document = new Document();
        document.setRequest(request);
        String noSignXml = XmlJsonUtils.convertObjectToXmlStr(document);
        String signature = CFCACipherUtils.doSignature(noSignXml);
        document.setSignature(signature);
        String xml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("登录清算协会请求参数报文s：{}",xml);
        boolean validate = ValidateUtils.validateXMLByXSD(xml, "pcac.ries.022");
        if (validate){

            String result = HttpClientUtils.sendHttpsPost("http://210.12.239.161:10001/ries_interface/loginServlet", xml);
            log.info("登录清算协会响应报文：{}",result);
            com.cmcc.paymentclean.entity.dto.pcac.resp.Document documentResp =
                    (com.cmcc.paymentclean.entity.dto.pcac.resp.Document)XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class, result);
            Respone respone = documentResp.getRespone();
            Body body = respone.getBody();
            respInfo = body.getRespInfo();
            if("S00000".equals(respInfo.getResultCode())&&"01".equals(respInfo.getResultStatus())){
                return new LoginResult(respInfo.getUserToken());
            }

        }

        return new LoginResult(respInfo.getResultCode(),respInfo.getResultStatus());

    }

    @Override
    public LoginResult logout() {
        RespInfo respInfo=null;
        Date date = new Date();
        Head head = getHead(date);
        Request request = new Request();
        request.setHead(head);
        Document document = new Document();
        document.setRequest(request);
        //加上签名空标签
        document.setSignature("");
        String noSignXml = XmlJsonUtils.convertObjectToXmlStr(document);
        String signature = CFCACipherUtils.doSignature(noSignXml);
        document.setSignature(signature);
        String doXml = XmlJsonUtils.convertObjectToXmlStr(document);
        log.info("登录清算协会请求参数报文：{}",doXml);
        boolean validate = ValidateUtils.validateXMLByXSD(doXml, "pcac.ries.022");
        if (validate){

            String result = HttpClientUtils.sendHttpsPost("http://210.12.239.161:10001/ries_interface/loginServlet", doXml);
            log.info("登录清算协会响应报文：{}",result);
            com.cmcc.paymentclean.entity.dto.pcac.resp.Document documentResp =
                    (com.cmcc.paymentclean.entity.dto.pcac.resp.Document)XmlJsonUtils.convertXmlStrToObject(com.cmcc.paymentclean.entity.dto.pcac.resp.Document.class, result);
            Respone respone = documentResp.getRespone();
            Body body = respone.getBody();
            respInfo = body.getRespInfo();
            if("S00000".equals(respInfo.getResultCode())&&"01".equals(respInfo.getResultStatus())){
                return new LoginResult(respInfo.getUserToken());
            }

        }

        return new LoginResult(respInfo.getResultCode(),respInfo.getResultStatus());

    }



    private Head getHead(Date date ){
        Head head = new Head();
        log.info("请求清算协会版本号：{}",pcacConfig.getVersion());
        head.setVersion(pcacConfig.getVersion());
        //报文唯一标识（8 位日期+10 顺序号）
        int random = new Random().nextInt(1000) + 1000;
        String identification = DateUtils.formatTime(date, "yyyyMMdd")+"100000"+random;
        head.setIdentification(identification);
        //收单机构收单机构机构号（字母、数字、下划线）
        head.setOrigSender(pcacConfig.getOrigSender());
        //收单机构收单机构发送系统号（字母、数字、下划线）
        head.setOrigSenderSID(pcacConfig.getOrigSenderSid());
        //协会系统编号， 特约商户信息上报和删除请求时填 SECB01，其余均为 R0001
        head.setRecSystemId("R0001");
        //交易码，见 5.1 报文分类列表（数字、字母）
        //用户登录需要填写LR0001
        head.setTrnxCode("LR0001");
        String trnxTime = DateUtils.formatTime(date, "yyyyMMddHHmmss");
        head.setTrnxTime(trnxTime);
        //登录不需要UserToken标签
        //head.setUserToken("");
        //head.setSecretKey(secretKey);
        //没有需要加密的数据，所以不需要生成密钥key，穿空串即可
        head.setSecretKey("");
        return head;
    }
}
