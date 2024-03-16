package com.example.todoapp.controller.post;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class PostControllerTest {


    @Test
    @DisplayName("未ログインが記事一覧ページにアクセスしたさいにログインページにリダイレクト確認")
    void 未ログインが記事一覧ページにアクセスしたさいにログインページにリダイレクト確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/post"))
                .andExpect(MockMvcResultMatchers.status().isFound()
                );
    }
    @WithMockUser(roles="USER")
    @Test
    @DisplayName("ユーザー権限が記事一覧ページにアクセス可能確認")
    void ユーザー権限が記事一覧ページにアクセス可能確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/post"))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }

    @WithMockUser("user1")
    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("記事一覧ページの記事リストmodelの動作確認")
    void 記事一覧ページの記事リストmodelの動作確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/post"))
                 .andExpect(status().isOk())
                 .andExpect(model().attributeExists("postList"));
    }
}
