package com.techie.spring.data.jpa.tutorial.repository;

import com.techie.spring.data.jpa.tutorial.entity.Course;
import com.techie.spring.data.jpa.tutorial.entity.CourseMaterial;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("java")
                .credit(5)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("javatpoint.com")
                .build();

        courseMaterialRepository.save(courseMaterial);

    }

    @Test
    public void getAllCourseMaterials(){
        log.info("testing getAllCourseMaterials");
        courseMaterialRepository.findAll()
                .stream()
                .forEach(System.out::println);

    }


}