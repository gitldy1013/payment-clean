package com.cmcc.paymentclean.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

@Data
@Component
@EnableCaching
@ConfigurationProperties(prefix = "pcac")
public class PcacConfig {

  private String url;

  private String version;

  private String origSender;

  private String origSenderSid;

  private String loginUrl;

  private String userToken;

  @Cacheable(value = "token")
  public String getUserToken() {
    return userToken;
  }
}
