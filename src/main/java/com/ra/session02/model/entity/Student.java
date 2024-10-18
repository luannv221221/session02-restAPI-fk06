package com.ra.session02.model.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fullName",length = 100)
    private String fullName;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "address")
    private String address;
}
