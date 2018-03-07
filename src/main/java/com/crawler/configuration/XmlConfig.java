package com.crawler.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by admin on 16/12/1.
 */
@Configuration
@ImportResource(locations ={
        "classpath:applicationContext.xml",
        "classpath:applicationContext-dataSource.xml",
        "classpath:applicationContext-mybatis.xml",
        "classpath:mybatis-config.xml"})
public class XmlConfig {
}
