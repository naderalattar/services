package com.userAdimnstration.userAdimnstration.service;

import com.userAdimnstration.userAdimnstration.model.Privileges;
import org.springframework.http.ResponseEntity;

public interface PrivilagesService {

    public ResponseEntity<?> save(Privileges privileges);
    public ResponseEntity<?> getAll();

    public ResponseEntity<?> delete(Integer integer);
    public ResponseEntity<?> update(Privileges privileges);

}
