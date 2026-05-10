package com.JPA.JPATest.service;

import org.springframework.data.jpa.domain.Specification;

import com.JPA.JPATest.entity.UserDetails;

public class UserSpecification {
    public static Specification<UserDetails> equalsPhone(String phoneNo){
        return (root,query,cb) ->{
            return cb.equal(root.get("phone"), phoneNo);
        };
    }
}
