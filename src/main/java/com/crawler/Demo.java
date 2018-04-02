package com.crawler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by admin on 2018/3/13.
 */
public class Demo {

    public static void main(String args[]){
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        RedisTemplate redisTemplate = (RedisTemplate) factory.getBean("redisTemplate");
        redisTemplate.opsForValue().set("bing", "123");

    }
}
