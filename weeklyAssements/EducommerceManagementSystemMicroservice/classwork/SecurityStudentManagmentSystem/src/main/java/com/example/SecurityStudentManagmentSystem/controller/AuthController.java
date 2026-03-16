package com.example.SecurityStudentManagmentSystem.controller;

import com.example.SecurityStudentManagmentSystem.dto.AuthResponse;
import com.example.SecurityStudentManagmentSystem.dto.LoginRequest;
import com.example.SecurityStudentManagmentSystem.dto.RegisterRequest;
import com.example.SecurityStudentManagmentSystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest){
        String st=authService.registerUser(registerRequest);
        return ResponseEntity.ok(st);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        AuthResponse st=authService.LoginUser(loginRequest);
//        String st=authService.LoginUser(loginRequest);
        return ResponseEntity.ok(st);
    }
}
