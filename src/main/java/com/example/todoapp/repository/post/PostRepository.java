package com.example.todoapp.repository.post;

import com.example.todoapp.service.post.PostEntity;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface PostRepository {
    @Select("""
    SELECT id,user_id,content,status,created_at,updated_at,deadline
    FROM posts
    WHERE user_id = 1;
    """)
    List<PostEntity> getPosts();

    @Select("""
    SELECT id,user_id,content,status,created_at,updated_at,deadline
    FROM posts;
    """)
    List<PostEntity> getPostsAll();

    @Select("""
    SELECT id,user_id,content,status,created_at,updated_at,deadline
    FROM posts
    WHERE id = #{id} ;
    """)
    List<PostEntity> getPost(int id);

    @Insert("""
    INSERT INTO posts (user_id, content, status, created_at, updated_at, deadline)
    VALUES (#{post.user_id}, #{post.content},'未完了', #{post.created_at}, #{post.updated_at}, #{post.deadline});
    """)
    int insertPost(@Param("post") PostEntity newEntity);

    @Delete("DELETE FROM posts WHERE id = #{id};")
    int deletePost(int id);

    @Update("UPDATE posts SET status = '完了' WHERE id = #{id};")
    int completionPost(int id);

//    @Update("""
//    UPDATE posts SET content = #{content},status = #{content},updated_at = #{updated_at},deadline = #{deadline} WHERE id = #{id};
//    """)
//    int updatePost(int id, @Param("task") PostEntity newEntity);


}
