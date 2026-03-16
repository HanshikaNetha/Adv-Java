package com.example.AttendanceService.controller;

import com.example.AttendanceService.dto.AttendenceRequest;
import com.example.AttendanceService.dto.AttendenceResponse;
import com.example.AttendanceService.service.AttendenceSErvice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attendance")
public class AttendenceController {
    private final AttendenceSErvice attendenceSErvice;

    @PostMapping("/markAttendance")
    public ResponseEntity<String> markAttendance(@RequestBody AttendenceRequest attendenceRequest){
        AttendenceResponse attendenceResponse=attendenceSErvice.markAttendence(attendenceRequest);
        return ResponseEntity.ok().body("attendance is marked for "+attendenceResponse.getStudentId());
    }
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AttendenceResponse>> getAttendanceByStudentId(@PathVariable("studentId") Long id){
        List<AttendenceResponse> attendanceResponses=attendenceSErvice.getAttedenceByStudent(id);
        return ResponseEntity.ok(attendanceResponses);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<AttendenceResponse>> getAttendanceNyCourse(@PathVariable("courseId") Long id){
        List<AttendenceResponse> attendanceResponses=attendenceSErvice.getAttendenceByCourse(id);
        return ResponseEntity.ok(attendanceResponses);
    }

    @PutMapping("/updateAttendance/{id}")
    public ResponseEntity<String> updateAttendance(@PathVariable("id") Long id, @RequestBody AttendenceRequest attendenceRequest){
        AttendenceResponse attendenceResponse=attendenceSErvice.updateAttendence(id, attendenceRequest);
        return ResponseEntity.ok().body("attendance is updated for "+attendenceResponse.getStudentId());
    }

    @DeleteMapping("/deleteAttendance/{id}")
    public ResponseEntity<String> deleteAttendance(@PathVariable("id") Long id){
        AttendenceResponse attendenceResponse=attendenceSErvice.deletAttendce(id);
        return ResponseEntity.ok().body("attendance is deleted for "+attendenceResponse.getStudentId());
    }
}
