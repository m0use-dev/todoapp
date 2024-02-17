package com.example.todoapp.repository.user;

import com.example.todoapp.service.user.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {


    @Select("SELECT id,username,authority FROM authorities;")
    List<UserEntity> getUserAll();
    
}
