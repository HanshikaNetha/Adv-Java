package com.example.ResultService.service;

import com.example.ResultService.client.AttendanceClient;
import com.example.ResultService.client.StudentClient;
import com.example.ResultService.dto.AttendanceResponse;
import com.example.ResultService.dto.ResultRequest;
import com.example.ResultService.dto.ResultResponse;
import com.example.ResultService.dto.StudentResponse;
import com.example.ResultService.entity.Result;
import com.example.ResultService.exception.AllException;
import com.example.ResultService.repository.ResultRespository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRespository resultRepository;
    private final ModelMapper modelMapper;
    private final StudentClient studentClient;
    private final AttendanceClient attendanceClient;

    public ResultResponse createResult(ResultRequest request){
        StudentResponse studentResponse=studentClient.getStudent(request.getStudentId());
        if(studentResponse==null){
            throw new AllException("Student doesnt exist");
        }
        List<AttendanceResponse> attendanceResponseList=attendanceClient.getAttendance(request.getStudentId());
        if(attendanceResponseList.isEmpty()){
            throw new AllException("Student has no attendence record");
        }

        Result result = new Result();
        result.setStudentId(request.getStudentId());
        result.setCourseId(request.getCourseId());
        result.setExamType(request.getExamType());
        result.setMarksObtained(request.getMarksObtained());
        result.setMaxMarks(request.getMaxMarks());
        result.setGrade(request.getGrade());
        Result saved = resultRepository.save(result);
        ResultResponse resultResponse=modelMapper.map(saved, ResultResponse.class);
        return resultResponse;
    }

    public List<ResultResponse> getResultsByStudent(Long studentId){
        List<Result> results=resultRepository.findByStudentId(studentId);
        List<ResultResponse> resultResponses=results.stream().map(i->modelMapper.map(i, ResultResponse.class)).toList();
        return resultResponses;
    }

    public List<ResultResponse> getResultsByCourse(Long courseId){
        List<Result> results=resultRepository.findByCourseId(courseId);
        List<ResultResponse> resultResponses=results.stream().map(i->modelMapper.map(i, ResultResponse.class)).toList();
        return resultResponses;
    }

    public ResultResponse updateResult(Long id, ResultRequest request){
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new AllException("Result not found"));
        result.setStudentId(request.getStudentId());
        result.setCourseId(request.getCourseId());
        result.setExamType(request.getExamType());
        result.setMarksObtained(request.getMarksObtained());
        result.setMaxMarks(request.getMaxMarks());
        result.setGrade(request.getGrade());
        Result updated = resultRepository.save(result);
        ResultResponse resultResponse=modelMapper.map(updated, ResultResponse.class);
        return resultResponse;
    }

    public ResultResponse deleteResult(Long id){
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new AllException("Result not found"));
        resultRepository.delete(result);
        ResultResponse resultResponse=modelMapper.map(result, ResultResponse.class);
        return resultResponse;

    }
}
