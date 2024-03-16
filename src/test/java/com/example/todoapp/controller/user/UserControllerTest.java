package com.example.todoapp.controller.user;

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

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class UserControllerTest {
    @Test
    @DisplayName("未ログインがログインページにアクセス可能確認")
    void 未ログインがログインページにアクセス可能確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/user/login"))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }
    @WithMockUser(roles="USER")
    @Test
    @DisplayName("ユーザー権限がログインページにアクセス不可確認")
    void ユーザー権限がログインページにアクセス不可確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/user/login"))
                .andExpect(MockMvcResultMatchers.status().isForbidden()
                );
    }
}