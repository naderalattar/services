package com.caller.caller.service;

import com.caller.caller.dto.Privileges;
import com.caller.caller.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService{

    @Value("${productService.url}")
    private String productServiceURL;


    @Value("${privilageService.url}")
    private String privilageServiceURL;


    @Autowired
    private RestTemplate restTemplate;


    @Override
    public ResponseEntity<?> getAll() {
        try {
            ResponseEntity<Product[]> response = restTemplate.getForEntity(productServiceURL, Product[].class);
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        try {
            Product product = restTemplate.getForObject(productServiceURL+"/"+id, Product.class);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> save(Product product) {
        try {
            HttpEntity<Product> request = new HttpEntity<>(product);
            Product savedProduct = restTemplate.postForObject(productServiceURL, request, Product.class);
            return new ResponseEntity<>(savedProduct,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        try {
            restTemplate.delete(productServiceURL+"?id="+id);
            return new ResponseEntity<>("The product is deleted",HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity update(Product product) {
        try {
            HttpEntity<Product> request = new HttpEntity<>(product);
            ResponseEntity<Product> response = restTemplate
                    .exchange(productServiceURL, HttpMethod.PUT, request, Product.class);
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
