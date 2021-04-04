package com.yh.Util;

/**
 * @author LiuJinan
 * @version V1.1.0 2016年12月26日
 */
public class MailException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MailException(Object msg) {
        super(msg.toString());
    }

}
