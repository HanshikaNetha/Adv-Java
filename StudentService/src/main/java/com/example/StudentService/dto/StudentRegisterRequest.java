package com.example.StudentService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegisterRequest {
    private String studentName;
    private String email;
    private String password;
    private String department;
    private int semester;
}
