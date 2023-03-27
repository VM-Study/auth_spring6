package com.example.securitylection.config;

import com.example.securitylection.repository.UserRepository;
import com.example.securitylection.service.CustomUserDetailService;
import com.example.securitylection.service.CustomUserDetailServiceImpl;
import com.example.securitylection.service.UserService;
import com.example.securitylection.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    // private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;
    //
    // public AppConfig(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    //     this.userRepository = userRepository;
    //     this.passwordEncoder = passwordEncoder;
    // }

    // @Bean
    // public CustomUserDetailService customUserDetailService(){
    //     return new CustomUserDetailServiceImpl(userRepository);
    // }
    //
    // @Bean
    // public UserService userService(){
    //     return new UserServiceImpl(userRepository, passwordEncoder);
    // }

}
