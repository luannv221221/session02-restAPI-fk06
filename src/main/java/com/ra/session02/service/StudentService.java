package com.ra.session02.service;

import com.ra.session02.model.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> findAll();
}
