package com.qm001.ex7.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qm001.ex7.domain.Book;

import java.util.List;

// 此 Service 在此项目中废弃！！！
// Mybatis 写法
public interface BookServiceOld {

    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage, int pageSize);
}
