package com.test.mytest.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.test.mytest.aop")
@EnableAutoConfiguration
public class SpringAspectConfig {
}
