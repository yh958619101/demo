package com.yh.until;

/**
 * @author LiuJinan
 * @version V1.1.0 2016年12月26日
 */
public enum MailError {

    /**
     * 收件人为空
     */
    MAIL_NULL_RECEIVER("收件人为空。"),
    /**
     * 标题为空
     */
    MAIL_NULL_SUBJECT("标题为空。"),
    /**
     * 发送内容为空
     */
    MAIL_NULL_MESSSAGE("发送内容为空。"),
    /**
     * 邮箱格式错误
     */
    MAIL_ERROR_MAILE("格式错误"),
    ;


    private String msg;

    MailError(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MailError{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
