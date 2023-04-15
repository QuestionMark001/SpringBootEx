package com.qm001.ex7.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qm001.ex7.dao.BookDao;
import com.qm001.ex7.domain.Book;
import com.qm001.ex7.service.BookServiceOld;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

// 此 Impl 在此项目中废弃！！！
// Mybatis 写法
// @Service
public class BookServiceImplOld implements BookServiceOld {

    @Resource
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }
}
