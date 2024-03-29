package com.cmcc.paymentclean.aop;

import com.cmcc.paymentclean.entity.PcacOptLog;
import com.cmcc.paymentclean.entity.dto.ResultBean;
import com.cmcc.paymentclean.service.impl.PcacOptLogServiceImpl;
import com.cmcc.paymentclean.wapper.RequestWrapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/** Created by ldy */
@Aspect
@Configuration
@Slf4j
public class LogRecordAspect {

  @Autowired private PcacOptLogServiceImpl pcacOptLogService;

  // 定义切点Pointcut
  @Pointcut("execution(* com.cmcc.paymentclean.controller..*.*(..))")
  public void excudeService() {}

  @Around("excudeService()")
  public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
    String separator = System.getProperty("line.separator");
    ServletRequestAttributes sra =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    assert sra != null;
    HttpServletRequest request = sra.getRequest();
    String url = request.getRequestURL().toString();
    String method = request.getMethod();
    String uri = request.getRequestURI();
    log.info(
        "请求开始, 各个参数{} url: {} method: {} uri: {} params: {}",
        separator,
        url + separator,
        method + separator,
        uri + separator,
        ((RequestWrapper) request).getBody() + separator);
    // result的值就是被拦截方法的返回值
    Object result = pjp.proceed();
    if (result instanceof ResultBean) {
      ResultBean resultBean = (ResultBean) result;
      PcacOptLog entity = new PcacOptLog();
      entity.setCreatedBy("cmcc");
      entity.setCreatedTime(new Date());
      entity.setOptContent(resultBean.getResMsg());
      pcacOptLogService.save(entity);
    }
    Gson gson = new Gson();
    log.info("请求结束，controller的返回值是 " + gson.toJson(result));
    return result;
  }
}
