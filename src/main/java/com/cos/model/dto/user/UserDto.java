package com.cos.model.dto.user;

import com.cos.model.entity.user.UserEntity;
import lombok.*;

import java.time.LocalDateTime;
@Getter @Setter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class UserDto {
    private String u_id;
    private String u_pw;
    private String u_name;
    private String u_email;
    private String role; //USER, ADMIN
    private String u_birth;
    private String u_address;
    private LocalDateTime createDate;

    public UserEntity userEntity(){
        return UserEntity.builder()
                .u_id(this.u_id)
                .u_pw(this.u_pw)
                .u_name(this.u_name)
                .role(this.role)
                .u_birth(this.u_birth)
                .u_address(this.u_address)
                .build();
    }
}
