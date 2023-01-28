package com.caller.caller.service;

import com.caller.caller.dto.Privileges;
import com.caller.caller.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{

    @Value("${userService.url}")
    private String userServiceURL;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User getUser(String email) {
        try {
            User user=restTemplate.getForObject(userServiceURL+"?email="+email,User.class);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean hasPrivilage(User user, String privilage) {
        for (Privileges privileges : user.getPrivileges()) {
            if (privileges.getPrivilege().equalsIgnoreCase(privilage))  {
                return true;
            }
        }
        return false;
    }
}
