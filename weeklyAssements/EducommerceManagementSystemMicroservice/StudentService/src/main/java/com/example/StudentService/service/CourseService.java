package com.example.StudentService.service;

import com.example.StudentService.dto.CourseRequest;
import com.example.StudentService.dto.CourseResponse;
import com.example.StudentService.entity.Course;
import com.example.StudentService.exception.AllException;
import com.example.StudentService.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public CourseResponse addCourse(CourseRequest courseRequest){
        Course course=modelMapper.map(courseRequest, Course.class);
        Course savedCourse=courseRepository.save(course);
        CourseResponse courseResponse=modelMapper.map(savedCourse, CourseResponse.class);
        return courseResponse;
    }

    public List<CourseResponse> getAllCourses(){
        List<Course> courses=courseRepository.findAll();
        List<CourseResponse> courseResponseList=courses.stream().map(i->modelMapper.map(i, CourseResponse.class)).toList();
        return courseResponseList;
    }

    public CourseResponse updateCourse(Long id, CourseRequest courseRequest){
        Course course=courseRepository.findById(id).orElseThrow(()->new AllException("Course not found"));
        course.setCourseCode(courseRequest.getCourseCode());
        course.setCourseName(courseRequest.getCourseName());
        course.setInstructor(courseRequest.getInstructor());
        course.setCredits(courseRequest.getCredits());
        courseRepository.save(course);
        CourseResponse courseResponse=modelMapper.map(course, CourseResponse.class);
        return courseResponse;
    }

    public CourseResponse deleteCourse(Long id){
        Course course=courseRepository.findById(id).orElseThrow(()->new AllException("course not found"));
        courseRepository.delete(course);
        return modelMapper.map(course, CourseResponse.class);
    }
}
