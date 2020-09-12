package com.yh;

import com.yh.until.MailUtil;

public class MailTest {
    public static void main(String[] args) {
        String message="邮件测试";
        String to="958619101@qq.com";
        boolean send = MailUtil.send(to, "测试", message);
        System.out.println(send);
    }
}
