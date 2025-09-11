package com.techie.springboot.basics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;

    @NotBlank(message = "please enter the department name")
    @Size(max = 15, min = 1)
//    @Positive
//    @PositiveOrZero
//    @Future
//    @Past
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
