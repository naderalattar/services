package com.userAdimnstration.userAdimnstration.service;

import com.userAdimnstration.userAdimnstration.dao.PrivilageRepo;
import com.userAdimnstration.userAdimnstration.dao.UserRepo;
import com.userAdimnstration.userAdimnstration.model.Privileges;
import com.userAdimnstration.userAdimnstration.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    PrivilageRepo privilageRepo;
    @Override
    public ResponseEntity<?> save(User user) {
        try {

            List<Integer> privilagesIds=user.getPrivilagesIds();
            Set<Privileges> privilegesSet=new HashSet<>();
            for (Integer id:privilagesIds){
               Privileges savedPrivileges =privilageRepo.findById(id).get();
               privilegesSet.add(savedPrivileges);
            }
            user.setPrivileges(privilegesSet);

            User savedUser=userRepo.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getAll() {
        try {
            List<User> users =userRepo.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getByEmail(String email) {
        try {
            User user =userRepo.findByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        try {
            userRepo.deleteById(id);
            return new ResponseEntity<>("the user is deleted", HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> update(User user) {
        try {

           User userFromDB= userRepo.findById(user.getId()).get();
           userFromDB.setEmail(user.getEmail());
           userFromDB.setPassword(user.getPassword());
           userFromDB.setFullName(user.getFullName());

            if(user.getPrivilagesIds()!=null){
                List<Integer> privilagesIds=user.getPrivilagesIds();
                Set<Privileges> privilegesSet=new HashSet<>();
                for (Integer id:privilagesIds){
                    Privileges savedPrivileges =privilageRepo.findById(id).get();
                    privilegesSet.add(savedPrivileges);
                }
                userFromDB.setPrivileges(privilegesSet);
            }
            User savedUser=userRepo.save(userFromDB);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
