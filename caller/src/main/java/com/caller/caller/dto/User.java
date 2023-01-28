package com.caller.caller.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements Serializable {

    private Long id;

    private String email;


    private String fullName;

    private String password;


    private List<Privileges> privileges;

    public User(){}

    public User(Long id, String email, String fullName, String password, List<Privileges> privileges) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.privileges = privileges;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Privileges> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privileges> privileges) {
        this.privileges = privileges;
    }
}
