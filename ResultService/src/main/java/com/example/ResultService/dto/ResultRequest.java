package com.example.ResultService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultRequest {
    private Long studentId;
    private Long courseId;
    private String examType;
    private Double marksObtained;
    private Double maxMarks;
    private String grade;
}
