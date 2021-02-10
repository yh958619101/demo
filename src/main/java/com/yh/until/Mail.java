package com.yh.until;

import java.io.Serializable;

/**
 * @author LiuJinan
 * @version V1.1.0 2016年12月26日
 */
@SuppressWarnings("serial")
class Mail implements Serializable {

    public final static String ENCODEING = "UTF-8";

    private final static String HOST = "smtp.163.com";

    private final static String SENDER = "yh19950927@163.com";    //发送人邮箱

    private final static String NAME = "昵称";        //发件人昵称
    //OQVCGTIFTZKQLVRN
    private final static String PASSWORD = "OQVCGTIFTZKQLVRN";  //密码

    private final static String SUBJECT = "标题";     //邮件标题

    private final static String USERNAME = "yh19950927@163.com";  //发送人邮箱
    /**
     * 服务器地址
     */
    private String host = this.HOST;
    /**
     * 发件人邮箱
     */
    private String sender = this.SENDER;
    /**
     * 收件人
     */
    private String receiver;
    /**
     * 发件人昵称
     */
    private String name = this.NAME;
    /**
     * 发件人账号
     */
    private String username = this.USERNAME;
    /**
     * 发件人密码
     */
    private String password = this.PASSWORD;
    /**
     * 主题
     */
    private String subject = this.SUBJECT;
    /**
     * 发送的信息
     */
    private String message;

    public String getHost() {
        return host;
    }

    //  public void setHost(String host) {
//      this.host = host;
//  }
    public String getSender() {
        return sender;
    }

    //  public void setSender(String sender) {
//      this.sender = sender;
//  }
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    //  public void setUsername(String username) {
//      this.username = username;
//  }
    public String getPassword() {
        return password;
    }

    //  public void setPassword(String password) {
//      this.password = password;
//  }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
