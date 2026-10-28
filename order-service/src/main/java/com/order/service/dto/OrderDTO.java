package com.order.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class OrderDTO {

    private Long id;

    private Date orderDate;

    private Long customerId;

    private String status;

    private int quantity;

    @Override
    public String toString () {
        return "OrderDTO{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", customerId=" + customerId +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
