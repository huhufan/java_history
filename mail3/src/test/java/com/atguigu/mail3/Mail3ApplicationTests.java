package com.atguigu.mail3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Mail3ApplicationTests {
    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("haha");
        mailMessage.setText("哈哈哈哈");
        mailMessage.setTo("fhhmars@163.com");
        mailMessage.setFrom("825422724@qq.com");
        javaMailSender.send(mailMessage);
    }

    @Test
    public void test2(){
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true);
            helper.setSubject("hello呀");
            helper.setText("试着发个邮件");
            helper.setTo("fhhmars@163.com");
            helper.setFrom("825422724@qq.com");

            helper.addAttachment("1.jpg",new File("C:\\Users\\ASUS-PC\\Desktop\\新建文件夹\\121836ykg34fe500g0oz03.jpg"));
            helper.addAttachment("2.jpg",new File("C:\\Users\\ASUS-PC\\Desktop\\新建文件夹\\20161007182313_QtiLB.jpeg"));
            javaMailSender.send(mimeMailMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
