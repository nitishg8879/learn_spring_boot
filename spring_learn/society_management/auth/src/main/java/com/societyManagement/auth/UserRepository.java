package com.societyManagement.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    java.util.Optional<UserEntity> findByUsername(String username);

}
