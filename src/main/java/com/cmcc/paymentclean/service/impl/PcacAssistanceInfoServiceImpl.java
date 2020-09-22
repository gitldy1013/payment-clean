package com.cmcc.paymentclean.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cmcc.paymentclean.config.PcacConfig;
import com.cmcc.paymentclean.entity.PcacAssistanceInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Body;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Document;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Head;
import com.cmcc.paymentclean.entity.dto.pcac.resp.RespInfo;
import com.cmcc.paymentclean.entity.dto.pcac.resp.Respone;
import com.cmcc.paymentclean.mapper.PcacAssistanceInfoMapper;
import com.cmcc.paymentclean.service.PcacAssistanceInfoService;
import com.cmcc.paymentclean.utils.CFCACipherUtils;
import com.cmcc.paymentclean.utils.DateUtils;
import com.cmcc.paymentclean.utils.XmlJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
* <p>
* 商户信息比对协查信息表 服务实现类
* </p>
*
* @author cmcc
* @since 2020-09-08
*/
@Slf4j
@Service
public class PcacAssistanceInfoServiceImpl extends ServiceImpl<PcacAssistanceInfoMapper, PcacAssistanceInfo> implements PcacAssistanceInfoService {

    @Autowired
    private PcacAssistanceInfoMapper pcacAssistanceInfoMapper;
    @Autowired
    private PcacConfig pcacConfig;

    @Override
    public String saveAssistanceInfo(ArrayList<PcacAssistanceInfo> assistanceInfoList) {
        pcacAssistanceInfoMapper.insertBatchAssistanceInfo(assistanceInfoList);
        Body body = new Body();
        RespInfo respInfo = new RespInfo();
        //返回成功的状态码
        respInfo.setResultStatus("01");
        respInfo.setResultCode("S00000");
        body.setRespInfo(respInfo);
        Document document = new Document();
        Respone respone = new Respone();
        respone.setBody(body);
        String trnxCode = "";
        Head head = getRespHead(trnxCode);
        respone.setHead(head);
        document.setRespone(respone);
        String noSignXml = XmlJsonUtils.convertObjectToXmlStr(document);
        String signature = CFCACipherUtils.doSignature(noSignXml);
        document.setSignature(signature);
        String doXml = XmlJsonUtils.convertObjectToXmlStr(document);
        return doXml;
    }

    /**
     * 组装响应报文头的信息
     */
    private Head getRespHead(String trnxCode) {
        Date date = new Date();
        Head head = new Head();
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
        //交易码，见 5.1 报文分类列表（数字、字母）-----商户信息比对协查推送响应TrnxCode为空
        head.setTrnxCode(trnxCode);
        String trnxTime = DateUtils.formatTime(date, "yyyyMMddHHmmss");
        head.setTrnxTime(trnxTime);
        head.setSecretKey("");
        return head;
    }
}
