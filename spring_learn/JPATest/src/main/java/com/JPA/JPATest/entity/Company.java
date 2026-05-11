package com.JPA.JPATest.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.OneToOne;

@Entity
// @IdClass(CompanyCK.class)
public class Company {

    // @Id
    // private String name;

    // @Id
    // private String address;

    @EmbeddedId
    CompanyCK id;


    @OneToOne(mappedBy = "company")
    User user;


}
