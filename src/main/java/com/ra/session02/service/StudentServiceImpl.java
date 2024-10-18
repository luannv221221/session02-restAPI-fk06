package com.ra.session02.service;

import com.ra.session02.model.dto.StudentResponseDTO;
import com.ra.session02.model.entity.Student;
import com.ra.session02.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<StudentResponseDTO> findAll() {
        // convert kiểu dữ liệu từ Entity ==> DTO
        List<Student> studentEntities = studentRepository.findAll();
        List<StudentResponseDTO> studentResponseDTOS = new ArrayList<>();
        for (Student studentEntity : studentEntities) {
           StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
           studentResponseDTO.setId(studentEntity.getId());
           studentResponseDTO.setFullName(studentEntity.getFullName());
           studentResponseDTO.setGender(studentEntity.isGender()?"Nam":"Nữ");
           studentResponseDTO.setAddress(studentEntity.getAddress());
           studentResponseDTOS.add(studentResponseDTO);
        }
        return studentResponseDTOS;
    }
}
