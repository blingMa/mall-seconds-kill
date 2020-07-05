package com.blingma.mallsecondskillsvr.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author shihao.ma
 * @since 2020/6/3
 */
public class TimeUtil {

    public static String getDate(PatternEnum patternEnum) {
        return LocalDate.now().format(getFormatter(patternEnum.getPattern()));
    }

    public static String getTime(PatternEnum patternEnum) {
        return LocalTime.now().format(getFormatter(patternEnum.getPattern()));
    }

    public static String getDateTime(PatternEnum patternEnum) {
        return LocalDateTime.now().format(getFormatter(patternEnum.getPattern()));
    }

    private static DateTimeFormatter getFormatter(String s) {
        return DateTimeFormatter.ofPattern(s);
    }

    public enum PatternEnum {
        PATTERN1("yyyy-MM-dd"),
        PATTERN2("yyyy年MM月dd日"),
        PATTERN3("yyyy-MM-dd HH:mm:ss"),
        PATTERN4("yyyy年MM月dd日 HH时mm分ss秒"),
        PATTERN5("HH:mm:ss"),
        PATTERN6("HH时mm分ss秒"),
        PATTERN7("yyyy-MM-dd HH:mm:ss:SS"),
        PATTERN8("yyyy年MM月dd日 HH时mm分ss秒SS毫秒");

        private String pattern;

        private PatternEnum(String pattern) {
            this.pattern = pattern;
        }

        public String getPattern() {
            return pattern;
        }
    }

}
