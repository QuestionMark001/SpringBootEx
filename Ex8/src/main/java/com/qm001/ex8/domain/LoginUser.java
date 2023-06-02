package com.qm001.ex8.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class LoginUser {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;

}
