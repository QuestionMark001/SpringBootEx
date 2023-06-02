package com.qm001.ex8.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qm001.ex8.domain.Book;

// Mybatis Plus 写法
// 本项目采用此写法
public interface IBookService extends IService<Book> {

    // 自定义一些自己的表现层接口
    //@Override // 如果这里有报错，则自定义的接口中有与 Mybatis Plus 冲突的接口
    boolean saveBook(Book book);

    boolean modify(Book book);

    boolean delete(Integer id);

    IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
