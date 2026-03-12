package com.example.SecurityStudentManagmentSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private String name;
    private String email;
    private String course;
    private double marks;
    private String role;
    private String profileImage;
    private String assignmentFile;
}
