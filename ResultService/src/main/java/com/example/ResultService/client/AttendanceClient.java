package com.example.ResultService.client;

import com.example.ResultService.dto.AttendanceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ATTENDANCE-SERIVCE")
public interface AttendanceClient {
    @GetMapping("/api/attendance/student/{studentId}")
    public List<AttendanceResponse> getAttendance(@PathVariable("studentId")Long studentId);
}
