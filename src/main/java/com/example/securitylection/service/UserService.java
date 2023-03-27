package com.example.securitylection.service;

import com.example.securitylection.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> getAllUsers();


}
