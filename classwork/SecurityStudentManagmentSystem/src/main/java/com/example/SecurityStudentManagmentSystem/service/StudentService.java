package com.example.SecurityStudentManagmentSystem.service;

import com.example.SecurityStudentManagmentSystem.dto.PageResponse;
import com.example.SecurityStudentManagmentSystem.dto.StudentRequest;
import com.example.SecurityStudentManagmentSystem.dto.StudentResponse;
import com.example.SecurityStudentManagmentSystem.entity.Student;
import com.example.SecurityStudentManagmentSystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentResponse addStudent(StudentRequest studentRequest, MultipartFile photo, MultipartFile assignmentFile)throws IOException {
        Student student=modelMapper.map(studentRequest, Student.class);
        student.setProfileImage(photo.getBytes());
        student.setAssignmentFile(assignmentFile.getBytes());
        Student saveStudent=studentRepository.save(student);
        StudentResponse studentResponse=modelMapper.map(saveStudent, StudentResponse.class);
        return studentResponse;
    }

    public StudentResponse getStudentById(Long id) {
        Student student=studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
        StudentResponse studentResponse=modelMapper.map(student, StudentResponse.class);
        studentResponse.setProfileImage("/students/"+student.getId()+"/photo");
        studentResponse.setAssignmentFile("/students/"+student.getId()+"/assignment");
        return studentResponse;
    }

    @Cacheable(value="students", key = "#page + '_' + #size + '_' + #sortBy + '_' + #direction")
    public PageResponse<StudentResponse> getAllStudents(int page, int size, String sortBy, String direction){
        System.out.println("hui");
        Sort sorti=direction.equalsIgnoreCase("desc")?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
        Pageable pageable= PageRequest.of(page, size, sorti);
        Page<Student> students=studentRepository.findAll(pageable);
        List<StudentResponse> studentResponseList=students.getContent().stream().map(i->{
            StudentResponse st=modelMapper.map(i, StudentResponse.class);
            st.setProfileImage("/students/"+i.getId()+"/photo");
            st.setAssignmentFile("/students/"+i.getId()+"/assignment");
            return st;
        }).toList();
        return new PageResponse<>(studentResponseList, students.getNumber(), students.getSize(), students.getTotalElements(), students.getTotalPages());
    }

    public StudentResponse updateStudent(Long id, StudentRequest studentRequest, MultipartFile photo, MultipartFile assignmentFile)throws IOException{
        Student student=studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setCourse(studentRequest.getCourse());
        student.setMarks(studentRequest.getMarks());
        student.setProfileImage(photo.getBytes());
        student.setAssignmentFile(assignmentFile.getBytes());
        Student savedStudent=studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentResponse.class);
    }

    public StudentResponse deleteStudent(Long id){
        Student student=studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
        studentRepository.delete(student);
        StudentResponse studentResponse=modelMapper.map(student, StudentResponse.class);
        return studentResponse;
    }

    public byte[] getAssignemntFile(Long id){
        Student student=studentRepository.findById(id).orElseThrow(()->new RuntimeException("student not found"));
        return student.getAssignmentFile();
    }

    public byte[] getPhoto(Long id){
        Student student=studentRepository.findById(id).orElseThrow(()->new RuntimeException("student not found"));
        return student.getProfileImage();
    }
}
