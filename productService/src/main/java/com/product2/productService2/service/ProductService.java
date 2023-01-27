package com.product2.productService2.service;

import com.product2.productService2.model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {

    public ResponseEntity<?>  getAllProducts();

    public ResponseEntity<?> getById(Long id);
    public ResponseEntity<?>  saveProduct(Product product);
    public ResponseEntity<?> deleteProduct(Long id);
    public ResponseEntity<?> updateProduct(Product product);
}
