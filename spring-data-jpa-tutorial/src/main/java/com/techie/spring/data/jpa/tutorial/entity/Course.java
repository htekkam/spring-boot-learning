package com.techie.spring.data.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "courseMaterial")
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence")
    private long courseId;
    private String title;
    private Integer credit;


    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;
}
