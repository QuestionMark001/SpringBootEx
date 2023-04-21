package com.qm001.ex7;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Ex7Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex7Application.class, args);
        log.info("The project is running...");
    }

}
