package com.example.AttendanceService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendenceRequest {
    private Long studentId;
    private Long courseId;
    private LocalDate date;
    private String status;
}
