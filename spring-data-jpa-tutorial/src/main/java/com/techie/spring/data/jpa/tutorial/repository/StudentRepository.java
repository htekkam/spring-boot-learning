package com.techie.spring.data.jpa.tutorial.repository;

import com.techie.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String input);

    public List<Student> findByGuardianName(String guardianName);

    public List<Student> findByLastNameNotNull(String lastName);
}

