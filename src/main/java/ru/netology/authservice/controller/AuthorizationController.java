package ru.netology.authservice.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authservice.config.UserCredentials;
import ru.netology.authservice.repository.Authorities;
import ru.netology.authservice.repository.User;
import ru.netology.authservice.service.AuthorizationService;

import java.util.List;

@AllArgsConstructor
@RestController
@Validated
public class AuthorizationController {
    private final AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@UserCredentials @Valid User user) {
        return service.getAuthorities(user);
    }
}
