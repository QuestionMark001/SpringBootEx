package com.qm001.ex8;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Web {
    @GetMapping("/admin")
    public String admin(){
        return "/index.html";
    }

    @GetMapping("/login")
    public String login(){
        return "/login.html";
    }

    @GetMapping("/favicon")
    public String favicon(){
        return "/favicon.ico";
    }
}
