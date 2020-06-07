package com.hydu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author heyong
 * @Date: 2020/6/7  10:53
 */
@RestController
public class ErrorController {

    @RequestMapping("/error/403")
    public String error403(){
        return "您的访问权限不足";
    }

    @RequestMapping("/error/404")
    public String error404(){
        return "您的访问页面不存在";
    }
}
