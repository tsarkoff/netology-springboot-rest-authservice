package ru.netology.authservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<>(
                "InvalidCredentials Exception in AuthorizationService.getAuthorities() method.\n Exception message: "
                        + e.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        return new ResponseEntity<>(
                "UnauthorizedUser Exception in AuthorizationService.getAuthorities() method.\n Exception message: "
                        + e.getMessage(),
                HttpStatus.UNAUTHORIZED);
    }
}
