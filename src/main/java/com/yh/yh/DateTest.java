package com.yh.yh;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yh
 * @version 1.0
 * @date 2020/6/19 0019 17:03
 */
public class DateTest {
    public static void main(String[] args) {

                Date date=new Date();
                Calendar ca=Calendar.getInstance();
                ca.setTime(date);
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");

                String st=sdf.format(date);
                int i=ca.get(Calendar.DAY_OF_YEAR);
                int a=ca.get(Calendar.DAY_OF_MONTH);
                System.out.println("当前时间是："+st+";一年中的第"+i+"天"+"一个月中的第"+a+"天");

            }






        }
