package com.example.todoapp.repository.user;

import com.example.todoapp.service.user.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {
    @Select("SELECT id,username,authority FROM authorities WHERE user_id = 1;")
    List<UserEntity> getUser();

    @Select("SELECT id,username,authority FROM authorities;")
    List<UserEntity> getUserAll();

    @Insert("INSERT INTO user(name, password, authority) VALUES(#{name}, ?, ?)")
    int insertUser(String name,String password,String authority);

    @Select("SELECT id FROM authorities WHERE user_id = 1;")
    int getUserId();

}
