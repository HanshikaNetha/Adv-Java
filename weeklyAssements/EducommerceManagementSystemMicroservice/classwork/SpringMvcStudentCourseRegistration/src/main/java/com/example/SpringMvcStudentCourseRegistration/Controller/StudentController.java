package com.example.SpringMvcStudentCourseRegistration.Controller;

import com.example.SpringMvcStudentCourseRegistration.Entity.Student;
import com.example.SpringMvcStudentCourseRegistration.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service){
        this.service=service;
    }
    @GetMapping("/register")
    public String showForm(Model model){
        model.addAttribute("student", new Student());
        return "register";
    }
    @PostMapping("/register")
    public String saveStudent(@ModelAttribute Student student, Model model){
        service.saveStudent(student);
        model.addAttribute("message", "Student Regsitred successfully");
        model.addAttribute("total", service.getTotalStudents());
        return "success";
    }
    @GetMapping("/students")
    public String getAllStudents(Model model){
        model.addAttribute("students", service.getAllstudents());
        return "students";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        service.deleteStudent(id);
        return "redirect:/students";
    }

}
