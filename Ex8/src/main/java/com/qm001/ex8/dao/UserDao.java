package com.qm001.ex8.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.qm001.ex8.domain.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseMapper<LoginUser> {
    @Select("select * from user where name = #{name}")
    public LoginUser Users(String name);
}
