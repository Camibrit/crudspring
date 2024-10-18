package com.projetofeh.projetofeh.controllers;


import com.projetofeh.projetofeh.domain.Product;
import com.projetofeh.projetofeh.domain.ProductRepository;
import com.projetofeh.projetofeh.domain.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")

public class ProductController{

@Autowired
private ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProducts(){
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity registerProducts(@RequestBody @Validated RequestProduct data){
        Product newProduct = new Product(data);
        repository.save(newProduct);
        System.out.println(data);
        return ResponseEntity.ok().build();
    }
}
