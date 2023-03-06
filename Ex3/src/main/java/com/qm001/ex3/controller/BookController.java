package com.qm001.ex3.controller;

import com.qm001.ex3.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    // 读取 yaml 文件数据中的单一数据
    @Value("${spring.datasource.username}")
    private String username1;

    @Value("${tempDir}")
    private String tempDir;

    @Value("${tempDir2}")
    private String tempDir2;

    // 使用自动装配将所有的数据封装到一个对象 Environment 中
    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping("/books")
    public String getById() {
        System.out.println("username ===> " + username1); // 读取 yaml 数据
        System.out.println("------------------------");
        System.out.println("tempDir ===> " + tempDir); // 读取有变量引用的属性
        System.out.println("Escape Character ===> " + tempDir2);
        System.out.println("------------------------");
        System.out.println("Server Port ===> " + env.getProperty("server.port"));
        System.out.println("------------------------");
        System.out.println(myDataSource);

        System.out.println("SpringBoot is running ...");
        return "SpringBoot is running ...";
    }
}
