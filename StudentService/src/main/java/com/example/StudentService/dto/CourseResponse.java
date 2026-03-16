package com.example.StudentService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {
    private Long courseId;
    private String courseName;
    private String courseCode;
    private String instructor;
    private int credits;
}
