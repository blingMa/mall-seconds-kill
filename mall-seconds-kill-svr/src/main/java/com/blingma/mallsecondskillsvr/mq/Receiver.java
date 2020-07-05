package com.blingma.mallsecondskillsvr.mq;

import com.blingma.mallsecondskillsvr.config.RabbitmqConfig;
import com.blingma.mallsecondskillsvr.mq.domain.MailMessage;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author shihao.ma
 * @since 2020/6/6
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class Receiver {

    private final JavaMailSender javaMailSender;

    @RabbitListener(queues = RabbitmqConfig.SEND_MAIL_QUEUE)
    private void receiveMailMessage(Message message) {
        try {
            String string = new String(message.getBody(), "UTF-8");
            log.info("json数据为：{}", string);
            MailMessage mailMessage = new Gson().fromJson(string, MailMessage.class);
            log.info("订单编号：{}，邮箱：{}", mailMessage.getOrderId(), mailMessage.getMail());
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("ma_1008611@163.com");
            simpleMailMessage.setTo(mailMessage.getMail());
            simpleMailMessage.setText(String.valueOf(mailMessage.getOrderId()));
            simpleMailMessage.setSentDate(new Date());
            simpleMailMessage.setSubject("毕业论文");
//            javaMailSender.send(simpleMailMessage);
        } catch (UnsupportedEncodingException e) {
            log.error("Receiver receiveMailMessage(Message message) 发生异常：{}", e.getMessage());
        }
    }
}
