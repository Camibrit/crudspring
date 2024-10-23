package com.projetofeh.projetofeh.controllers;


import com.projetofeh.projetofeh.domain.Product;
import com.projetofeh.projetofeh.repository.ProductRepository;
import com.projetofeh.projetofeh.domain.RequestProduct;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")

public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProducts() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity CreateProduct(@RequestBody @Valid RequestProduct data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok("deu certo");
    }


    @PutMapping("/product/{id}")
    @Transactional
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody @Valid RequestProduct data) {
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice(data.price());
            repository.save(product);
            return ResponseEntity.ok(product);
        } else {
            throw new EntityNotFoundException();
        }
    }
        @DeleteMapping("/product/{id}")
        @Transactional
        public ResponseEntity deleteProduct(@PathVariable String id){
            Optional<Product> optionalProduct = repository.findById(id);
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                product.setActive(false);
                return ResponseEntity.noContent().build();
            } else {
                throw new EntityNotFoundException();
            }
        }

    }

