package com.cos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //view를 리턴
public class IndexController {
    //localhost:8089/
    //localhost:8089
    @GetMapping({"","/"})
    public String index(){
        //mustache 기본 폴더는 src/main/resources/
        //view resolver 설정 시: templates (prefix), .mustache(suffix)
        return "index";
    }
    @GetMapping("/login")
    @ResponseBody
    public String login(){
        return "login";
    }
    @GetMapping("/user")
    @ResponseBody
    public String user(){
        return "user";
    }
    @GetMapping("/manager")
    @ResponseBody
    public String manager(){
        return "manager";
    }
    @GetMapping("/admin")
    @ResponseBody
    public String admin(){
        return "admin";
    }
    @GetMapping("/join")
    @ResponseBody
    public String join(){
        return "join";
    }
    @GetMapping("/joinProc")
    @ResponseBody
    public String joinProc(){
        return "회원가입 완료";
    }
}
