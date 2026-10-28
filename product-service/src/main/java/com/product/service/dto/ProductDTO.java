package com.product.service.dto;

import com.product.service.repository.Suppliers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private double quantity;
    private double unitPrice;
    private Suppliers suppliers;

    @Override
    public String toString () {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", suppliers=" + suppliers +
                '}';
    }
}
