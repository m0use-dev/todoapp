package com.example.todoapp.repository.post;

import com.example.todoapp.service.post.PostEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostRepository {
    @Select("SELECT id,user_id,content,status,created_at,updated_at,deadline FROM posts WHERE user_id = 1;")
    List<PostEntity> getPosts();

    @Select("SELECT id,user_id,content,status,created_at,updated_at,deadline FROM posts;")
    List<PostEntity> getPostsAll();

    @Select("SELECT id,user_id,content,status,created_at,updated_at,deadline FROM posts WHERE id = 1 ;")
    List<PostEntity> getPost(int id);

//    @Select("INSERT INTO posts (id, user_id, content, status, created_at, updated_at, deadline) VALUES (1, 1, 'テスト投稿', 1, '2023-11-10', '2023-11-10', '2023-12-10');")
//    List<PostEntity> insertPost();
//
//    @Select("DELETE FROM posts WHERE user_id = 1;")
//    List<PostEntity> deletePost();
//
//    @Select("UPDATE posts SET user_id = 1,content = 'テスト投稿',status = 1,created_at = '2023-10-10',updated_at = '2023-10-10',deadline = '2023-11-10' WHERE user_id = 1;")
//    List<PostEntity> updatePost();

}
