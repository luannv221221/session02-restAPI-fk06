package com.ra.session02.service;

import com.ra.session02.model.dto.StudentRequestDTO;
import com.ra.session02.model.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> findAll();
    StudentResponseDTO create(StudentRequestDTO studentRequestDTO);
    StudentResponseDTO findById(Long id);
}
