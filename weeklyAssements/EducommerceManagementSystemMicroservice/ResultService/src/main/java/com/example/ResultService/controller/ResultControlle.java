package com.example.ResultService.controller;

import com.example.ResultService.dto.ResultRequest;
import com.example.ResultService.dto.ResultResponse;
import com.example.ResultService.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/results")
public class ResultControlle {
    private final ResultService resultService;

    @PostMapping("/createResult")
    public ResponseEntity<String> createResult(@RequestBody ResultRequest resultRequest){
        ResultResponse resultResponse=resultService.createResult(resultRequest);
        return ResponseEntity.ok().body("Result added for student " + resultResponse.getStudentId());
    }
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ResultResponse>> getResultByStudentId(@PathVariable("studentId") Long id){
        List<ResultResponse> resultResponses=resultService.getResultsByStudent(id);
        return ResponseEntity.ok(resultResponses);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<ResultResponse>> getResultByCourse(@PathVariable("courseId") Long id){
        List<ResultResponse> resultResponses=resultService.getResultsByCourse(id);
        return ResponseEntity.ok(resultResponses);
    }

    @PutMapping("/updateResult/{id}")
    public ResponseEntity<String> updateResult(@PathVariable("id") Long id, @RequestBody ResultRequest request){
        ResultResponse response = resultService.updateResult(id, request);
        return ResponseEntity.ok("Result updated for student " + response.getStudentId());
    }

    @DeleteMapping("/deleteResult/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable("id") Long id){
        ResultResponse resultResponse=resultService.deleteResult(id);
        return ResponseEntity.ok().body("result is deleted for "+resultResponse.getStudentId());
    }

}
