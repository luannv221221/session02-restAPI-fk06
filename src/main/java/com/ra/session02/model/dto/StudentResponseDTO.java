package com.ra.session02.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentResponseDTO {
    private Long id;
    private String fullName;
    private String gender;
    private String address;
}
