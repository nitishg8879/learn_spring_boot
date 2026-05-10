package com.JPA.JPATest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "users")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "com.JPA.JPATest.entity.User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    // @JoinColumn(name = "company_id",referencedColumnName = "id")
    @JoinColumns({
        @JoinColumn(name = "name_id",referencedColumnName = "name"),
        @JoinColumn(name = "address_id",referencedColumnName = "address")
    })
    Company company;
}
