package com.cmcc.paymentclean.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @author ldy
 * @Description DateUtils
 */
@Slf4j
public class DateUtils {

  public static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
  public static final String FORMAT_DATE = "yyyy-MM-dd";
  public static final String FORMAT_TIME_PCAC = "yyyyMMddHHmmss";
  public static final String FORMAT_DATE_PCAC = "yyyyMMdd";

  // 获取指定时间的指定格式
  public static String formatTime(Date date, String pattern) {
    if (pattern == null) {
      pattern = FORMAT_TIME;
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    return simpleDateFormat.format(date);
  }

  public static Date stringToDate(String str, String pattern) {
    if (pattern == null) {
      pattern = FORMAT_TIME;
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    Date date = null;
    try {
      date = simpleDateFormat.parse(str);
    } catch (Exception e) {
      log.error("异常:" + e);
    }
    return date;
  }

  public static String curDateString() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_TIME_PCAC);
    return simpleDateFormat.format(new Date());
  }
}
