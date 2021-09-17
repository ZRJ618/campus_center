package com.demo.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getDate(){
        Date date = new Date();
        return sdf.format(date);
    }
    /*
    * 判断时间段1是否在时间段2内
    * */
    public static boolean CompareTime(String startTime1, String endTime1, String startTime2, String endTime2){
        long stl1 = 0L;
        long etl1 = 0L;
        long stl2 = 0L;
        long etl2 = 0L;
        try{
            stl1 = sdf.parse(startTime1).getTime();
            etl1 = sdf.parse(endTime1).getTime();
            stl2 = sdf.parse(startTime2).getTime();
            etl2 = sdf.parse(endTime2).getTime();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("1:" + (stl1 - stl2));
        System.out.println("2:" + (etl2 - etl1));
        if((stl2 - stl1) > 0 && (etl2 - etl1) > 0){
            return true;
        }
        return false;
    }
    /*
    * 判断时间t1是否大于t2
    * 如果t1大于t2 返回true
    * 否则返回false*/
    public static boolean CompareTime(String t1, String t2){
        long tl1 = 0;
        long tl2 = 0;
        try{
            tl1 = sdf.parse(t1).getTime();
            tl2 = sdf.parse(t2).getTime();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(tl1 - tl2 >= 0){
            return true;
        }else{
            return false;
        }
    }



        //将字符串转换为sql.Date格式（注意传入的字符串要符合规范）
        public static java.sql.Date date(String date) throws ParseException {
            if(date == null){
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
            java.sql.Date date1 = new java.sql.Date(simpleDateFormat.parse(date).getTime());
            return date1;
        }
        //将字符串转换为Timestamp格式（注意传入的字符串要符合规范）
        public static Timestamp timeStamp(String date) throws ParseException {
            if(date == null){
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            Timestamp timestamp = new Timestamp(simpleDateFormat.parse(date).getTime());
            return timestamp;
        }

        //将sql.date类型转换成string
        public static String sqlDateToString(java.sql.Date date) throws ParseException {
            if(date == null){
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
            String date1 = simpleDateFormat.format(date);
            return date1;
        }

        //将Timestamp类型转换成string
        public static String timestampToString(Timestamp date) throws ParseException {
            if(date == null){
                return null;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            String date1 = simpleDateFormat.format(date);
            return date1;
        }



    public static void main(String[] args) {
        System.out.println(DateUtils.getDate());
    }
}
