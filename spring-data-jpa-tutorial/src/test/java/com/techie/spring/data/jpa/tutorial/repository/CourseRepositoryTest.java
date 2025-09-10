package com.techie.spring.data.jpa.tutorial.repository;

import com.techie.spring.data.jpa.tutorial.entity.Course;
import com.techie.spring.data.jpa.tutorial.entity.Student;
import com.techie.spring.data.jpa.tutorial.entity.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getAllCourses(){
        log.info("testing");
        courseRepository.findAll()
                .stream()
                .forEach(System.out::println);

    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("srinivas")
                .lastName("rao")
                .build();

        Course course = Course.builder()
                .title("science")
                .credit(4)
                .teacher(teacher).build();

        courseRepository.save(course);
    }

    @Test
    public void findAllWithPagenation(){

        log.info(" findAllWithPagenation ");
        Pageable firstPageWithTwoRecords =
                PageRequest.of(1,2);
        List<Course> courseListFromPageOne =
                courseRepository.findAll(firstPageWithTwoRecords)
                        .getContent();
        log.info("courseListFromPageOne");
        System.out.println(courseListFromPageOne);
    }

    @Test
    public void findAllWithPagingAndSorting(){
        log.info("findAllWithPagingAndSorting");
        Pageable page = PageRequest.of(1,
                3,
                Sort.by("title"));

        List<Course> courseListWithSorting =
                courseRepository.findAll(page).getContent();

        System.out.println("courseListWithSorting::"+courseListWithSorting);

    }

    @Test
    public void findByTitleContaining(){
        Pageable page = PageRequest.of(
                0,
                2

        );
        List<Course> firstPageSixRecords =
                courseRepository.findByTitleContaining("j",page).getContent();
       log.info("firstPageSixRecords {}",firstPageSixRecords);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Student student = Student.builder()
                .firstName("vishnu")
                .lastName("tekkam")
                .emailId("vishnu.tekkam@gmail.com")
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("gayathri")
                .lastName("madam")
                .build();

        Course course = Course.builder()
                .teacher(teacher)
                .students(List.of(student))
                .title("Gen-AI")
                .credit(12)
                .build();

        courseRepository.save(course);

    }
}