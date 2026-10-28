package com.order.service.service;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="suppliers")
@Getter
@Setter
@AllArgsConstructor
public class Suppliers implements Serializable {

    public Suppliers (){ }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="supplier_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="city")
    private String city;

    @Column(name="contact_name")
    private String contactName;

    @Column(name="phone")
    private String phone;

    @Column(name="country")
    private String country;

    @Column(name = "address")
    private String address;

    // Bi-directional: One Supplier → Many Products
//    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonBackReference
//    private List<Product> products = new ArrayList<> ();

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Suppliers suppliers = (Suppliers) o;
        return Objects.equals (id, suppliers.id) && Objects.equals (name, suppliers.name) && Objects.equals (city, suppliers.city) && Objects.equals (contactName, suppliers.contactName) && Objects.equals (phone, suppliers.phone) && Objects.equals (country, suppliers.country) && Objects.equals (address, suppliers.address) ;
    }

    @Override
    public int hashCode () {
        return Objects.hash (id, name, city, contactName, phone, country, address);
    }
}
