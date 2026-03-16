package com.example.AttendanceService.service;

import com.example.AttendanceService.client.StudentFeignClient;
import com.example.AttendanceService.controller.StudentResponse;
import com.example.AttendanceService.dto.AttendenceRequest;
import com.example.AttendanceService.dto.AttendenceResponse;
import com.example.AttendanceService.entity.Attendence;
import com.example.AttendanceService.exception.AllException;
import com.example.AttendanceService.repository.AttendenceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendenceSErvice {
    private final AttendenceRepository attendenceRepository;
    private final ModelMapper modelMapper;
    private final StudentFeignClient studentFeignClient;

    public AttendenceResponse markAttendence(AttendenceRequest attendenceRequest){
        StudentResponse studentResponse=studentFeignClient.getStudentById(attendenceRequest.getStudentId());
        if(studentResponse==null){
            throw new AllException("Student doesnt not exist");
        }
        Attendence attendence = new Attendence();
        attendence.setStudentId(attendenceRequest.getStudentId());
        attendence.setCourseId(attendenceRequest.getCourseId());
        attendence.setDate(attendenceRequest.getDate());
        attendence.setStatus(attendenceRequest.getStatus());
        Attendence savedAttendence=attendenceRepository.save(attendence);
        AttendenceResponse ate =modelMapper.map(savedAttendence,AttendenceResponse.class);
        return ate;
    }
    public List<AttendenceResponse> getAttedenceByStudent(Long studentId){
        List<Attendence> attendences=attendenceRepository.findByStudentId(studentId);
        List<AttendenceResponse> attendenceResponses=attendences.stream().map(i->modelMapper.map(i, AttendenceResponse.class)).toList();
        return attendenceResponses;
    }

    public List<AttendenceResponse> getAttendenceByCourse(Long courseId){
        List<Attendence> attendences=attendenceRepository.findByCourseId(courseId);
        List<AttendenceResponse> attendenceResponses=attendences.stream().map(i->modelMapper.map(i, AttendenceResponse.class)).toList();
        return attendenceResponses;
    }

    public AttendenceResponse updateAttendence(Long id, AttendenceRequest attendenceRequest){
        Attendence attendence=attendenceRepository.findById(id).orElseThrow(()->new AllException("Attendce not found"));
        attendence.setStudentId(attendenceRequest.getStudentId());
        attendence.setCourseId(attendenceRequest.getCourseId());
        attendence.setDate(attendenceRequest.getDate());
        attendence.setStatus(attendenceRequest.getStatus());
        Attendence upadeted=attendenceRepository.save(attendence);
        AttendenceResponse ate=modelMapper.map(upadeted, AttendenceResponse.class);
        return ate;
    }

    public AttendenceResponse deletAttendce(Long id){
        Attendence attendence=attendenceRepository.findById(id).orElseThrow(()->new AllException("Attendence not found"));
        attendenceRepository.delete(attendence);
        AttendenceResponse attendenceResponse=modelMapper.map(attendence, AttendenceResponse.class);
        return attendenceResponse;
    }
}

