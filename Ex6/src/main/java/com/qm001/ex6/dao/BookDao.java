package com.qm001.ex6.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qm001.ex6.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
