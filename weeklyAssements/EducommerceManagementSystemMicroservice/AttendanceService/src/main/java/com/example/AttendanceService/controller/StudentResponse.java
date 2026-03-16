package com.example.AttendanceService.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private String studentName;
    private String email;
    private String department;
    private int semester;
    private LocalDate createdAt;
}
