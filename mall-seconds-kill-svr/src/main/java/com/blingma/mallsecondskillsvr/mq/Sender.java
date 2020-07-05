package com.blingma.mallsecondskillsvr.mq;

import com.blingma.mallsecondskillsvr.config.RabbitmqConfig;
import com.blingma.mallsecondskillsvr.mq.domain.MailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author shihao.ma
 * @since 2020/6/6
 */
@Component
@RequiredArgsConstructor
public class Sender {

    private final RabbitTemplate rabbitTemplate;

    public void sendMailMessage(Long orderId) {
        rabbitTemplate.convertAndSend(RabbitmqConfig.SEND_MAIL_EXCHANGE,
                RabbitmqConfig.SEND_MAIL_ROUTING_KEY,
                new MailMessage() {{
                    setMail("1454207688@qq.com");
                    setOrderId(orderId);
                }});
    }
}
