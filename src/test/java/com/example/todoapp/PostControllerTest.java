package com.example.todoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {


    @Test
    void 未ログインが記事一覧ページにアクセスしたさいにログインページにリダイレクト確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/post"))
                .andExpect(MockMvcResultMatchers.status().isFound()
                );
    }
    @WithMockUser(roles="USER")
    @Test
    void ユーザー権限が記事一覧ページにアクセス可能確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/post"))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }
}
