package com.cos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //해당 클래스가 Spring container에서 관리되는 config 설정임을 알려주며 @Bean을 등록할 수 있게 함
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //스프링 시큐리티 5.3.2 버전 참고함
        //https://docs.spring.io/spring-security/site/docs/5.3.2.RELEASE/reference/html5/#servlet-authorization-filtersecurityinterceptor
        http
            .authorizeHttpRequests(authorize -> authorize
                    .mvcMatchers("/user/**").authenticated()
                    .mvcMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER") //ADMIN이나 MANAGER라는 Role이 있음 접근 가능
                    .mvcMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().permitAll()

            ).formLogin(login -> login   //로그인 페이지로 이동
                        .loginPage("/login")
                );
        return http.build();
    }
}
