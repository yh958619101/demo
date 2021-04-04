package com.yh.yh;

import java.util.concurrent.locks.LockSupport;

/**
 * @author yh
 * @version 1.0
 * @date 2020/7/12 0012 12:20
 */
public class LockSupportTest {

    static  Thread t1=null,t2=null;
    public static void main(String[] args) {
        char[] a1="1234567".toCharArray();
        char[] a2="ABCDEFG".toCharArray();
        t1=new Thread(()->{
            for (char  c:a1){
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");
        t2=new Thread(()->{
            for (char  c:a2){
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
