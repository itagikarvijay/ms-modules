package com.order.service.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "quantity")
    private int quantity;

    private String status; // e.g., PENDING, COMPLETED
}
