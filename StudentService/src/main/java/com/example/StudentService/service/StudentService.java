package com.example.StudentService.service;

import com.example.StudentService.dto.StudentRegisterRequest;
import com.example.StudentService.dto.StudentRegisterResponse;
import com.example.StudentService.entity.Student;
import com.example.StudentService.exception.AllException;
import com.example.StudentService.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public List<StudentRegisterResponse> getAllStudents(){
        List<Student> studentList=studentRepository.findAll();
        List<StudentRegisterResponse> studentRegisterResponseList=studentList.stream().map(i->modelMapper.map(i, StudentRegisterResponse.class)).toList();
        return studentRegisterResponseList;
    }

    public StudentRegisterResponse getStudentById(Long id){
        Student student=studentRepository.findById(id).orElseThrow(()->new AllException("Student not found"));
        StudentRegisterResponse studentRegisterResponse=modelMapper.map(student, StudentRegisterResponse.class);
        return studentRegisterResponse;
    }

    public StudentRegisterResponse updateStudent(Long id, StudentRegisterRequest studentRegisterRequest){
        Student student=studentRepository.findById(id).orElseThrow(()->new AllException("Student not found"));
        student.setStudentName(studentRegisterRequest.getStudentName());
        student.setEmail(studentRegisterRequest.getEmail());
        student.setSemester(studentRegisterRequest.getSemester());
        student.setPassword(passwordEncoder.encode(studentRegisterRequest.getPassword()));
        student.setDepartment(studentRegisterRequest.getDepartment());
        studentRepository.save(student);
        StudentRegisterResponse studentRegisterResponse=modelMapper.map(student, StudentRegisterResponse.class);
        return studentRegisterResponse;
    }

    public StudentRegisterResponse deleteStudent(Long id){
        Student student=studentRepository.findById(id).orElseThrow(()->new AllException("student not found"));
        studentRepository.delete(student);
        return modelMapper.map(student, StudentRegisterResponse.class);
    }
}
