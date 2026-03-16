package com.example.StudentService.controller;

import com.example.StudentService.dto.StudentRegisterRequest;
import com.example.StudentService.dto.StudentRegisterResponse;
import com.example.StudentService.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentRegisterResponse>> getAllStudents(){
        List<StudentRegisterResponse> studentRegisterResponseList=studentService.getAllStudents();
        return ResponseEntity.ok(studentRegisterResponseList);
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<StudentRegisterResponse> getStudentById(@PathVariable("id") Long id){
        StudentRegisterResponse studentRegisterResponse=studentService.getStudentById(id);
        return ResponseEntity.ok(studentRegisterResponse);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") Long id, @RequestBody StudentRegisterRequest studentRegisterRequest){
        StudentRegisterResponse studentRegisterResponse=studentService.updateStudent(id, studentRegisterRequest);
        return ResponseEntity.ok().body(studentRegisterResponse.getStudentName()+" is updated");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        StudentRegisterResponse studentRegisterResponse=studentService.deleteStudent(id);
        return ResponseEntity.ok().body(studentRegisterResponse.getStudentName()+" is deleted");
    }
}
