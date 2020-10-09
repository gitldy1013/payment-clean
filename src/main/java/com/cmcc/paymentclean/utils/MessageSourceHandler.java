package com.cmcc.paymentclean.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * 国际化工具类.系统需根据要展示的编码做拦截，设置Locale<br>
 * 设置Locale的方法：
 *
 * @author z
 * @see:org.springframework.context.i18n.LocaleContextHolder.setLocale(Locale locale)
 *     <p>比如设置为英文： LocaleContextHolder.setLocale(Locale.ENGLISH);
 * @date 2019/3/20
 */
@Component
public class MessageSourceHandler {

  @Autowired private MessageSource messageSource;

  /**
   * 根据key获取文字描述
   *
   * @param messageKey
   * @return
   */
  public String getMessage(String messageKey) {

    String message =
        messageSource.getMessage(messageKey, null, messageKey, LocaleContextHolder.getLocale());
    return message;
  }

  /**
   * 根据key获取文字描述
   *
   * @param messageKey
   * @return
   */
  public String getMessage(String messageKey, Object[] args) {
    String message = messageSource.getMessage(messageKey, args, LocaleContextHolder.getLocale());
    return message;
  }
}
