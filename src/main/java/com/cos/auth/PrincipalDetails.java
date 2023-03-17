package com.cos.auth;
//시큐리티가 /login_process 주소 요청이 오면 낚아채서 로그인 진행시킴
//로그인 진행이 완료가 되면 시큐리티 session 생성하기 (Security ContextHolder)
//시큐리티가 가지고 있는 session에 들어갈 수 있는 정보(object)는 정해져 있음 => Authentication 객체
//Authentication 안에 User 정보가 있어야 됨
//User 오브젝트 타입은 => UserDetails 타입 객체

//Security Session => Authentication => UserDetails

import com.cos.model.entity.user.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

    private final UserEntity userEntity; // 콤포지션

    public PrincipalDetails(UserEntity userEntity){
        this.userEntity = userEntity; //PrincipalDetailsService의 loadUserByUsername에서 리턴된 userEntity
    }

    //해당 User(계정)가 갖고 있는 권한 목록을 리턴하는 곳
    //메소드 명의 이름은 정해진 것이라 바꿀 수 없음
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>(); //ArrayList는 Collection의 자식
        collection.add((GrantedAuthority) userEntity::getRole);
        System.out.println("getRole : "+userEntity.getRole());
        return collection;
    }

    //패스워드 리턴하는 곳
    @Override
    public String getPassword() {
        return userEntity.getUpw();
    }

    //user ID 리턴하는 곳
    @Override
    public String getUsername() {
        return userEntity.getUid();
    }

    //계정의 만료 여부 (true 리턴 시 만료되지 않음을 의미함)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정 잠김 여부 (true 리턴 시 잠겨있지 않음을 의미함)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //계정의 패스워드 만료 여부 (true 리턴 시 패스워드가 만료되지 않음을 의미)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //사용 가능한 계정인지 여부 확인 (true 리턴 시 사용 가능한 계정임을 의미)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
