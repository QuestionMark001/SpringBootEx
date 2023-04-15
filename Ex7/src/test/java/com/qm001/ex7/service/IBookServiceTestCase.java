package com.qm001.ex7.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qm001.ex7.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookServiceTestCase {

    @Autowired
    private IBookService bookService;

    @Test
    void testGetById() {
        System.out.println(bookService.getById(11));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("test888");
        book.setName("test888");
        book.setDescription("test888");
        System.out.println(bookService.save(book));
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(18);
        book.setType("test2233");
        book.setName("test2233");
        book.setDescription("test123");
        bookService.updateById(book);
    }

    @Test
    void testDelete() {
        bookService.removeById(18);
    }

    @Test
    void testGetAll() {
        bookService.list();
    }

    @Test
    void testGetPage() {
        // 查询第 2 页，一页查 5 条
        IPage<Book> page = new Page<>(2, 5);
        bookService.page(page);

        System.out.println("---------------------");

        System.out.println(page.getCurrent());  // 查看 查询的哪个页
        System.out.println(page.getSize());  // 查看 一页查询了多少条数据
        System.out.println(page.getPages());  // 查看 一共几页
        System.out.println(page.getTotal());  // 查看 所有数据总条数
        System.out.println(page.getRecords());  // 查看 所查询的数据本身
    }
}
