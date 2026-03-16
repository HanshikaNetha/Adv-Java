package com.example.StudentService.service;

import com.example.StudentService.dto.LoginRequest;
import com.example.StudentService.dto.LoginResponse;
import com.example.StudentService.dto.StudentRegisterRequest;
import com.example.StudentService.dto.StudentRegisterResponse;
import com.example.StudentService.entity.Student;
import com.example.StudentService.exception.AllException;
import com.example.StudentService.repository.StudentRepository;
import com.example.StudentService.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public StudentRegisterResponse registerStudent(StudentRegisterRequest studentRegisterRequest){
        if(studentRepository.findByEmail(studentRegisterRequest.getEmail()).isPresent()){
            throw new AllException("Email already registered");
        }
        Student student=new Student();
        student.setStudentName(studentRegisterRequest.getStudentName());
        student.setDepartment(studentRegisterRequest.getDepartment());
        student.setEmail(studentRegisterRequest.getEmail());
        student.setPassword(passwordEncoder.encode(studentRegisterRequest.getPassword()));
        student.setSemester(studentRegisterRequest.getSemester());
        student.setCreatedAt(LocalDate.now());
        Student savedStudent=studentRepository.save(student);
        StudentRegisterResponse studentRegisterResponse=modelMapper.map(savedStudent, StudentRegisterResponse.class);
        return studentRegisterResponse;
    }

    public LoginResponse login(LoginRequest loginRequest){
        Student student=studentRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()->new AllException("email not exist, register before login"));
        if(!passwordEncoder.matches(loginRequest.getPassword(), student.getPassword())){
            throw new AllException("Invalid password");
        }
        String token=jwtUtil.generateToken(student.getEmail());
        return new LoginResponse(token, student.getStudentId().toString(), student.getEmail());
    }
}
