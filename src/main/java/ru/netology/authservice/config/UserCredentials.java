package ru.netology.authservice.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Annotation is to add to "AuthorizationController.getAuthorities(@UserCredentials User)" method
// to apply Agr Resolving from Strings (username / password) to User Object
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserCredentials {
}