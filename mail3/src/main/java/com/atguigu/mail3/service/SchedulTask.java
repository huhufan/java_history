package com.atguigu.mail3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulTask {
    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Scheduled(cron = "0/2 * * * * *")
    @Async
    public void task(){
        sendMail();
    }
    public void sendMail() {
        System.out.println("发送");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("haha");
        mailMessage.setText(String.valueOf(System.nanoTime()));
        mailMessage.setTo("fhhmars@163.com");
        mailMessage.setFrom("825422724@qq.com");
        javaMailSender.send(mailMessage);
    }
}
