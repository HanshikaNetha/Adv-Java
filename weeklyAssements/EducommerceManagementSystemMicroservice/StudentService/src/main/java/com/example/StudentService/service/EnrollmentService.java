package com.example.StudentService.service;

import com.example.StudentService.dto.EnrollmentRequest;
import com.example.StudentService.dto.EnrollmentResponse;
import com.example.StudentService.entity.Course;
import com.example.StudentService.entity.Enrollment;
import com.example.StudentService.entity.Student;
import com.example.StudentService.exception.AllException;
import com.example.StudentService.repository.CourseRepository;
import com.example.StudentService.repository.EnrollmentRepository;
import com.example.StudentService.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public EnrollmentResponse enrollStudent(EnrollmentRequest enrollmentRequest){
        Student student=studentRepository.findById(enrollmentRequest.getStudentId()).orElseThrow(()->new AllException("Student not found"));
        Course course=courseRepository.findById(enrollmentRequest.getCourseId()).orElseThrow(()->new AllException("course not found"));
        Enrollment enrollment=new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollementDate(LocalDate.now());
        Enrollment savedEnrollment=enrollmentRepository.save(enrollment);
        return convertToResponse(savedEnrollment);
    }
    public List<EnrollmentResponse> getCourseByStudent(Long studentId){
        List<Enrollment> enrollments=enrollmentRepository.findByStudentStudentId(studentId);
        List<EnrollmentResponse> enrollmentResponses=enrollments.stream().map(i->convertToResponse(i)).toList();
        return enrollmentResponses;
    }


    public EnrollmentResponse convertToResponse(Enrollment enrollment){
        return new EnrollmentResponse(
        enrollment.getEnrollmentId(),
        enrollment.getStudent().getStudentId(),
        enrollment.getStudent().getStudentName(),
        enrollment.getCourse().getCourseId(),
        enrollment.getCourse().getCourseName(),
        enrollment.getEnrollementDate()
        );
    }
}
