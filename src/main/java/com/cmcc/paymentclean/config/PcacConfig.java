package com.cmcc.paymentclean.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pcac")
public class PcacConfig {

    private String url;

    private String version;

    private String origSender;

    private String origSenderSid;

    private  String loginUrl;

    private  String userToken;


}

