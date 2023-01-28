package com.userAdimnstration.userAdimnstration.service;

import com.userAdimnstration.userAdimnstration.model.Privileges;
import com.userAdimnstration.userAdimnstration.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<?> save(User user);
    public ResponseEntity<?> getAll();

    public ResponseEntity<?> getByEmail(String email);

    public ResponseEntity<?> delete(Long id);
    public ResponseEntity<?> update(User user);
}
