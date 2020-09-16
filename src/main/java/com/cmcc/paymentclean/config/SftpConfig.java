package com.cmcc.paymentclean.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sftp")
public class SftpConfig {
    private String host;
    private String port;
    private String username;
    private String password;
    private String modDir;
    private String remotePathUpload;
    private String remotePathDownload;
    private String queryPcacMerchantRiskInfoFileNamePrefix;
    private String pcacRiskInfoFileNamePrefix;
    private String businessInfoFileNamePrefix;
}
