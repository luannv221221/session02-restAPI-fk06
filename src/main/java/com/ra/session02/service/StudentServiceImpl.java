package com.ra.session02.service;

import com.ra.session02.model.dto.StudentRequestDTO;
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

    @Override
    public StudentResponseDTO create(StudentRequestDTO studentRequestDTO) {
        // convert DTO -> Entity
        Student student = Student.builder().
                fullName(studentRequestDTO.getFullName())
                .gender(studentRequestDTO.isGender())
                .address(studentRequestDTO.getAddress())
                .build();
        Student studentNew = studentRepository.save(student);
        // convert Entity --> DTO
        return StudentResponseDTO
                .builder().id(studentNew.getId())
                .fullName(studentNew.getFullName())
                .address(studentNew.getAddress())
                .gender(studentNew.isGender() ? "Nam" : "Nữ")
                .build();
    }

    @Override
    public StudentResponseDTO findById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        // convert
        if(student!=null){
            StudentResponseDTO studentResponseDTO = StudentResponseDTO
                    .builder()
                    .id(student.getId())
                    .fullName(student.getFullName())
                    .address(student.getAddress())
                    .gender(student.isGender() ? "Nam" : "Nu")
                    .build();
            return studentResponseDTO;
        }
        return null;
    }
}
