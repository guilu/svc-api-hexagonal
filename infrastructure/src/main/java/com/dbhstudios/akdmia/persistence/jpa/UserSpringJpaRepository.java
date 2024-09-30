package com.dbhstudios.akdmia.persistence.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSpringJpaRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(String username);
}
