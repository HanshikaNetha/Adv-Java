package com.example.SecurityStudentManagmentSystem.controller;


import com.example.SecurityStudentManagmentSystem.dto.PageResponse;
import com.example.SecurityStudentManagmentSystem.dto.StudentRequest;
import com.example.SecurityStudentManagmentSystem.dto.StudentResponse;
import com.example.SecurityStudentManagmentSystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {
    public final StudentService studentService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/addStudent", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addStudent(@ModelAttribute StudentRequest studentRequest) throws IOException {
        StudentResponse studentResponse=studentService.addStudent(studentRequest, studentRequest.getPhoto(), studentRequest.getAssignmentFile());
        return ResponseEntity.ok().body(studentResponse.getName()+" is added");
    }

    @PreAuthorize("hasAnyRole('ADMIN','STUDENT')")
    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable("id") Long id){
        StudentResponse studentResponse=studentService.getStudentById(id);
        return ResponseEntity.ok(studentResponse);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllStudents")
    public ResponseEntity<PageResponse<StudentResponse>> getAllStudents(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size, @RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "asc")String direction){
        PageResponse<StudentResponse> studentPage=studentService.getAllStudents(page, size, sortBy, direction);
        return ResponseEntity.ok(studentPage);
    }

    @PreAuthorize("hasAnyRole('ADMIN','STUDENT')")
    @PostMapping(value = "/updateStudent/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateStudent(@PathVariable("id")Long id,@ModelAttribute StudentRequest studentRequest)throws IOException{
        StudentResponse studentResponse=studentService.updateStudent(id, studentRequest, studentRequest.getPhoto(), studentRequest.getAssignmentFile());
        return ResponseEntity.ok().body(studentResponse.getName()+" is updated");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        StudentResponse studentResponse=studentService.deleteStudent(id);
        return ResponseEntity.ok().body(studentResponse.getName()+" is deleted");
    }

    @GetMapping("/{id}/assignment")
    public ResponseEntity<ByteArrayResource> fetchAssignemnt(@PathVariable("id") Long id){
        ByteArrayResource assignemntFile=new ByteArrayResource(studentService.getAssignemntFile(id));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(assignemntFile);
    }

    @GetMapping("/{id}/photo")
    public ResponseEntity<ByteArrayResource> fetchPhoto(@PathVariable("id") Long id){
        ByteArrayResource photo=new ByteArrayResource(studentService.getPhoto(id));
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(photo);
    }

}
