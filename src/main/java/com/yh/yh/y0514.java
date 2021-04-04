package com.yh.yh;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author yh
 * @version 1.0
 * @date 2020/5/14 0014 14:45
 */
public class y0514 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       //list对象去重


        //利用反射删除
        ArrayList<Character> list = new ArrayList<Character>();
        list.add('a');
        list.add('b');
        list.add('v');
        list.add('d');
        System.out.println(list);

        Class l = list.getClass();
        Method method = l.getMethod("remove", int.class);//不能写object对象，写object对象不会根据下标删除，，Integer对象报错
        method.invoke(list, 0);
        System.out.println(list);


        Map<String, String> map = new HashMap<String, String>();
        map.put("name1","小黑");
        map.put("name2","小白");
        map.put("name3","小绿");

        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            String keys = entry.getKey();
            String values = entry.getValue();
            System.out.println(keys+values);
            if(values == "小黑") {
                System.out.println("删除values"+values);
                it.remove();
            }
        }
        System.out.println(map);
        }
    }
