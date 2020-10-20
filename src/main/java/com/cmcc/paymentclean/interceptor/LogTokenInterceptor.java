package com.cmcc.paymentclean.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author zhaolei
 * @date 2020-10-20 11:20
 */
public class LogTokenInterceptor implements HandlerInterceptor {
    private static final String TRACE_ID = "TRACE_ID";
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("进入拦截器内部方法-----");
        String traceId = UUID.randomUUID().toString().trim().replaceAll("-", "");
        System.out.println("进程号是-------"+traceId);
        if (StringUtils.isEmpty(MDC.get(TRACE_ID))){

            MDC.put(TRACE_ID,traceId);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        MDC.remove(TRACE_ID);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
