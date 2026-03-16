package com.example.StudentService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegisterResponse {
    private String studentName;
    private String email;
    private String department;
    private int semester;
    private LocalDate createdAt;

}
