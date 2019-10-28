package cn.com.xgit.parts.rm.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
public class DateUtil {

    // 默认格式
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";


    /**
     * 时间转换<br>
     * 将时间格式转换成字符串，yyyy-MM-dd
     *
     * @param date Date
     * @return String
     */
    public static String formatDate(Date date) {
        if (null == date) {
            return "";
        }
        return DateFormatUtils.format(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 时间转换<br>
     * 将时间格式转换成字符串，yyyy-MM-dd HH:mm:ss
     *
     * @param date Date
     * @return String
     */
    public static String formatDateTime(Date date) {
        if (null == date) {
            return "";
        }
        return DateFormatUtils.format(date, DEFAULT_DATE_TIME_FORMAT);
    }

    /**
     * 解析，默认格式 yyyy-MM-dd HH:mm:ss
     *
     * @param date 字符串
     * @return 日期
     */
    public static Date parse(String date) {
        DateTimeFormatter format = DateTimeFormat.forPattern(DEFAULT_DATE_TIME_FORMAT);
        return DateTime.parse(date, format).toDate();
    }


    /**
     * 尝试匹配转换成Date
     *
     * @param date 字符串
     * @return 日期
     */
    public static Date tryParse(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        if (date.contains("/")) {
            date = date.replaceAll("/", "-");
        }
        try {
            DateTimeFormatter format = DateTimeFormat.forPattern(DEFAULT_DATE_TIME_FORMAT);
            if (date.length() == DEFAULT_DATE_TIME_FORMAT.length()) {
                return DateTime.parse(date, format).toDate();
            }
            if (date.length() == DEFAULT_DATE_FORMAT.length()) {
                format = DateTimeFormat.forPattern(DEFAULT_DATE_FORMAT);
                return DateTime.parse(date, format).toDate();
            }
            String datePattern = "yyyy-MM-dd HH:mm";
            if (date.length() == datePattern.length()) {
                format = DateTimeFormat.forPattern(datePattern);
                return DateTime.parse(date, format).toDate();
            }
            datePattern = "yyyy-MM-dd HH";
            if (date.length() == datePattern.length()) {
                format = DateTimeFormat.forPattern(datePattern);
                return DateTime.parse(date, format).toDate();
            }
            return DateTime.parse(date, format).toDate();
        } catch (Exception e) {
            log.warn("tryParse fail .date:{}", date, e);
            return null;
        }
    }

    public static String getLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        String lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }

    public static Date getYestday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static long getCurrentHourSecond() {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);

        now.set(year, month, day, hour, 0, 0);
        return now.getTimeInMillis() / 1000;
    }

    public static long getCurrentDayMinute() {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);

        now.set(year, month, day, 0, 0, 0);
        return now.getTimeInMillis() / 1000 / 60;
    }

    public static long getCurrentTimes() {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        return now.getTimeInMillis();
    }

    public static long getDayTimes(Date date) {
        return date.getTime();
    }

    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0) {
            return "00:00";
        }
        minute = time / 60;
        if (minute < 60) {
            second = time % 60;
            timeStr = unitFormat(minute) + ":" + unitFormat(second);
            return timeStr;
        }
        hour = minute / 60;
        if (hour > 99) {
            return "99:59:59";
        }
        minute = minute % 60;
        second = time - hour * 3600 - minute * 60;
        timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10) {
            retStr = "0" + Integer.toString(i);
        } else {
            retStr = "" + i;
        }
        return retStr;
    }

    /**
     * Date转String <br>
     * 根据format格式转换时间为字符串
     *
     * @param date   时刻
     * @param format 转换模板
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String dateToString(Date date, String format) {
        if (date == null) {
            date = new Date();
        }

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String retTime = formatter.format(date);

        return retTime;
    }

    /**
     * 获取当前时间 <功能详细描述>
     *
     * @param format 时间格式
     * @return String format格式
     * @see [类、类#方法、类#成员]
     */
    public static String getCurrentTime(String format) {
        return dateToString(new Date(), format);
    }

    /**
     * 获取当前日期和时间
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 获取某天零点的函数
     *
     * @param date
     * @return
     */
    public static Date getStartTimeOfDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 0); // 24小时制
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
//        day.set(Calendar.MILLISECOND, 0);
        return day.getTime();
    }

    /**
     * 获取某天末点的函数
     *
     * @param date
     * @return
     */
    public static Date getEndTimeOfDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 23); // 24小时制
        day.set(Calendar.MINUTE, 59);
        day.set(Calendar.SECOND, 59);
