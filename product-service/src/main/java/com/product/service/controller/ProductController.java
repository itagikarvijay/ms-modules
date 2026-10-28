package com.product.service.controller;

import com.product.service.dto.ProductDTO;
import com.product.service.repository.Product;
import com.product.service.repository.ProductRepository;
import com.product.service.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    ProductService productService;

    ProductRepository productRepository;

    ProductController(ProductService productService, ProductRepository productRepository){
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/me")
    public Map<String, Object> me(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
                "sub", jwt.getSubject()
//                "email", jwt.getClaim("email"),
//                "roles", jwt.getClaim("roles")
        );
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProducts(){
        logger.info ("Fetching all products");

        return ResponseEntity.ok (productService.getProducts ());
    }


    // GET product by ID (this is what OrderService calls)
    @GetMapping("/p/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product productDTO) {
        logger.info ("Adding product: {} " ,productDTO);
        Product product = new Product(
                productDTO.getId(),
                productDTO.getName(),
                "Electronics",
                productDTO.getQuantity(),
                productDTO.getUnitPrice(),
                productDTO.getSupplier ()
        );
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }
}
