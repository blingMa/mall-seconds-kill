package com.blingma.mallsecondskillsvr.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author shihao.ma
 * @since 2020/6/4
 */
@Component
public class RabbitmqConfig {

    public static final String SEND_MAIL_QUEUE ="send_mail_queue";
    public static final String SEND_MAIL_EXCHANGE ="send_mail_exchange";
    public static final String SEND_MAIL_ROUTING_KEY ="send_mail_routing_key";


    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("101.201.123.207", 5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");
        connectionFactory.setVirtualHost("/");
        // 如果消息要设置成回调，则以下的配置必须要设置成true
        connectionFactory.setPublisherConfirms(false);
        connectionFactory.setPublisherReturns(false);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue sendMailQueue(){
        return new Queue(SEND_MAIL_QUEUE, true);
    }

    @Bean
    public DirectExchange sendMailExchange(){
        return new DirectExchange(SEND_MAIL_EXCHANGE, true, false);
    }

    @Bean
    public Binding sendMailBinding(){
        return BindingBuilder.bind(sendMailQueue()).to(sendMailExchange()).with(SEND_MAIL_ROUTING_KEY);
    }
}
