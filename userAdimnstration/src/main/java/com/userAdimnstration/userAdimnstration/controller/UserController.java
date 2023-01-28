package com.userAdimnstration.userAdimnstration.controller;

import com.userAdimnstration.userAdimnstration.model.Privileges;
import com.userAdimnstration.userAdimnstration.model.User;
import com.userAdimnstration.userAdimnstration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getUserByEmail")
    public ResponseEntity<?> getByEmail(@RequestParam String email){
        return userService.getByEmail(email);
    }


    @PostMapping("/user")
    public ResponseEntity<?> save(@Valid @RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/user")
    public ResponseEntity<?> delete(@RequestParam Long id){
        return userService.delete(id);
    }

    @PutMapping("/user")
    public ResponseEntity<?> update(@Valid  @RequestBody User user){
        return userService.update(user);
    }
}
