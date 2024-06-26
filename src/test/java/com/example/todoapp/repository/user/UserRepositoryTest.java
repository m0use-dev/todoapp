package com.example.todoapp.repository.user;

import com.example.todoapp.service.user.UserEntity;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("getUserAllメソッドの動作確認")
    public void getUserAllメソッドの動作確認() {
        List<UserEntity> users = userRepository.getUserAll();
        assertThat(users.size()).isEqualTo(4);
    }
}