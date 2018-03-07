package com.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Created by admin on 16/11/17.
 */
@SpringBootApplication
@EnableScheduling
public class Server {
    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }

}
