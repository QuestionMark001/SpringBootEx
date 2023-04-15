package com.qm001.ex7.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qm001.ex7.domain.Book;
import com.qm001.ex7.service.IBookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// 此表现层在此项目中废弃！！！

// Restful 风格接口
// @RestController // 注释此注解后就不会被加载成 Bean 了
@RequestMapping("/books")
public class BookControllerOld {
    @Resource
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.list();
    }

    @PostMapping
    // @RequestBody 实体数据
    public Boolean save(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping
    // @RequestBody 实体数据
    public Boolean update(@RequestBody Book book) {
        return bookService.modify(book);
    }

    @DeleteMapping("{id}")
    // @PathVariable 路径变量
    public Boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }

    @GetMapping("{id}")
    // @PathVariable 路径变量
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    // @PathVariable 路径变量
    public IPage<Book> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return bookService.getPage(currentPage, pageSize);
    }
}
