package com.example.StudentService.controller;

import com.example.StudentService.dto.EnrollmentRequest;
import com.example.StudentService.dto.EnrollmentResponse;
import com.example.StudentService.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollStudent(@RequestBody EnrollmentRequest enrollmentRequest){
        EnrollmentResponse enrollmentResponse=enrollmentService.enrollStudent(enrollmentRequest);
        return ResponseEntity.ok().body(enrollmentResponse.getEnrollmentId()+" is enrolled");
    }

    @GetMapping("/students/{id}/courses")
    public ResponseEntity<List<EnrollmentResponse>> getStudentCourse(@PathVariable("id") Long id){
        List<EnrollmentResponse> enrollmentResponses=enrollmentService.getCourseByStudent(id);
        return ResponseEntity.ok(enrollmentResponses);
    }
}
