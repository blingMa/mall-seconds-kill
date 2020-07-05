package com.blingma.mallsecondskillsvr.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author shihao.ma
 * @since 2020/6/3
 */
@Service
@RequiredArgsConstructor
public class MailSchedule {

    private final JavaMailSender javaMailSender;

    public void mailSchedule() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("ma_1008611@163.com");
        simpleMailMessage.setTo("1454207688@qq.com");
//        simpleMailMessage.setTo("1397220502@qq.com");
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setSubject("每日一篇小故事");
        simpleMailMessage.setText("儿子生日，爸爸妈妈很开心，" +
                "于是帮他拍录像。小孩在床上跳啊，跳啊，忽然就摔倒地上死了。爸爸妈妈很伤心。" +
                "过了几个月，他们拿出当时的录像回放时发现，有一只沾满血的手抓着儿子的头发一上一下，" +
                "一上一下，最后往地上一丢。");
        javaMailSender.send(simpleMailMessage);
    }
}
