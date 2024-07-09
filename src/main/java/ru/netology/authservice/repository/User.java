package ru.netology.authservice.repository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class User {

    @NotBlank
    @Size(min = 2, max = 32)
    private final String username;

    @NotBlank
    @Size(min = 2, max = 256)
    private final String password;

    private List<Authorities> authorities;
}
