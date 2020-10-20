package com.cmcc.paymentclean;

import com.cmcc.paymentclean.interceptor.LogTokenInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("com.cmcc.paymentclean.mapper")
public class PaymentCleanApplication implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(PaymentCleanApplication.class, args);
  }

  @Bean
  public LogTokenInterceptor getInterceptor(){
    return new LogTokenInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(getInterceptor()).addPathPatterns("/**");
  }
}
