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
    @Column(name="uid")
    private String uid;
    @Column(name="upw")
    private String upw;
    @Column(name="uname")
    private String uname;
    @Column(name="uemail")
    private String uemail;
    @Column(name="role")
    private String role; //USER, ADMIN
    @Column(name="ubirth")
    private String ubirth;
    @Column(name="uaddress")
    private String uaddress;

    @Builder(builderClassName = "ByUserBuilder", builderMethodName = "ByUserBuilder")
    public UserEntity(UserDto userDto){
        Assert.hasText(userDto.getUid().trim(), "id 값이 없음");
        Assert.hasText(userDto.getUpw().trim(), "pw 값이 없음");
        Assert.hasText(userDto.getUname().trim(), "username 값이 없음");
        Assert.hasText(userDto.getUemail().trim(), "email 값이 없음");
        Assert.hasText(userDto.getUaddress().trim(), "address 값이 없음");
        Assert.hasText(userDto.getUbirth().trim(), "birth 값이 없음");

        this.uid = userDto.getUid();
        this.upw = userDto.getUpw();
        this.uname = userDto.getUname();
        this.uemail = userDto.getUemail();
        this.uaddress = userDto.getUaddress();
        this.ubirth = userDto.getUbirth();
        this.role = userDto.getRole();
    }
}
