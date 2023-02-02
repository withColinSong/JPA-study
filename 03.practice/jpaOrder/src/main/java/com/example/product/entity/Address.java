package com.example.product.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Embeddable
public class Address {

    private String city;
    private String street;
    private int zipCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return zipCode == address.zipCode && Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipCode);
    }

    protected Address() { }

    @Builder
    public Address(String city, String street, int zipCode) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }
}
