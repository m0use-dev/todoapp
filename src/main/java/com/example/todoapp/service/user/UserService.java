package com.example.todoapp.service.user;

import com.example.todoapp.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> getUserAll() {
        return userRepository.getUserAll();
    }
}
