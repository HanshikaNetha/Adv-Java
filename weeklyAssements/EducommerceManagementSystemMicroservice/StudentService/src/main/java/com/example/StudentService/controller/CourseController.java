package com.example.StudentService.controller;

import com.example.StudentService.dto.CourseRequest;
import com.example.StudentService.dto.CourseResponse;
import com.example.StudentService.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody CourseRequest courseRequest){
        CourseResponse courseResponse=courseService.addCourse(courseRequest);
        return ResponseEntity.ok().body(courseResponse.getCourseName()+" is added");
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<CourseResponse>> getAllCourses(){
        List<CourseResponse> courseResponseList=courseService.getAllCourses();
        return ResponseEntity.ok(courseResponseList);
    }

    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") Long id, @RequestBody CourseRequest courseRequest){
        CourseResponse courseResponse=courseService.updateCourse(id, courseRequest);
        return ResponseEntity.ok(courseResponse.getCourseName()+" is updated");
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        CourseResponse courseResponse=courseService.deleteCourse(id);
        return ResponseEntity.ok().body(courseResponse.getCourseName()+" is deleteed");
    }


}
