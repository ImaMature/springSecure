package com.cos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //view를 리턴
public class IndexController {
    //localhost:8089/
    //localhost:8089
    @GetMapping({"","/"})
    public String index(){
        return "index";
    }
}
