package com.dbhstudios.akdmia.persistence.jpa;

import com.dbhstudios.akdmia.entity.User;
import com.dbhstudios.akdmia.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DbUserRepository implements UserRepository {

    private UserSpringJpaRepository userSpringJpaRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity = userSpringJpaRepository.save(new UserEntity(user.getUsername(),user.getEmail()));
        return userEntity.toObject();
    }

    @Override
    public User update(User user) {
        UserEntity userEntity = userSpringJpaRepository.findByEmail(user.getEmail());
        userEntity.setUsername(user.getUsername());
        userSpringJpaRepository.save(userEntity);
        return userEntity.toObject();
    }

    @Override
    public void delete(User user) {
        UserEntity userEntity = userSpringJpaRepository.findByEmail(user.getEmail());
        userSpringJpaRepository.delete(userEntity);
    }

    @Override
    public User findById(long id) {
        return userSpringJpaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        ).toObject();

    }

    @Override
    public boolean existsByEmail(String email) {
        return null != userSpringJpaRepository.findByEmail(email);
    }
}
