package com.order.service.service;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
public class Product implements Serializable {

    public Product () {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "stock_quantity")
    private double quantity;

    @Column(name = "unit_price")
    private double unitPrice;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "supplier_id")
    private Suppliers supplier;

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Product product = (Product) o;
        return Double.compare (quantity, product.quantity) == 0 && Double.compare (unitPrice, product.unitPrice) == 0 && Objects.equals (id, product.id) && Objects.equals (name, product.name) && Objects.equals (category, product.category) ;
    }

    @Override
    public int hashCode () {
        return Objects.hash (id, name, category, quantity, unitPrice);
    }
}
