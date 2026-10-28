package com.order.service.controller;


import com.order.service.dto.OrderDTO;
import com.order.service.service.OrderMapper;
import com.order.service.service.OrderService;
import com.order.service.service.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Order {

    private static final Logger logger = LogManager.getLogger(Order.class);

    private final OrderService orderService;

    Order(OrderService orderService){
        this.orderService = orderService;
    }

//    @PostMapping
//    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO order) {
//        OrderDTO orderRes = OrderMapper.toDTO(orderService.createOrder(order));
//        return ResponseEntity.ok(orderRes);
//    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getOrders() {
        logger.info ("Fetching all orders from the database");
        List<OrderDTO> list = new ArrayList<> ();
        list.add (OrderMapper.toDTO(orderService.getAllOrders().get(0)));
        return ResponseEntity.ok(list);
    }

//    @PutMapping("/{id}/status")
//    public ResponseEntity<OrderDTO> updateStatus(@PathVariable Long id, @RequestParam String status) {
//        return ResponseEntity.ok(orderService.updateOrderStatus(id, status));
//    }

    @PostMapping("/createOrder")
    public Mono<com.order.service.entity.Order> getProd(@RequestBody OrderDTO orderDTO){
        logger.info ("Entering create order:: {}", orderDTO.toString ());
        logger.debug ("Debugging create order:: {}", orderDTO.toString ());
        return orderService.createOrder (orderDTO);
    }
}
