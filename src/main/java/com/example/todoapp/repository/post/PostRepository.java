package com.example.todoapp.repository.post;

import com.example.todoapp.service.post.PostEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostRepository {
    @Select("""
            SELECT id,username,content,status,created_at,updated_at,deadline
            FROM posts
            WHERE username = #{username};
            """)
    List<PostEntity> getPosts(String username);

    @Select("""
            SELECT id,username,content,status,created_at,updated_at,deadline
            FROM posts;
            """)
    List<PostEntity> getPostsAll();

    @Select("""
            SELECT id,username,content,status,created_at,updated_at,deadline
            FROM posts
            WHERE id = #{postId} ;
            """)
    Optional<PostEntity> getPost(@Param("postId") long postId);

    @Select("""
            SELECT username
            FROM posts
            WHERE id = #{id} ;
            """)
    String getContributor(int id);

    @Insert("""
            INSERT INTO posts (username, content, status, created_at, updated_at, deadline)
            VALUES (#{post.username}, #{post.content},'未完了', #{post.created_at}, #{post.updated_at}, #{post.deadline});
            """)
    int insertPost(@Param("post") PostEntity newEntity);

    @Delete("DELETE FROM posts WHERE id = #{id};")
    int deletePost(int id);

    @Update("UPDATE posts SET status = '完了' WHERE id = #{id};")
    int completionPost(int id);

    @Update("""
            UPDATE posts SET content = #{post.content},updated_at = #{post.updated_at},deadline = #{post.deadline}
            WHERE id = #{post.id};
            """)
    int updatePost(@Param("post") PostEntity newEntity);


}
