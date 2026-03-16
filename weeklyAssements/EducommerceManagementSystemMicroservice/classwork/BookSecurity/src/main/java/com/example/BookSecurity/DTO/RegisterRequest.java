package com.example.BookSecurity.DTO;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RegisterRequest {
    private final String username;
    private final  String password;
    private final String role;
}
