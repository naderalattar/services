package com.caller.caller.dto;

import java.io.Serializable;

public class Privileges implements Serializable {

    private Integer id;


    private String privilege;

    public Privileges(){}

    public Privileges(Integer id, String privilege) {
        this.id = id;
        this.privilege = privilege;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
}
