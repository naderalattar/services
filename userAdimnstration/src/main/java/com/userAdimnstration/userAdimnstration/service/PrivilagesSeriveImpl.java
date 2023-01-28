package com.userAdimnstration.userAdimnstration.service;

import com.userAdimnstration.userAdimnstration.dao.PrivilageRepo;
import com.userAdimnstration.userAdimnstration.model.Privileges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilagesSeriveImpl implements PrivilagesService{

    @Autowired
    PrivilageRepo  privilageRepo;
    @Override
    public ResponseEntity<?> save(Privileges privileges) {
        try {
            Privileges  savedPrivileges=privilageRepo.save(privileges);
            return new ResponseEntity<>(savedPrivileges,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getAll() {
        try {
            List<Privileges>  privilegesList=privilageRepo.findAll();
            return new ResponseEntity<>(privilegesList,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        try {
            privilageRepo.deleteById(id);
            return new ResponseEntity<>("the privilage is deleted",HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> update(Privileges privileges) {
        try {

            Privileges savedPrivileges=privilageRepo.save(privileges);
            return new ResponseEntity<>(savedPrivileges,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
