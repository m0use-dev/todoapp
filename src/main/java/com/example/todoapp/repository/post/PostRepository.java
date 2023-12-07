package com.example.todoapp.repository.post;

import com.example.todoapp.service.post.PostEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostRepository {
    @Select("SELECT user_id,content,status,created_at,updated_at,deadline FROM posts WHERE user_id = 1;")
    List<PostEntity> select();

    @Select("SELECT user_id,content,status,created_at,updated_at,deadline FROM posts;")
    List<PostEntity> selectAll();

}
