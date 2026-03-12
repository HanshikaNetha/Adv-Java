package com.example.SpringMvcStudentCourseRegistration.Service;

import com.example.SpringMvcStudentCourseRegistration.Entity.Student;

import java.util.List;

public interface StudentService {
    public void saveStudent(Student student);
    public List<Student> getAllstudents();
    public Student getStudentById(Long id);
    public void deleteStudent(Long id);
    long getTotalStudents();
}
