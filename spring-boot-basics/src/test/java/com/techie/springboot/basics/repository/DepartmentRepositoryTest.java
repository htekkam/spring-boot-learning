package com.techie.springboot.basics.repository;

import com.techie.springboot.basics.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;


    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        //.departmentId(1l)
                        .departmentName("chemical")
                        .departmentAddress("hyderabad")
                        .departmentCode("chemical")
                        .build();

        testEntityManager.persist(department);
    }

    @Test
    public void shouldFindDepartmentByName(){
        Department result = repository.findByDepartmentName("chemical");

        assertEquals("chemical", result.getDepartmentName());

    }
}