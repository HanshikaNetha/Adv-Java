package com.example.ResultService.client;

import com.example.ResultService.dto.StudentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STUDENT-SERVICE")
public interface StudentClient {
    @GetMapping("/api/students/getStudentById/{id}")
    public StudentResponse getStudent(@PathVariable("id") Long id);

}
