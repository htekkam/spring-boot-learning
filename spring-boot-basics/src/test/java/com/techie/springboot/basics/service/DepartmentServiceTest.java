package com.techie.springboot.basics.service;

import com.techie.springboot.basics.entity.Department;
import com.techie.springboot.basics.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockitoBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department =
                Department.builder()
                        .departmentId(1L)
                        .departmentName("eee")
                        .departmentAddress("Hyderabad")
                        .departmentCode("eee-2005").build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("eee"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get data by validating the department")
    void getDepartmentByName() {

        String departmentName = "eee";
        Department eeeDepartment =
                departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, eeeDepartment.getDepartmentName());
    }
}