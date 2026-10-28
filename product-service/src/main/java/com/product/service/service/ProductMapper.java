package com.product.service.service;

import com.product.service.dto.ProductDTO;
import com.product.service.repository.Product;
import com.product.service.repository.Suppliers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Supplier;

@Component
public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        System.out.println("ProductDTO---1");
        return new ProductDTO(
                product.getId(),
                product.getName (),
                product.getQuantity (),
                product.getUnitPrice (),
                product.getSupplier ()
        );
    }

    public static Product toEntity(ProductDTO dto) {
        return new Product (
            dto.getId(),
            dto.getName (),
            "Electronics",
            dto.getQuantity (),
            dto.getUnitPrice (),
            dto.getSuppliers ()
        );
    }
}

