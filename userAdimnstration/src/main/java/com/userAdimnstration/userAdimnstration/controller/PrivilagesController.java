package com.userAdimnstration.userAdimnstration.controller;

import com.userAdimnstration.userAdimnstration.model.Privileges;
import com.userAdimnstration.userAdimnstration.service.PrivilagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrivilagesController {

    @Autowired
    PrivilagesService privilagesService;

    @GetMapping("/privilage")
    public ResponseEntity<?> getAll(){
        return privilagesService.getAll();
    }

    @PostMapping("/privilage")
    public ResponseEntity<?> save(@RequestBody Privileges privileges){
        return privilagesService.save(privileges);
    }

    @DeleteMapping("/privilage")
    public ResponseEntity<?> delete(@RequestParam Integer id){
        return privilagesService.delete(id);
    }

    @PutMapping("/privilage")
    public ResponseEntity<?> update(@RequestBody Privileges privileges){
        return privilagesService.update(privileges);
    }
}
