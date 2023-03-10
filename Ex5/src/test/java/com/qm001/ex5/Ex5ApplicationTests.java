package com.qm001.ex5;

import com.qm001.ex5.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex5ApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void selectTest_0() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void selectTest_1() {
        System.out.println(bookDao.selectById(3));
    }

}
