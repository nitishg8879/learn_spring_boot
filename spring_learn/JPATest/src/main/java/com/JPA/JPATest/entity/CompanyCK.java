package com.JPA.JPATest.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class CompanyCK implements Serializable{

    private String name;

    private String address;

    public CompanyCK(){

    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof CompanyCK)){
            return false;
        }
        CompanyCK companyCK = (CompanyCK) obj;
        return name.equals(companyCK.name) && address.equals(companyCK.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,address);
    }
}
