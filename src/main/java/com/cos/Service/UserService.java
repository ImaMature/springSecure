package com.cos.Service;

import com.cos.model.dto.user.UserDto;
import com.cos.model.entity.user.UserEntity;
import com.cos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    //회원가입
    public boolean SignUp(UserDto userDto){
        System.out.println("서비스 들어옴");
        UserEntity userEntity = UserEntity.ByUserBuilder()
                .userDto(userDto)
                .build();
        System.out.println(userEntity);
        userRepo.save(userEntity);
        return true;
    }
}
