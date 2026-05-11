package com.JPA.JPATest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    Long id;

    String name;

    
}
