package com.dbhstudios.akdmia.service;

import com.dbhstudios.akdmia.entity.User;
import com.dbhstudios.akdmia.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public User save(String username, String email) {
        log.info("Username {}", username);
        User user = new User(username, email);
        return userRepository.save(user);
    }
}
