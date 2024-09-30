package com.dbhstudios.akdmia.service;

import com.dbhstudios.akdmia.entity.User;
import com.dbhstudios.akdmia.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDomainService {

    private final UserRepository userRepository;

    public User createUser(String username, String email) {

        if( userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }

        return new User(username, email);
    }
}
