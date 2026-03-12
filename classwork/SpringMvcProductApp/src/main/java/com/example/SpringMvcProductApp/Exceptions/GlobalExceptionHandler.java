package com.example.SpringMvcProductApp.Exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleGlobalException(Exception ex, Model model){
        model.addAttribute("errorMessage", "something was wrong: "+ex.getMessage());
        return "error-page";
    }
}
