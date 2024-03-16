package com.example.todoapp.controller.admin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {
    @WithMockUser(roles="ADMIN")
    @Test
    @DisplayName("管理者権限が管理者用ページにアクセス可能確認")
    void 管理者権限が管理者用ページにアクセス可能確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/admin"))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }

    @WithMockUser(roles="USER")
    @Test
    @DisplayName("ユーザー権限が管理者用ページにアクセス不可確認")
    void ユーザー権限が管理者用ページにアクセス不可確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/admin"))
                .andExpect(MockMvcResultMatchers.status().isForbidden()
                );
    }

    @WithMockUser(roles="ADMIN")
    @Test
    @DisplayName("管理者権限が管理者用投稿一覧ページにアクセス可能確認")
    void 管理者権限が管理者用投稿一覧ページにアクセス可能確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/admin/posts"))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }

    @WithMockUser(roles="USER")
    @Test
    @DisplayName("ユーザー権限が管理者用投稿一覧ページにアクセス不可確認")
    void ユーザー権限が管理者用投稿一覧ページにアクセス不可確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/admin/posts"))
                .andExpect(MockMvcResultMatchers.status().isForbidden()
                );
    }

    @WithMockUser(roles="ADMIN")
    @Test
    @DisplayName("管理者権限が管理者用ユーザー一覧ページにアクセス可能確認")
    void 管理者権限が管理者用ユーザー一覧ページにアクセス可能確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/admin/users"))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }

    @WithMockUser(roles="USER")
    @Test
    @DisplayName("ユーザー権限が管理者用ユーザー一覧ページにアクセス不可確認")
    void ユーザー権限が管理者用ユーザー一覧ページにアクセス不可確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/admin/users"))
                .andExpect(MockMvcResultMatchers.status().isForbidden()
                );
    }
}
