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
        return getAuthorities(user.getUsername(), user.getPassword());
    }

    public List<Authorities> getAuthorities(String username, String password) {
        if (isEmpty(username) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(username, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + username);
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
