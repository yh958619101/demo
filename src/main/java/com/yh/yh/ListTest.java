package com.yh.yh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yh
 * @version 1.0
 * @date 2020/5/14 0014 21:37
 */
public class ListTest {
    public static void main(String[] args) {
     /*   User User=new User(1,"aaa");
        List<User> userList= Arrays.asList(
                new User(2,"111"),
                 new User(1,"222"),
                new User(2,"333"),
        new User(2,"111"),
                new User(1,"222"),
                new User(2,"334")
        );
        List<User> list =new ArrayList<>(userList);
        list.stream()
                .distinct()
                .forEach(System.out::println);*/
        List<User> userList=new ArrayList<>();
        userList.add(new User(1,"xx"));
        userList.add(new User(1,"xx"));
        userList.add(new User(2,"xx"));
        Set<User> ts = new HashSet<User>(userList);
        System.out.println(ts);
        userList.clear();
        userList.addAll(ts);
        userList.forEach(student->{
            System.out.println(student.toString());

        });


    }

}
