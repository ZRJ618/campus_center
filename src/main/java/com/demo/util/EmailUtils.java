package com.demo.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtils {
    //发送邮件
    public static void emailUTils(String sendTo, String activationCode) throws EmailException {
        HtmlEmail email = new HtmlEmail();//创建HtmlEmail对象
        email.setHostName("smtp.qq.com");//邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
        email.setCharset("utf-8");//设置发送的字符类型
        email.addTo(sendTo);//设置收件人
        email.setFrom("1373233370@qq.com","验证邮箱");//发送人的邮箱为自己的，用户名可以随便填
        email.setAuthentication("1373233370@qq.com","miikkouelbplighf");//设置发送人到邮箱和授权码(授权码是自己设置的)
        email.setSubject("一楼二楼注册验证");//设置发送主题
        email.setMsg("你的激活码为【"+activationCode+"】请赋值到注册页面进行激活");//设置发送内容
        email.send();//进行发送
    }
    //生成随机激活码
    public static String makeActivationCode(){
        char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString((int) ((Math.random() * 9 + 1) * 10)));
        for (int i = 0; i < 2; i++) {
            int num = (int) (0 + Math.random() * (25 - 0 + 1));
            System.out.println(num);
            stringBuilder.append(chars[num]);
        }
        return stringBuilder.toString();
    }
}
