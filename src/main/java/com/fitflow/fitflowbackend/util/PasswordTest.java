package com.fitflow.fitflowbackend.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "123456"; // La contraseña que querés probar
        String encrypted = "$2a$10$T7SraRU0DwTTJ2ZqzF1lOeHLaYXRJ9Fo59ZmJS1PgkWvHyWpdFE9e"; // Hash de la BD

        boolean match = encoder.matches(rawPassword, encrypted);
        System.out.println("¿Coincide?: " + match);
    }
}
