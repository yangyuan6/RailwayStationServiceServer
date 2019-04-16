package com.imudges.web.railwaystationservice.util;

import com.imudges.web.railwaystationservice.bean.DistanceTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yangy on 2018/1/15.
 */
public class DateUtil {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm");

    public static String formatDate(Date date) throws ParseException {
        return sdf.format(date);
    }

    public static Date parse(String strDate) throws ParseException {

        return sdf.parse(strDate);
    }

    public static int getTimeDistance(Date beginDate, Date endDate) {
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(beginDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        long beginTime = beginCalendar.getTime().getTime();
        long endTime = endCalendar.getTime().getTime();
        int betweenDays = (int) ((endTime - beginTime) / (1000 * 60 * 60 * 24));//先算出两时间的毫秒数之差大于一天的天数

        endCalendar.add(Calendar.DAY_OF_MONTH, -betweenDays);//使endCalendar减去这些天数，将问题转换为两时间的毫秒数之差不足一天的情况
        endCalendar.add(Calendar.DAY_OF_MONTH, -1);//再使endCalendar减去1天
        if (beginCalendar.get(Calendar.DAY_OF_MONTH) == endCalendar.get(Calendar.DAY_OF_MONTH))//比较两日期的DAY_OF_MONTH是否相等
            return betweenDays + 1; //相等说明确实跨天了
        else
            return betweenDays + 0; //不相等说明确实未跨天
    }

    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        if(day<0||hour<0||min<0){
            return "overdue";
        }
        if (day > 0) {
            return day + "天" + hour + "个小时" + min + "分钟";

        } else {
            return hour + "个小时" + min + "分钟";
        }

       /* if (day > 0) {
            return day + "天" + hour + "个小时" + min + "分钟";

        } else if (hour > 0) {
            return hour + "个小时" + min + "分钟";
        }else {
            return min+"分钟";
        }*/
        // return day + "天" + hour + "小时" + min + "分钟";
    }

    public static DistanceTime getDatePoorMo(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        DistanceTime distanceTime = new DistanceTime();
        if (day < 0 || hour < 0 || min < 0) {
            distanceTime.setFlag(false);
            return distanceTime;
        }
        if (day > 0) {
            String str = day + "天" + hour + "个小时" + min + "分钟";
            String str1 = hour + "ᠴᠠᠭ" + min + " ᠮᠢᠨᠦ᠋ᠲ ᠪᠠᠢᠨ᠎ᠠ ᠃";
            distanceTime.setDistanceTime(str1);
            distanceTime.setGetDistanceTimeCn(str);
            return distanceTime;
        }
        String str = hour + "个小时" + min + "分钟";
        String str1 = hour + "ᠴᠠᠭ" + min + " ᠮᠢᠨᠦ᠋ᠲ ᠪᠠᠢᠨ᠎ᠠ ᠃";
        distanceTime.setDistanceTime(str1);
        distanceTime.setGetDistanceTimeCn(str);
        return distanceTime;
        /*if(day<0||hour<0||min<0){
            return "overdue";
        }
        if(day==0){
            return hour + "ᠴᠠᠭ" + min + " ᠮᠢᠨᠦ᠋ᠲ ᠪᠠᠢᠨ᠎ᠠ ᠃";
        }
        return hour + "ᠴᠠᠭ" + min + " ᠮᠢᠨᠦ᠋ᠲ ᠪᠠᠢᠨ᠎ᠠ ᠃";*/
    }

    public static DistanceTime getDatePoorEn(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        DistanceTime distanceTime = new DistanceTime();
        if (day < 0 || hour < 0 || min < 0) {
            distanceTime.setFlag(false);
            return distanceTime;
        }
        if (day > 0) {
            String str = day + "天" + hour + "个小时" + min + "分钟";
            String str1 = day + "天" + hour + "hours" + min + " minutes᠃";
            distanceTime.setDistanceTime(str1);
            distanceTime.setGetDistanceTimeCn(str);
            return distanceTime;
        }
        String str = hour + "个小时" + min + "分钟";
        String str1 = hour + "hours" + min + " minutes᠃";
        distanceTime.setDistanceTime(str1);
        distanceTime.setGetDistanceTimeCn(str);
        return distanceTime;
        /*if(day<0||hour<0||min<0){
            return "overdue";
        }
        if(day==0){
            return hour + "hours" + min + " minutes᠃";
        }
        return hour + "hours" + min + " minutes᠃";*/
    }

    public static DistanceTime getDatePoorNewMo(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        DistanceTime distanceTime = new DistanceTime();
        if (day < 0 || hour < 0 || min < 0) {
            distanceTime.setFlag(false);
            return distanceTime;
        }
        if (day > 0) {
            String str = day + "天" + hour + "个小时" + min + "分钟";
            String str1 = day + "天" + hour + "цаг" + min + " минут дутуу байна ᠃";
            distanceTime.setDistanceTime(str1);
            distanceTime.setGetDistanceTimeCn(str);
            return distanceTime;
        }
        String str = hour + "个小时" + min + "分钟";
        String str1 = hour + "цаг" + min + " минут дутуу байна ᠃";
        distanceTime.setDistanceTime(str1);
        distanceTime.setGetDistanceTimeCn(str);
        return distanceTime;
        /*if(day<0||hour<0||min<0){
            return "overdue";
        }
        if(day==0){
            return hour + "цаг" + min + " минут дутуу байна ᠃";
        }
        return hour + "цаг" + min + " минут дутуу байна ᠃";*/
    }
}
