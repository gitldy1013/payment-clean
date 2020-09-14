package com.cmcc.paymentclean.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

/*
 * @author ldy
 * @Description DateUtils is used to Java8中的时间类
 */
public class DateUtils {

    public static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_TIME_PCAC = "yyyyMMddHHmmss";
    public static final String FORMAT_DATE_PCAC = "yyyyMMdd";

    //获取指定时间的指定格式
    public static String formatTime(Date date, String pattern) {
        if (pattern == null) {
            pattern = FORMAT_TIME;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

}


