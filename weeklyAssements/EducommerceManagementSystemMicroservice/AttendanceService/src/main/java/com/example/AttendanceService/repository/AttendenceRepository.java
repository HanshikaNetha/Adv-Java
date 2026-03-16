package com.example.AttendanceService.repository;

import com.example.AttendanceService.entity.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendence, Long> {
    List<Attendence> findByStudentId(Long studentId);

    List<Attendence> findByCourseId(Long courseId);
}
