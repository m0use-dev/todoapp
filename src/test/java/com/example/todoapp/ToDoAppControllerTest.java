package com.example.todoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class ToDoAppControllerTest {

    @Test
    void トップページにアクセスできることを確認(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk()
                );
    }

}



