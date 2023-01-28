package com.userAdimnstration.userAdimnstration.dao;

import com.userAdimnstration.userAdimnstration.model.Privileges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilageRepo extends JpaRepository<Privileges,Integer> {
}
