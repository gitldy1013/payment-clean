package com.cmcc.paymentclean.filter;

import com.cmcc.paymentclean.wapper.RequestWrapper;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "channelFilter")
public class ChannelFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    ServletRequest requestWrapper = null;
    if (servletRequest instanceof HttpServletRequest) {
      requestWrapper = new RequestWrapper((HttpServletRequest) servletRequest);
    }
    if (requestWrapper == null) {
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      filterChain.doFilter(requestWrapper, servletResponse);
    }
  }

  @Override
  public void destroy() {}
}
