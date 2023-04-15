package com.qm001.ex7.controller.utils;

/* 为了让前端人员更好的处理数据以及后期的Debug，
需要做一下 表现层消息一致性处理（简称 前后端数据协议）：

data（Object）代表 CRUD 的数据，
flag（Boolean）代表 CRUD 数据操作是否成功，
msg（String）代表 抛出的异常信息；
flag 为 true ，data 为 null ，代表 CRUD 数据操作成功，但数据不存在，
flag 为 false ，data 为 null ，代表 CRUD 数据操作失败，操作过程中抛出异常 */

import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;

    // 构造方法

    // R
    public R() {}

    // R(flag)
    public R(Boolean flag) {
        this.flag = flag;
    }

    // R(flag, data)
    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    // R(msg)
    // Q: 为什么没有 data 和 flag？
    // A: 都已经抛异常了，还哪来的 data X﹏X ，flag 直接定义成 false 得了
    public R(String msg) {
        this.flag = false; // 将 flag 直接定义成 false
        this.msg = msg;
    }
}
