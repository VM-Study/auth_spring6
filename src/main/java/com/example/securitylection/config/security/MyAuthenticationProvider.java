package com.example.securitylection.config.security;

import com.example.securitylection.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.util.List;

public class MyAuthenticationProvider implements AuthenticationProvider, Serializable {

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Проверяем, есть ли пользователь в базе данных
        User user = getUserByUsername(username);
        if (user == null) {
            throw new BadCredentialsException("User not found");
        }

        // Проверяем правильность пароля
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }

        // Создаем аутентификационный токен для аутентификации пользователя
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    private User getUserByUsername(String username) {
        // Код для получения пользователя из базы данных
        return null;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

}
