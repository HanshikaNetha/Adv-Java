package com.example.StudentService.controller;

import com.example.StudentService.dto.LoginRequest;
import com.example.StudentService.dto.LoginResponse;
import com.example.StudentService.dto.StudentRegisterRequest;
import com.example.StudentService.dto.StudentRegisterResponse;
import com.example.StudentService.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/registerStudent")
    public ResponseEntity<String> registerStudent(@RequestBody StudentRegisterRequest studentRegisterRequest){
        StudentRegisterResponse studentRegisterResponse=authService.registerStudent(studentRegisterRequest);
        return ResponseEntity.ok().body(studentRegisterResponse.getStudentName()+" is registered");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse st=authService.login(loginRequest);
        return ResponseEntity.ok().body(st);
    }

}
