package com.cos.model.dto.user;

import com.cos.model.entity.user.UserEntity;
import lombok.*;

import java.time.LocalDateTime;
@Getter @Setter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class UserDto {
    private String uid;
    private String upw;
    private String uname;
    private String uemail;
    private String role; //USER, ADMIN
    private String ubirth;
    private String uaddress;
    private LocalDateTime createDate;

    public UserEntity userEntity(){
        return UserEntity.builder()
                .uid(this.uid)
                .upw(this.upw)
                .uname(this.uname)
                .role(this.role)
                .ubirth(this.ubirth)
                .uaddress(this.uaddress)
                .build();
    }
}
