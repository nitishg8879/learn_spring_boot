package com.AOP.aopTest.JPA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AOP.aopTest.JPA.entity.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Long> {
    
}