//        day.set(Calendar.MILLISECOND, 999);
        return day.getTime();
    }

    /**
     * 获取某天所在周第一天
     *
     * @return
     */
    public static Date getWeekStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取某天所在周最后一天
     *
     * @return
     */
    public static Date getWeekEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 获取某天所在月第一天
     *
     * @return
     */
    public static Date getMonthStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取某天所在月最后一天
     *
     * @return
     */
    public static Date getMonthEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 根据天数修改日期
     *
     * @param date
     * @param offset
     * @return
     */
    public static Date adjustDay(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, offset);
        Date newDate = calendar.getTime();
        return newDate;
    }

    /**
     * 根据秒数增加日期
     *
     * @param date
     * @param sec
     * @return
     */
    public static Date addBySec(Date date, int sec) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, sec);
        return calendar.getTime();
    }

    /**
     * 根据分钟修改日期（+-数量加减）
     *
     * @param date
     * @param sec
     * @return
     */
    public static Date changeByMin(Date date, int sec) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, sec);
        return calendar.getTime();
    }

    public static Date stringToDate(String source, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(source);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 获取当前时间毫秒数
     *
     * @return
     */
    public static Long getCurrentMillisecond() {
        return getCurrentDate().getTime();
    }

    /**
     * 固定格式date1在date2之前
     *
     * @param date1
     * @param date2
     * @param format
     * @return
     */
    public static boolean dateBeforeByFomat(Date date1, Date date2, String format) {
        String str1 = dateToString(date1, format);
        String str2 = dateToString(date2, format);
        Date newDate1 = stringToDate(str1, format);
        Date newDate2 = stringToDate(str2, format);
        if (newDate1.before(newDate2)) {
            return true;
        }
        return false;
    }

    /**
     * 固定格式date1在date2之后
     *
     * @param date1
     * @param date2
     * @param format
     * @return
     */
    public static boolean dateAfterByFomat(Date date1, Date date2, String format) {
        String str1 = dateToString(date1, format);
        String str2 = dateToString(date2, format);
        Date newDate1 = stringToDate(str1, format);
        Date newDate2 = stringToDate(str2, format);
        if (newDate1.after(newDate2)) {
            return true;
        }
        return false;
    }

    /**
     * 获取某段时间内的所有日期
     *
     * @return
     */
    public static List<Date> findDates(Date beginDate, Date endDate, int calenderType) {
        List<Date> dateList = new ArrayList<>();
        dateList.add(beginDate);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(beginDate);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(endDate);
        // 测试此日期是否在指定日期之后
        while (calEnd.after(calBegin)) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(calenderType, 1);
            if (calEnd.after(calBegin)) {
                dateList.add(calBegin.getTime());
            }
        }
        return dateList;
    }

    public static Date getYesterdayBegin() {
        return new DateTime(DateTime.now().toString(DEFAULT_DATE_FORMAT)).minusDays(1).toDate();
    }

    public static Date getTodayBegin() {
        return new DateTime(DateTime.now().toString(DEFAULT_DATE_FORMAT)).toDate();
    }

    public static Date getDateNDaysBefore(Integer inDays) {
        if (null == inDays) {
            inDays = 0;
        }
        return new DateTime(DateTime.now().toString(DEFAULT_DATE_FORMAT)).minusDays(inDays).toDate();
    }

    public static Date getMonthMinus(int i) {
        return new DateTime(DateTime.now().toString(DEFAULT_DATE_FORMAT)).minusMonths(i).toDate();
    }
}
