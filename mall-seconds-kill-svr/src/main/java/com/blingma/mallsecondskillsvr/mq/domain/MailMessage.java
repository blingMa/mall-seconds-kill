package com.blingma.mallsecondskillsvr.mq.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shihao.ma
 * @since 2020/6/6
 */
@Data
public class MailMessage implements Serializable {
    private Long orderId;
    private String mail;
}
