package com.cos.repository;

import com.cos.model.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    //findBy 규칙 -> u_id 문법
    //select * from user where u_id = 1?
    public UserEntity findByuid(String username); //JPA 쿼리 메소드
}
