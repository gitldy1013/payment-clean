package com.cmcc.paymentclean.interceptor;

import com.cmcc.paymentclean.wapper.RequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("authSecurityInterceptor")
@Slf4j
public class AuthSecurityInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
      throws Exception {
    try {
      RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);
      requestWrapper.getBody();
      return true;
    } catch (Exception e) {
      log.error("获取请求参数异常：", e);
    }
    return false;
  }

  @Override
  public void postHandle(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Object o,
      ModelAndView modelAndView)
      throws Exception {}

  @Override
  public void afterCompletion(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Object o,
      Exception e)
      throws Exception {}
}
