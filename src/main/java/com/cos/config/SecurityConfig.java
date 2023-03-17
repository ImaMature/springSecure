package com.cos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //해당 클래스가 Spring container에서 관리되는 config 설정임을 알려주며 @Bean을 등록할 수 있게 함
@EnableWebSecurity
public class SecurityConfig {
    //패스워드 암호화
    @Bean
    public BCryptPasswordEncoder encodedPw(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //스프링 시큐리티 5.7.7 버전 참고함
        //https://docs.spring.io/spring-security/reference/5.7/servlet/authentication/passwords/form.html#page-title
        http
            .authorizeHttpRequests(authorize -> authorize
                    .mvcMatchers("/user/**").authenticated()
                    .mvcMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER") //ADMIN이나 MANAGER라는 Role이 있음 접근 가능
                    .mvcMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().permitAll()

            ).formLogin(login -> login   //로그인 페이지로 이동
                        .loginPage("/login")
                        .loginProcessingUrl("/login_process") //login_success 주소가 호출되면 시큐리티가 낚아채서 대신 로그인 해줌
                        .defaultSuccessUrl("/") //deafault_success
            );
        return http.build();
    }
}
