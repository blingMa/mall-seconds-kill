package com.blingma.mallsecondskillsvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MallSecondsKillSvrApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallSecondsKillSvrApplication.class, args);
    }

}
