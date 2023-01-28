package com.caller.caller.controller;
import com.caller.caller.dto.Product;
import com.caller.caller.dto.User;
import com.caller.caller.service.ProductService;
import com.caller.caller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/caller")
public class CallerController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;



    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts(@RequestParam String email){

        User user=userService.getUser(email);

        if(user==null){
            return new ResponseEntity<>("There is no user with email"+email,HttpStatus.BAD_REQUEST);
        }
        else {
            if(userService.hasPrivilage(user,"READ-ONLY") ||
                    userService.hasPrivilage(user,"READ-AND-WRITE")){
                return productService.getAll();
            }
            return new ResponseEntity<>("you do not have the READ privilage",HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getProductById")
    public ResponseEntity<?> getProductById(@RequestParam String email,@RequestParam Long id ){

        User user=userService.getUser(email);
        if(user==null){
            return new ResponseEntity<>("There is no user with email"+email,HttpStatus.BAD_REQUEST);
        }
        else {
            if(userService.hasPrivilage(user,"READ-ONLY") ||
                    userService.hasPrivilage(user,"READ-AND-WRITE")){
                return productService.getById(id);
            }
            return new ResponseEntity<>("you do not have the READ privilage",HttpStatus.BAD_REQUEST);
        }
    }




    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody Product product,@RequestParam String email){
        User user=userService.getUser(email);
        if(user==null){
            return new ResponseEntity<>("There is no user with email"+email,HttpStatus.BAD_REQUEST);
        }
        else {
            if(userService.hasPrivilage(user,"READ-AND-WRITE")){
                return productService.save(product);
            }
            return new ResponseEntity<>("you do not have the READ-AND-WRITE privilage",HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteProductById")
    public ResponseEntity<?> deleteProduct(@RequestParam String email,@RequestParam Long id ){

        User user=userService.getUser(email);
        if(user==null){
            return new ResponseEntity<>("There is no user with email"+email,HttpStatus.BAD_REQUEST);
        }
        else {
            if(userService.hasPrivilage(user,"READ-AND-WRITE")){
                return productService.delete(id);
            }
            return new ResponseEntity<>("you do not have the READ-AND-WRITE privilage",HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/updateProduct")
    public ResponseEntity<?> deleteProduct(@RequestParam String email,@RequestBody Product product){

        User user=userService.getUser(email);
        if(user==null){
            return new ResponseEntity<>("There is no user with email"+email,HttpStatus.BAD_REQUEST);
        }
        else {
            if(userService.hasPrivilage(user,"READ-AND-WRITE")){
                return productService.update(product);
            }
            return new ResponseEntity<>("you do not have the READ-AND-WRITE privilage",HttpStatus.BAD_REQUEST);
        }
    }


}
