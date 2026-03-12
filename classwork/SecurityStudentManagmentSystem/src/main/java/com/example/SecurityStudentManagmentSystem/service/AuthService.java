package com.example.SecurityStudentManagmentSystem.service;

import com.example.SecurityStudentManagmentSystem.dto.AuthResponse;
import com.example.SecurityStudentManagmentSystem.dto.LoginRequest;
import com.example.SecurityStudentManagmentSystem.dto.RegisterRequest;
import com.example.SecurityStudentManagmentSystem.entity.User;
import com.example.SecurityStudentManagmentSystem.repository.UserRepository;
import com.example.SecurityStudentManagmentSystem.security.JwtUtil;
import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public String registerUser(RegisterRequest registerRequest){
        User user=new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
//        user.setPassword(registerRequest.getPassword());
        user.setRole(registerRequest.getRole());
        userRepository.save(user);
        return user.getUsername()+" is registered successfully";

    }

    public AuthResponse LoginUser(LoginRequest loginRequest){
        User user=userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(()->new RuntimeException("user not found"));

//        if(!loginRequest.getPassword().equals(user.getPassword())){
//            throw new RuntimeException("Invalid credintials");
//        }
        if(!passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid Credentials");
        }
        String token= jwtUtil.generateToken(user.getUsername(), user.getRole().name());
        return new AuthResponse(token, user.getUsername(), user.getRole().name());
//        return "login succesfull";

    }
}
