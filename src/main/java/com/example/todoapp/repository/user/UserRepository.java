package com.example.todoapp.repository.user;

import com.example.todoapp.service.user.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {
    @Select("SELECT id,username,authority FROM authorities WHERE user_id = 1;")
    List<UserEntity> getUser();

    @Select("SELECT id,username,authority FROM authorities;")
    List<UserEntity> getUserAll();
}
