package com.qm001.ex8;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Ex8Application {
    public static void main(String[] args) {
        SpringApplication.run(Ex8Application.class, args);

        log.info("The project is running...");
        log.info("Project Login URL: http://localhost:8080/login");
    }
}
