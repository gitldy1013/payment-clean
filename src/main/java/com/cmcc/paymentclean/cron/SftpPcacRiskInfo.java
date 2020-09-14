package com.cmcc.paymentclean.cron;

import com.cmcc.paymentclean.consts.IsBlackEnum;
import com.cmcc.paymentclean.entity.PcacRiskInfo;
import com.cmcc.paymentclean.service.PcacRiskInfoService;
import com.cmcc.paymentclean.utils.SFTPUtils;
import com.cmcc.paymentclean.utils.TxtFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lumma on 2020/9/14.
 */
@Slf4j
@Component
public class SftpPcacRiskInfo {

    @Autowired
    private PcacRiskInfoService pcacRiskInfoService;

    @Value("${sftp.modDir}")
    private String modDir;

    @Value("${sftp.remotePathUpload}")
    private String remotePathUpload;

    public void run()  {
        Date startDate = new Date();
        log.info("SftpPcacRiskInfoJob run start.....{}", startDate);
        //1.先取出加黑的所有名单数据
        List<PcacRiskInfo> pcacRiskInfos = pcacRiskInfoService.listByIsBlack(IsBlackEnum.ISBLACKE_01.getCode());
        if(CollectionUtils.isEmpty(pcacRiskInfos)){
            return;
        }
        List<String> fileList = new ArrayList<>();
        fileList.add("推送日期|商户名称|商户简称|法人证件类型|法人证件号码|法定代表人姓名|法定代表人类型|法定代表人（负责人） 证件号码|风险信息等级|" +
                "风险类型|有效期|有效性|商户类型|风险事件发生地域|银行结算账户|网址|商户注册号");
        for(PcacRiskInfo pcacRiskInfo:pcacRiskInfos){
            String str = "";
            str = setStr(str,pcacRiskInfo.getUpDate(),true);
            try {
                str = setStr(str, new String(pcacRiskInfo.getRegName(),"UTF-8"), true);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            str = setStr(str,pcacRiskInfo.getCusName(),true);
            str = setStr(str,pcacRiskInfo.getDocType(),true);
            str = setStr(str,pcacRiskInfo.getDocCode(),true);
            str =  setStr(str,pcacRiskInfo.getLegDocName(),true);
            str = setStr(str,pcacRiskInfo.getLegDocCode(),true);
            str = setStr(str,pcacRiskInfo.getLevel(),true);
            str = setStr(str,pcacRiskInfo.getRiskType(),true);
            str = setStr(str,pcacRiskInfo.getValidDate(),true);
            str = setStr(str,pcacRiskInfo.getValidStatus(),true);
            str = setStr(str,pcacRiskInfo.getCusType(),true);
            str = setStr(str,pcacRiskInfo.getOccurarea(),true);
            str = setStr(str,pcacRiskInfo.getBankNo(),true);
            str = setStr(str,pcacRiskInfo.getUrl(),true);
            str = setStr(str,pcacRiskInfo.getRegisteredCode(),false);
            fileList.add(str);
        }

        //文件名
        String fileName = "Black_"+ System.currentTimeMillis() + ".txt";

        //写本地文件
        try {
            TxtFileUtil.writeFileContext(fileList,modDir+fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //上传文件
        SFTPUtils sftpUtils = new SFTPUtils();
        sftpUtils.connect();
        sftpUtils.uploadFile(remotePathUpload,fileName,modDir,fileName);
        sftpUtils.disconnect();

        Date endDate = new Date();
        log.info("SftpPcacRiskInfoJob run end.....{}", endDate);
    }

    private String setStr(String str,String msg,boolean flag){
        if(flag){
            str +=msg+"|";
        }
        else{
            str+=msg;
        }
        return str;
    }
}
