package com.cos.auth;

import com.cos.model.entity.user.UserEntity;
import com.cos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//발동하는 순간 -> 시큐리티 설정(SecurityConfig)에서 loginProcessingUrl("/login_process")
// /login_process 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어 있는 loadUserByUsername 함수가 실행 됨
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //Security Session(내부 Authentication) <== Authentication(내부 UserDetails) <== UserDetails
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //username은 html에서 받아옴
        System.out.println("username : "+username);
        UserEntity userEntity = userRepository.findByuid(username);
        if(username != null){
            return new PrincipalDetails(userEntity); //리턴된 값이 Authentication(UserDetails)에 들어감
        }
        return null;
    }
}
