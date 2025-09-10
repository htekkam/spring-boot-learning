package com.techie.spring.data.jpa.tutorial.repository;

import com.techie.spring.data.jpa.tutorial.entity.Course;
import com.techie.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherEntity(){

        Course java = Course.builder()
                .title("core-java")
                .credit(5)
                .build();
        Course mysql = Course.builder()
                .title("mysql")
                .credit(4)
                .build();
        Course javascript = Course.builder()
                .title("javascript")
                .credit(3)
                .build();

        Teacher teacherEntity = Teacher.builder()
                .firstName("hari")
                .lastName("krishna")
                //.courses(List.of(java,mysql,javascript))
                .build();
        teacherRepository.save(teacherEntity);

    }

}