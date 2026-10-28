package com.order.service.service;

import com.order.service.dto.OrderDTO;
import com.order.service.entity.Order;
import org.springframework.stereotype.Component;


@Component
public class OrderMapper {
    public static OrderDTO toDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getOrderDate (),
                order.getCustomerId (),
                order.getStatus(),
                order.getQuantity()
        );
    }

    public static Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setStatus(dto.getStatus());
        order.setQuantity (dto.getQuantity());
        return order;
    }
}

