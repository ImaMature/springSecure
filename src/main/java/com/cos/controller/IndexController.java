package com.cos.controller;

import com.cos.Service.UserService;
import com.cos.model.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //view를 리턴
public class IndexController {

    @Autowired
    public UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCPwEnCode;

    @GetMapping({"","/"})
    public String index(){
        //mustache 기본 폴더는 src/main/resources/
        //view resolver 설정 시: templates (prefix), .mustache(suffix)
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "./common/login";
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

    @GetMapping("/sign_up")
    public String sign_up(){
        return "./user/sign_up";
    }

    @Secured("ADMIN") //권한 제한. 해당 권한을 가진 유저만 접근 가능
    @GetMapping("/info")
    @ResponseBody
    public String info(){
        return "개인정보";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    //data() 메소드가 실행되기 직전에 실행됨, ROLE_을 빼야 작동함
    //여러 개 권한 설정 시 사용
    @GetMapping("/data")
    @ResponseBody
    public String data(){
        return "데이터정보";
    }

    @PostMapping("/sign_up_success")
    public String sign_up_success(UserDto userDto){
        userDto.setUpw(bCPwEnCode.encode(userDto.getUpw()));
        userDto.setRole("ROLE_USER");
        userService.SignUp(userDto);
        return "redirect:/login";
    }

}
