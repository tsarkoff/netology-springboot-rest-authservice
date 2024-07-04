package ru.netology.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.authservice.exception.InvalidCredentials;
import ru.netology.authservice.exception.UnauthorizedUser;
import ru.netology.authservice.repository.Authorities;
import ru.netology.authservice.repository.User;
import ru.netology.authservice.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUsername()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUsername(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUsername());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
