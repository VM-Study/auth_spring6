package com.example.securitylection.controller;

import com.example.securitylection.service.UserService;
import com.example.securitylection.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1.0/registration")
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    // @Autowired
    // public RegistrationController(UserService userService) {
    //     this.userService = userService;
    // }

    @PostMapping("/")
    public String signUpUser(@RequestBody User user) {
        userService.save(user);
        return "OK";
    }

    @GetMapping("/")
    public List<User> getAllUsersNoAuth() {
        System.out.println("RegistrationController: getAllUsersNoAuth");
        return userService.getAllUsers();
    }
}
