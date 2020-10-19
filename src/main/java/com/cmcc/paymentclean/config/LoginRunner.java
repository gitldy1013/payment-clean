package com.cmcc.paymentclean.config;

import com.cmcc.paymentclean.service.LoginPcacService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/** 这里通过设定value的值来指定执行顺序 */
@Component
@Order(value = 1)
@Slf4j
@EnableCaching
public class LoginRunner implements ApplicationRunner {

  @Autowired private LoginPcacService service;

  @Override
  public void run(ApplicationArguments var1) {
    Runnable runnable =
        new Runnable() {
          @Override
          public void run() {
              String token = getToken();
            log.info("用户token：{}", token);
          }

          @Caching(
              put = {
                @CachePut(value = "token"),
              })
          public String getToken() {
            service.logout();
            return service.login().getUserToken();
          }
        };
    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
    ses.scheduleAtFixedRate(runnable, 0, 6, TimeUnit.HOURS);
  }
}
