package com.example.SpringMvcStudentCourseRegistration.Service;

import com.example.SpringMvcStudentCourseRegistration.Entity.Student;
import com.example.SpringMvcStudentCourseRegistration.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository repository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.repository=studentRepository;
    }
    @Override
    public void saveStudent(Student student){
        repository.save(student);
    }
    @Override
    public List<Student> getAllstudents(){
        return repository.findAll();
    }
    @Override
    public Student getStudentById(Long id){
        return repository.findById(id).orElse(null);
    }
    @Override
    public void deleteStudent(Long id){
        repository.deleteById(id);
    }
    @Override
    public long getTotalStudents(){
        return repository.count();
    }
}
