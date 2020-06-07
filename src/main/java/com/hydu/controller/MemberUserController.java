package com.hydu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author heyong
 * @Date: 2020/6/7  10:40
 */
@Controller
public class MemberUserController {

    @GetMapping("/showMember")
    @ResponseBody
    public String showMember(){
        return "您访问的是showMember这个方法";
    }

    @GetMapping("/addMember")
    @ResponseBody
    public String addMember(){
        return "您访问的是addMember这个方法";
    }


}
