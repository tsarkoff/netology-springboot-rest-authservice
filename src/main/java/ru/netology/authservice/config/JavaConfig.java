package ru.netology.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.authservice.repository.UserRepository;
import ru.netology.authservice.service.AuthorizationService;

@Configuration
public class JavaConfig {
    private UserRepository userRepository;

    @Bean
    public UserRepository userRepository() {
        userRepository = new UserRepository();
        return userRepository;
    }

    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService(userRepository);
    }
}