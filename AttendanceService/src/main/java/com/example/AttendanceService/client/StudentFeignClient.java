package com.example.AttendanceService.client;

import com.example.AttendanceService.controller.StudentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STUDENT-SERVICE")
public interface StudentFeignClient {
    @GetMapping("/api/students/getStudentById/{id}")
    public StudentResponse getStudentById(@PathVariable("id") Long id);
}
