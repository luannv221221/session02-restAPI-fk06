package com.ra.session02.controller;

import com.ra.session02.model.dto.DataError;
import com.ra.session02.model.dto.StudentRequestDTO;
import com.ra.session02.model.dto.StudentResponseDTO;
import com.ra.session02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<StudentResponseDTO> create(@RequestBody StudentRequestDTO studentRequestDTO){
        StudentResponseDTO studentResponseDTO = studentService.create(studentRequestDTO);
        return new ResponseEntity<>(studentResponseDTO,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        StudentResponseDTO studentResponseDTO = studentService.findById(id);
        if(studentResponseDTO!=null){
            return new ResponseEntity<>(studentResponseDTO,HttpStatus.OK);
        }
        return new ResponseEntity<>(new DataError("Không tìm thấy"),HttpStatus.NOT_FOUND);
    }

}
