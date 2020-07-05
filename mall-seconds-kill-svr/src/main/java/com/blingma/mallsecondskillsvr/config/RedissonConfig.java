package com.blingma.mallsecondskillsvr.config;

import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author shihao.ma
 * @since 2020/6/8
 */

@RequiredArgsConstructor
@Configuration
public class RedissonConfig {

    private final Environment environment;

    @Bean
    public RedissonClient redisClient(){
        Config config = new Config();
        config.useSingleServer().
                setAddress("redis://" + environment.getProperty("spring.redis.host") + ":" + environment.getProperty("spring.redis.port")).
                setDatabase(Integer.parseInt(environment.getProperty("spring.redis.database")));
//        if(!StringUtils.isEmpty(environment.getProperty("spring.redis.password"))){
//            config.useSingleServer().setPassword(environment.getProperty("spring.redis.password"));
//        }
        return Redisson.create(config);
    }

}
