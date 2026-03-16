package com.example.BookSecurity.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private  String token;
    private String username;
    private String role;

}
