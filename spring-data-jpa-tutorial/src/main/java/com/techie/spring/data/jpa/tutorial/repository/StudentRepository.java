package com.techie.spring.data.jpa.tutorial.repository;

import com.techie.spring.data.jpa.tutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String input);

    public List<Student> findByGuardianName(String guardianName);

    @Query("select s from Student s where s.emailId = ?1")
    Optional<Student> getStudentByEmailAddress(String emailId);

    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailUsingNativeQuery(String emailId);

    @Query(
            value = "select * from tbl_student s where s.first_name = :firstName",
            nativeQuery = true
    )
    Student getStudentByFirstNameWithNamedParam(@Param("firstName") String firstName);


    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set email_address = ?1 where student_id = ?2",
            nativeQuery = true
    )
    int updateStudentEmailById(String emailAddress , long studentId);
}

