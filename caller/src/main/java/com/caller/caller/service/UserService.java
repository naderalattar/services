package com.caller.caller.service;

import com.caller.caller.dto.User;

public interface UserService {
    public User getUser(String email);

    public boolean hasPrivilage(User user,String privilage);
}
