package com.order.service.service;

import com.order.service.dto.OrderDTO;
import com.order.service.entity.Order;
import com.order.service.repository.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    private static final Logger logger = LogManager.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final WebClient webClient;
    OrderService(OrderRepository orderRepository, WebClient.Builder builder){
        this.orderRepository = orderRepository;
        this.webClient = builder.baseUrl("http://172.29.80.1:8182/api/").build();
    }

//    public Order createOrder(OrderDTO orderDTO) {
//        logger.info ("SRVICE Method:: executing createOrder:: {}", orderDTO.toString ());
//        webClient.post ()
//                .uri("/addProduct")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue (new Product(
//                        orderDTO.getId(),
//                        "Laptop",
//                        "Electronics",
//                        orderDTO.getQuantity(),
//                        123.45,
//                        new Suppliers ()
//                ))
//                .retrieve()
//                .bodyToMono(Product.class)
//                .block();
//
//        Order order = new Order();
//        return orderRepository.save(order);
//    }

    public Mono<Order> createOrder(OrderDTO orderDTO) {
        logger.info("SERVICE Method:: executing createOrder:: {}", orderDTO.toString());

        return webClient.post()
                .uri("/addProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new Product(
                        orderDTO.getId(),
                        "Laptop",
                        "Electronics",
                        orderDTO.getQuantity(),
                        123.45,
                        new Suppliers()
                ))
                .retrieve()
                .bodyToMono(Product.class)
                .flatMap(product -> {
                    Order order = new Order();
                    // Set order properties based on product or orderDTO
                    return Mono.just(orderRepository.save(order));
                });
    }

    public List<Order> getAllOrders() {
        logger.info ("Fetching all orders from the database");
        return orderRepository.findAll();
    }

    public Order updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
