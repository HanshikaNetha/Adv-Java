package com.example.SpringMvcStudentCourseRegistration.Repository;

import com.example.SpringMvcStudentCourseRegistration.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
