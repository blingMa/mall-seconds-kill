package com.blingma.mallsecondskillsvr;

import com.blingma.mallsecondskillsvr.basic.item.mapper.MallItemMapper;
import com.blingma.mallsecondskillsvr.schedule.MailSchedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallSecondsKillSvrApplicationTests {

    @Autowired
    private MailSchedule mailSchedule;

    @Autowired
    private MallItemMapper mallItemMapper;

    @Autowired
    private Environment environment;

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void contextLoads() {
        mailSchedule.mailSchedule();
    }


    @Test
    public void updateItemTest() {
        redissonClient.getLock("Lock").lock();
    }


    @Test
    public void environmentTest() {
        System.out.println(environment.getProperty("spring.datasource.url"));
    }

}
