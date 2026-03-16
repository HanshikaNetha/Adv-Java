package com.example.StudentService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponse {
    private Long enrollmentId;

    private long studentId;
    private String studentName;

    private long courseId;
    private String courseName;

    private LocalDate enrollementDate;
}
