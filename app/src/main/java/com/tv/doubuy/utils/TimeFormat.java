package com.tv.doubuy.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeFormat {

    /**
     * 时间戳转换
     *
     * @param timeStamp
     * @return
     */
    public static String timeStampConversion(long timeStamp) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date(timeStamp * 1000));
        return date;
    }
    /**
     * 时间戳转换
     *
     * @param timeStamp
     * @return
     */
    public static String timeStampConversion3(long timeStamp) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                .format(new Date(timeStamp * 1000));
        return date;
    }

    /**
     * 时间戳转换
     *
     * @param timeStamp
     * @return
     */
    public static String timeStampConversion2(long timeStamp) {
        String date = new SimpleDateFormat("yyyy-MM-dd")
                .format(new Date(timeStamp * 1000));
        return date;
    }

    /**
     * 时间戳转换
     *
     * @param data
     * @return
     */
    public static String getTimeOrDetil(long data) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String date = sdf.format(new Date(data * 1000));
        return date;
    }


    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    public static String getCurrentTime1(long data) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(new Date(data * 1000));
        return date;
    }

    public static Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 時間是否過期
     *
     * @param oldTime
     * @param hour    幾個小時
     * @return
     */
    public static boolean isOverdueTime(String oldTime, int hour) {
        boolean isOverdue = false;
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = getCurrentTime();
        try {
            Date begin = dfs.parse(oldTime);
            Date end = dfs.parse(currentTime);
            long between = (end.getTime() - begin.getTime()) / 1000;//除以1000是为了转换成秒
            long hour1 = between % (24 * 3600) / 3600;
            if (hour1 >= hour) {
                isOverdue = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOverdue;
    }

    /**
     * 时间差
     *
     * @param date
     */
    public static long[] timeDifference(long date) {
        long[] times = null;
        String timeStr = String.valueOf(date);
        if (timeStr != null && !"".equals(timeStr) && date > 0){
            times = new long[4];
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDate = TimeFormat.getCurrentTime();
            String nowTime = timeStampConversion(date);
            long day = 0, hour = 0, min = 0, s = 0;
            try {
                Date currentTime = df.parse(currentDate);
                Date endTime = df.parse(nowTime);
                long l = endTime.getTime() - currentTime.getTime();
                day = l / (24 * 60 * 60 * 1000);
                hour = (l / (60 * 60 * 1000) - day * 24);
                min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
                s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            } catch (Exception e) {
            }
            times[0] = day;
            times[1] = hour;
            times[2] = min;
            times[3] = s;
        }
        return times;
    }

    /**
     * 判斷時間是否過期
     *
     * @param expireTime
     * @return
     */
    public static boolean isOverdueTime(String expireTime) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = getCurrentTime();
        Calendar et = Calendar.getInstance();
        Calendar ct = Calendar.getInstance();
        try {
            et.setTime(df.parse(expireTime));
            ct.setTime(df.parse(currentTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int result = et.compareTo(ct);
        if (result < 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 转换为时分秒
     *
     * @param countdown
     * @return
     */
    public static String changeDate(long countdown) {
        long day = countdown / (24 * 60 * 60 * 1000);
        long hour = (countdown / (60 * 60 * 1000) - day * 24);
        long min = ((countdown / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (countdown / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String t_hour, t_min, t_s;
        if (hour < 10) {
            t_hour = "0" + hour;
        } else {
            t_hour = "" + hour;
        }
        if (min < 10) {
            t_min = "0" + min;
        } else {
            t_min = "" + min;
        }
        if (s < 10) {
            t_s = "0" + s;
        } else {
            t_s = "" + s;
        }
        return "剩" + day + "天" + t_hour + ":" + t_min + ":" + t_s;
    }

    /**
     * 转换为分秒
     *
     * @param countdown
     * @return
     */
    public static String orderChangeDate(long countdown) {
        long day = countdown / (24 * 60 * 60 * 1000);
        long hour = (countdown / (60 * 60 * 1000) - day * 24);
        long min = ((countdown / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (countdown / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String t_hour, t_min, t_s;
        if (hour < 10) {
            t_hour = "0" + hour;
        } else {
            t_hour = "" + hour;
        }
        if (min < 10) {
            t_min = "0" + min;
        } else {
            t_min = "" + min;
        }
        if (s < 10) {
            t_s = "0" + s;
        } else {
            t_s = "" + s;
        }
        return t_min + ":" + t_s;
    }

}
