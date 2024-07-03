package ru.netology.authservice.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    @AllArgsConstructor
    @Data
    private static class User {
        private String username;
        private String password;
        private List<Authorities> authorities;
    }

    private static final List<User> users = List.of(
            new User("Vlad", "multiPass", List.of(Authorities.READ)),
            new User("Ivan", "suPass", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)
            ));

    public List<Authorities> getUserAuthorities(String user, String password) {
        Optional<User> lookupUser = users.stream()
                .filter(u -> u.getUsername().equals(user) && u.getPassword().equals(password))
                .findFirst();
        return lookupUser.isPresent() ? lookupUser.get().getAuthorities() : List.of();
    }

}