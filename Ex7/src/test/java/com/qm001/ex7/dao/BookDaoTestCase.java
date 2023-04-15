package com.qm001.ex7.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qm001.ex7.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testSelect() {
        bookDao.selectById(1);
    }

    @Test
    void testGetAll() {
        bookDao.selectList(null);
    }

    @Test
    void testGetPage() {
        // 查询第 1 页，一页查 5 条
        // IPage page_1 = new Page(1, 5);

        // 查询第 2 页，一页查 5 条
        IPage page_2 = new Page(2, 5);

        // bookDao.selectPage(page_1, null);
        bookDao.selectPage(page_2, null);

        System.out.println("---------------------");

        System.out.println(page_2.getCurrent());  // 查看 查询的哪个页
        System.out.println(page_2.getSize());  // 查看 一页查询了多少条数据
        System.out.println(page_2.getPages());  // 查看 一共几页
        System.out.println(page_2.getTotal());  // 查看 所有数据总条数
        System.out.println(page_2.getRecords());  // 查看 所查询的数据本身
    }

    @Test
    void testGetBy() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        // 按条件查询
        // 等同于 select * from tbl_book where name like %田所浩二%
        qw.like("name", "田所浩二");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2() {
        // String name = "spring"; // 模拟从外界传进来的数据 name
        // ！注意：如果外界传进来的是 null ，则会被当成字符串 "%null%" 被处理，
        // 这时非常容易被 黑客/骇客 进行SQL注入，需要手动加限制条件，或使用 $ 符号进行防SQL注入
        // String name = null; // 加入 name != null 后传入 null 不会被写入SQL语句，而会直接做全表查询
        String name = "spring";

        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        // lqw.like(限制条件, Book::getName, name); // 动态条件拼装
        lqw.like(name != null, Book::getName, name); // name != null 来限制 null 被传入
        bookDao.selectList(lqw);
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试类型数据");
        book.setName("测试名称数据");
        book.setDescription("测试描述数据");

        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(16);
        book.setType("114514");
        book.setName("田所浩二");
        book.setDescription("哼，哼，哼，啊啊啊啊啊啊啊啊！！！");

        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(16);
    }

}
