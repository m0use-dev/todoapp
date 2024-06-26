package com.example.todoapp.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
public class ToDoAppControllerTest {

    @Test
    @DisplayName("トップページにアクセスできることを確認")
    void トップページにアクセスできることを確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                        MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }

}



