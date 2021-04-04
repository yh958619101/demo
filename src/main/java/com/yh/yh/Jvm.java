package com.yh.yh;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yh
 * @version 1.0
 * @date 2020/6/15 0015 8:08
 */
public class Jvm {
    private static final Integer  k =1024;

    public static void main(String[] args) {
        int size=k*k*8;
        List<byte[]> list=new ArrayList<byte[]>();
        for (int i=0;i<k;i++){
            System.out.println("jvm写入数据"+(i+1)+"m1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new byte[size]);
        }
    }
}
