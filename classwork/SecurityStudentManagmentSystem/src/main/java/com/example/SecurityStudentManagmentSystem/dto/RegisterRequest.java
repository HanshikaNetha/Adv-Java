package com.example.SecurityStudentManagmentSystem.dto;

import com.example.SecurityStudentManagmentSystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
}
