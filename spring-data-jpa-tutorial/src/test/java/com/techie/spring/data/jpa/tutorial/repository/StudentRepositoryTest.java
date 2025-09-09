package com.techie.spring.data.jpa.tutorial.repository;

import com.techie.spring.data.jpa.tutorial.entity.Guardian;
import com.techie.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Student student = Student.builder()
                .emailId("harikrishna.tekkam@gmailcom")
                .firstName("hari")
                .lastName("tekkam")
//                .guardianName("Gunnu")
//                .guardianEmail("gunnu@gmail.com")
//                .guardianMobile("1343432443")
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudents(){
        studentRepository.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void saveWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("gunnu@gmail.com")
                .name("gunnu")
                .mobile("112233445566").build();

        Student student = Student.builder()
                .firstName("atchuth")
                .lastName("tekkam")
                .emailId("atchuth.tekkam@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void findByFirstName(){
        studentRepository.findByFirstName("hari")
                .stream()
                .forEach(System.out::println);
    }

    @Test
    public void findByGuardianName(){
        studentRepository.findByGuardianName("gunnu")
                .stream()
                .forEach(System.out::println);
    }

    @Test
    public void printStudent(){
        Optional<Student> studentByEmailAddress = studentRepository.getStudentByEmailAddress("harikrishna.tekkam@gmail.com");
        System.out.println("studentByEmailAddress::"+(studentByEmailAddress.isPresent() ? studentByEmailAddress.get() : "student does not exist"));

    }

    @Test
    public void printGetStudentByEmailUsingNativeQuery(){
        Student student = studentRepository.getStudentByEmailUsingNativeQuery("harikrishna.tekkam@gmailcom");
        System.out.println("student::"+student);
    }

    @Test
    public void getStudentByFirstNameWithNamedParam(){
        Student student = studentRepository.getStudentByFirstNameWithNamedParam("hari");
        System.out.println("student with named parameters::"+student);
    }

    @Test
    public void updateStudentEmailById(){
        int totalRecordsUpdated = studentRepository.updateStudentEmailById("hari186980@gmail.com",
                1);
        System.out.println("totalRecordsUpdated::"+totalRecordsUpdated);
    }
}