package com.ra.session02.controller;

import com.ra.session02.model.dto.StudentResponseDTO;
import com.ra.session02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> index(){
        List<StudentResponseDTO> studentResponseDTOS = studentService.findAll();
        return new ResponseEntity<>(studentResponseDTOS, HttpStatus.OK);
    }
}
