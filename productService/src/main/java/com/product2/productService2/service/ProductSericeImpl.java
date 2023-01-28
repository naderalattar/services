package com.product2.productService2.service;

import com.product2.productService2.DAO.ProductRepo;
import com.product2.productService2.model.Product;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSericeImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;

    @Override
    public ResponseEntity<?> getAllProducts() {
        try {
            List<Product> products=productRepo.findAll();
            return new ResponseEntity<>(products,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        try {
            Product productFromDB=productRepo.findById(id).get();
            return new ResponseEntity<>(productFromDB,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> saveProduct(Product product) {
        try {
            Product savedProduct=productRepo.save(product);
            return new ResponseEntity<>(savedProduct,HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long id) {
        try {

            productRepo.deleteById(id);
            return new ResponseEntity<>("the product is deleted",HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> updateProduct(Product product) {
        try {
            Product savedProduct=productRepo.save(product);
            return new ResponseEntity<>(savedProduct,HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
