package com.techie.springboot.basics.controller;

import com.techie.springboot.basics.entity.Department;
import com.techie.springboot.basics.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp(){

        department = Department.builder()
                .departmentId(10l)
                .departmentName("ece")
                .departmentAddress("hyderabad")
                .departmentCode("ece-2005").build();
    }

    @Test
    void saveDepartment() {
    }

    @Test
    void getDepartmentById() {
    }
}