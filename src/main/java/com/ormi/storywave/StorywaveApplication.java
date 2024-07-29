package com.ormi.storywave;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ormi.storywave")
public class StorywaveApplication {
    private static final Logger logger = LoggerFactory.getLogger(StorywaveApplication.class);

    @Value("${server.port}")
    private int port;

    @Value("${spring.application.name}")
    private String appName;

    @PostConstruct
    public void printConfig() {
        logger.info("포트번호: {}", port);
        logger.info("애플리케이션 이름: {}", appName);
    }

    public static void main(String[] args) {
        SpringApplication.run(StorywaveApplication.class, args);
    }
}

