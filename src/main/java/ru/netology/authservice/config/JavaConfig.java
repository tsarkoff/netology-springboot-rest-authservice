package ru.netology.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.authservice.controller.AuthorizationController;
import ru.netology.authservice.repository.UserRepository;
import ru.netology.authservice.service.AuthorizationService;

@Configuration
public class JavaConfig {

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService();
    }

    @Bean
    public AuthorizationController authorizationController() {
        return new AuthorizationController();
    }
}