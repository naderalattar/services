package com.caller.caller.service;

import com.caller.caller.dto.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface ProductService {

    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getById(Long id);

    public ResponseEntity<?> save(Product product);
    public ResponseEntity<?> delete(Long id);

    public ResponseEntity update(Product product);



}
