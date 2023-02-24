package com.qm001.ex2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "<p>Hello, SpringBoot<br />你好，SpringBoot</p>";
    }
}
