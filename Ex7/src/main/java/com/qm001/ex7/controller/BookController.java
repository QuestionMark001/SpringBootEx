package com.qm001.ex7.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qm001.ex7.controller.utils.R;
import com.qm001.ex7.domain.Book;
import com.qm001.ex7.service.IBookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

// Restful 风格接口
@RestController
@RequestMapping("/books")
public class BookController {
    @Resource
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    // @RequestBody 实体数据
    public R save(@RequestBody Book book) {
    // public R save(@RequestBody Book book) throws IOException {
        // if (book.getName().equals("123")) throw new IOException(); // 测试异常抛出功能，最后一定要注释掉！！！
        return new R(bookService.save(book));
    }

    @PutMapping
    // @RequestBody 实体数据
    public R update(@RequestBody Book book) {
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    // @PathVariable 路径变量
    public R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    // @PathVariable 路径变量
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    // @PathVariable 路径变量
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        // 如果当前页页码大于总页码值，则重新执行查询，并重新使用最大页码值作为当前页码
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }
}
