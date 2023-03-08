package com.qm001.ex4;

import com.qm001.ex4.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex4ApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void selectTest() {
        System.out.println(bookDao.getById(1));
    }

}
