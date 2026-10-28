package com.product.service.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public DataLoader (ProductRepository productRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void run (String... args) {
        // Seed roles if not present
        if (supplierRepository.count () == 0) {
            System.out.println ("Saving...");
            Suppliers suppliers = new Suppliers ();
            suppliers.setCity ("Mumbai");
            suppliers.setName ("Raj");
            suppliers.setAddress ("Lalpath Chowk, 123H, Dadar(W)");
            suppliers.setCountry ("India");
            suppliers.setPhone ("944863127");
            supplierRepository.save (suppliers);

            Product product1 = new Product ();
            product1.setName ("Laptop");
            product1.setCategory ("Electronics");
            product1.setQuantity (7500);
            product1.setUnitPrice (12345.86);
            product1.setSupplier (suppliers);

            Product product2 = new Product ();
            product2.setName ("Mobile");
            product2.setCategory ("Electronics");
            product2.setQuantity (7500);
            product2.setUnitPrice (12345.86);
            product2.setSupplier (suppliers);

            Product product3 = new Product ();
            product3.setName ("Pencils");
            product3.setCategory ("Electronics");
            product3.setQuantity (7500);
            product3.setUnitPrice (12345.86);
            product3.setSupplier (suppliers);

            Product product4 = new Product ();
            product4.setName ("Mouse");
            product4.setCategory ("Electronics");
            product4.setQuantity (7500);
            product4.setUnitPrice (12345.86);
            product4.setSupplier (suppliers);

            Product product5 = new Product ();
            product5.setName ("JoyStick");
            product5.setCategory ("Electronics");
            product5.setQuantity (7500);
            product5.setUnitPrice (12345.86);
            product5.setSupplier (suppliers);

            Product product6 = new Product ();
            product6.setName ("Keypad");
            product6.setCategory ("Electronics");
            product6.setQuantity (7500);
            product6.setUnitPrice (12345.86);
            product6.setSupplier (suppliers);

            Product product7 = new Product ();
            product7.setName ("Head phone");
            product7.setCategory ("Electronics");
            product7.setQuantity (7500);
            product7.setUnitPrice (12345.86);
            product7.setSupplier (suppliers);

            Product product8 = new Product ();
            product8.setName ("blue tooth");
            product8.setCategory ("Electronics");
            product8.setQuantity (7500);
            product8.setUnitPrice (12345.86);
            product8.setSupplier (suppliers);


            Product product9 = new Product ();
            product9.setName ("Battery");
            product9.setCategory ("Electronics");
            product9.setQuantity (7500);
            product9.setUnitPrice (12345.86);
            product9.setSupplier (suppliers);

            Product product10 = new Product ();
            product10.setName ("Charger");
            product10.setCategory ("Electronics");
            product10.setQuantity (7500);
            product10.setUnitPrice (12345.86);
            product10.setSupplier (suppliers);

            productRepository.saveAll (Arrays.asList (product1, product2, product3, product4, product5, product6, product7, product8, product9, product10));

        }
    }
}

