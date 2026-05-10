package com.JPA.JPATest.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Orders {
    @Id
    Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id_owing_fk",referencedColumnName = "userId")
    UserDetails user;


    
}
