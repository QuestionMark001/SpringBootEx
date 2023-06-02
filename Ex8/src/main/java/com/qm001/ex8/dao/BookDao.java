package com.qm001.ex8.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qm001.ex8.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
