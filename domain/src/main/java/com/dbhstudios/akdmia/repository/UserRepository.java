package com.dbhstudios.akdmia.repository;

import com.dbhstudios.akdmia.entity.User;

public interface UserRepository {

    User save(User user);
    User update(User user);
    void delete(User user);
    User findById(long id);

    boolean existsByEmail(String email);
}
