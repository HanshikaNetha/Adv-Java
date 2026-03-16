package com.example.SecurityStudentManagmentSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String name;
    private String email;
    private String course;
    private double marks;
    private MultipartFile photo;
    private MultipartFile assignmentFile;
}
