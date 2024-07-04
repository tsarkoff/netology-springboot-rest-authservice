package ru.netology.authservice.repository;

import java.util.List;
import java.util.Optional;

public class UserRepository {

    private static final List<User> users = List.of(
            new User("Vlad", "multiPass", List.of(Authorities.READ)),
            new User("Ivan", "suPass", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)
            ));

    public List<Authorities> getUserAuthorities(User user) {
        Optional<User> lookupUser = users.stream()
                .filter(u -> u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()))
                .findFirst();
        return lookupUser.isPresent() ? lookupUser.get().getAuthorities() : List.of();
    }

}