package com.yh.until;
import java.util.regex.Pattern;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author LiuJinan
 * @version V1.0.0 2016年11月23日
 * @version V1.1.0 2016年12月26日
 */
public class MailUtil {

    /**
     * 发送邮件
     * @author          LiuJinan
     * @time            2016-11-23  上午9:10:22
     * @param to        收件人
     * @param title     标题
     * @param message   发送内容
     * @return
     */
    public static boolean send(String to, String title, String message) throws MailException{

        if(to==null || to.equals("")){
            throw new MailException(MailError.MAIL_NULL_RECEIVER);
        }
        if(title==null || title.equals("")){
            throw new MailException(MailError.MAIL_NULL_SUBJECT);
        }
        if(message==null || message.equals("")){
            throw new MailException(MailError.MAIL_NULL_MESSSAGE);
        }

        Mail mail = new Mail();
        mail.setReceiver(to);
        mail.setSubject(title);
        mail.setMessage(message);
        // 发送email
        HtmlEmail email = new HtmlEmail();
        try {
            email.setHostName(mail.getHost());
            email.setCharset(Mail.ENCODEING);
            // 收件人的邮箱
            email.addTo(mail.getReceiver());
            // 发送人的邮箱
            email.setFrom(mail.getSender(), mail.getName());
            // 设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
            email.setAuthentication(mail.getUsername(), mail.getPassword());
            // 要发送的邮件标题
            email.setSubject(mail.getSubject());
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setMsg(mail.getMessage());
            // 发送
            String result =  email.send();
            return true;
        } catch (EmailException e) {
//            e.printStackTrace();
//            logger.info(mail.getSender() + " 发送邮件到 " + mail.getReceiver()
//                    + " 失败");
            return false;
        }
    }
}

