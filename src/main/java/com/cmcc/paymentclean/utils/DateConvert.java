package com.cmcc.paymentclean.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.cmcc.paymentclean.utils.DateUtils.FORMAT_DATE;
import static com.cmcc.paymentclean.utils.DateUtils.FORMAT_DATE_PCAC;
import static com.cmcc.paymentclean.utils.DateUtils.FORMAT_TIME;

/** 扩展BeanUtils.copyProperties支持data类型 */
@Slf4j
public class DateConvert implements Converter {
  @Override
  public Object convert(Class class1, Object value) {
    if (value instanceof Date) {
      return DateUtils.formatTime((Date) value, FORMAT_DATE);
    }
    if (class1.getTypeName().equals(Date.class.getTypeName())) {
      try {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_TIME);
        return dateFormat.parse(value.toString());
      } catch (ParseException e) {
        try {
          SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
          return dateFormat.parse(value.toString());
        } catch (ParseException ex) {
          try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE_PCAC);
            return dateFormat.parse(value.toString());
          } catch (ParseException exc) {
            log.info("解析String转换Date类型出错。");
            return null;
          }
        }
      }
    }
    /*if (value instanceof Long) {
        return new Date((Long) value);
    }
    if (value instanceof String) {
        String dateStr = (String) value;
        Date endTime = null;
        try {
            String regexp1 = "([0-9]{4})-([0-1][0-9])-([0-3][0-9])T([0-2][0-9]):([0-6][0-9]):([0-6][0-9])";
            String regexp2 = "([0-9]{4})-([0-1][0-9])-([0-3][0-9])(/t)([0-2][0-9]):([0-6][0-9]):([0-6][0-9])";
            String regexp3 = "([0-9]{4})-([0-1][0-9])-([0-3][0-9])";
            if (dateStr.matches(regexp1)) {
                dateStr = dateStr.split("T")[0] + " " + dateStr.split("T")[1];
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                endTime = sdf.parse(dateStr);
                return endTime;
            } else if (dateStr.matches(regexp2)) {
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                endTime = sdf.parse(dateStr);
                return endTime;
            } else if (dateStr.matches(regexp3)) {
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                endTime = sdf.parse(dateStr);
                return endTime;
            } else {
                return dateStr;
            }
        } catch (ParseException e) {
            log.error("异常:"+e);
        }
    }*/
    return value;
  }
}
