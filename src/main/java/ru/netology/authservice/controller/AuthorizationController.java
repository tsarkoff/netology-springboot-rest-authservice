package ru.netology.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authservice.repository.Authorities;
import ru.netology.authservice.repository.User;
import ru.netology.authservice.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Validated User user) {
        return service.getAuthorities(user);
    }
}
