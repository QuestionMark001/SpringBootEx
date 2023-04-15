package com.qm001.ex7.controller.utils;

/* 为了避免后端的报错信息直接传给前端人员以及后期的Debug，
需要做一下 异常消息一致性处理：
即：将抛出的异常统一格式 */

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    // 拦截所有异常信息
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex) {

        // 这里写一些用来 记录日志、通知运维、通知开发... 的代码

        ex.printStackTrace(); // 这一行代码一定要写！！！用来将异常返回给后端控制台（不写的话可能后端控制台一点报错都没有）
        return new R("服务器故障，请稍后再试 X﹏X");
    }

}
