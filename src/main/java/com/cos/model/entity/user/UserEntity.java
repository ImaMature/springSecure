package com.cos.model.entity.user;

import com.cos.model.entity.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="user")
@Builder
public class UserEntity extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int u_id;
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

}
