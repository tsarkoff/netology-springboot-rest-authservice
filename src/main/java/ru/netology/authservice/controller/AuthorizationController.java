package ru.netology.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authservice.repository.Authorities;
import ru.netology.authservice.repository.User;
import ru.netology.authservice.service.AuthorizationService;

import java.util.List;

@Configuration(enforceUniqueMethods = false)
@RestController
public class AuthorizationController {
    @Autowired
    private AuthorizationService service;

    @GetMapping("/authorize")
    @ConditionalOnProperty(name = "netology.custom-handler", havingValue = "true")
    @Bean
    public List<Authorities> getAuthorities(/*@Validated */User user) {
        return service.getAuthorities(user);
    }

    @ConditionalOnProperty(name = "netology.custom-handler", havingValue = "false")
    @Bean
    public List<Authorities> getAuthorities(@RequestParam("username") String username, @RequestParam("password") String password) {
        return service.getAuthorities(username, password);
    }
}
