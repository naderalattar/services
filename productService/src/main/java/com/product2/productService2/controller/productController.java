package com.product2.productService2.controller;

import com.product2.productService2.model.Product;
import com.product2.productService2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class productController {


    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<?> getAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return productService.getById(id);
    }


    @PostMapping("/product")
    public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product){
        return productService.saveProduct(product);
    }


    @DeleteMapping("/product")
    public ResponseEntity<?> deleteProduct(@RequestParam Long id){
        return productService.deleteProduct(id);
    }


    @PutMapping("/product")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }


}
