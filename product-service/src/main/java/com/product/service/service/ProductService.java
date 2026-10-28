package com.product.service.service;

import com.product.service.controller.ProductController;
import com.product.service.dto.ProductDTO;
import com.product.service.repository.Product;
import com.product.service.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final Logger logger = LogManager.getLogger(ProductService.class);
    ProductRepository productRepository;

    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public List<ProductDTO> getProducts(){
        logger.info ("Fetching all products from the database");
        return productRepository.findAll().stream ().map (ProductMapper::toDTO).toList ();
    }
}
