package com.JPA.JPATest.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.criteria.Order;

@Entity
public class UserDetails {
    @Id
    Long userId;

    // @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true)
    // @JoinColumn(name = "user_id",referencedColumnName = "id")
    // List<Order>  orders = new ArrayList<>();
    // it will create a column in the order entity for uni-directional

    @OneToMany(mappedBy = "user")
    List<Order> orders = new ArrayList<>();
}
