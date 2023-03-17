package com.cos.model.entity.user;

import com.cos.model.dto.user.UserDto;
import com.cos.model.entity.common.BaseTimeEntity;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Collections;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Builder
public class UserEntity extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int u_no;
    @Column(name="u_id")
    private String u_id;
    @Column(name="u_pw")
    private String u_pw;
    @Column(name="u_name")
    private String u_name;
    @Column(name="u_email")
    private String u_email;
    @Column(name="role")
    private String role; //USER, ADMIN
    @Column(name="u_birth")
    private String u_birth;
    @Column(name="u_address")
    private String u_address;

    @Builder(builderClassName = "ByUserBuilder", builderMethodName = "ByUserBuilder")
    public UserEntity(UserDto userDto){
        Assert.hasText(userDto.getU_id().trim(), "id 값이 없음");
        Assert.hasText(userDto.getU_pw().trim(), "pw 값이 없음");
        Assert.hasText(userDto.getU_name().trim(), "username 값이 없음");
        Assert.hasText(userDto.getU_email().trim(), "email 값이 없음");
        Assert.hasText(userDto.getU_address().trim(), "address 값이 없음");
        Assert.hasText(userDto.getU_birth().trim(), "birth 값이 없음");

        this.u_id = userDto.getU_id();
        this.u_pw = userDto.getU_pw();
        this.u_name = userDto.getU_name();
        this.u_email = userDto.getU_email();
        this.u_address = userDto.getU_address();
        this.u_birth = userDto.getU_birth();
        this.role = userDto.getRole();
    }
}
