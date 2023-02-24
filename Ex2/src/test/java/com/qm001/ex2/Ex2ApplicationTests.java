package com.qm001.ex2;

import com.qm001.ex2.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex2ApplicationTests {

    @Autowired
    private HelloController helloController;

    @Test
    void test_hello() {
        // 测试 hello() 接口
        System.out.println(helloController.hello());
    }

}
