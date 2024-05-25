package com.app.feepayment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false)
    private String courseName;

    private String courseDesc;

    @Column(nullable = false)
    private Double courseFee;

    @OneToMany(mappedBy = "course")
    private Set<Enrollment> enrollments;

    @OneToMany(mappedBy = "course")
    private Set<Payment> payments;

    // Getters and Setters
}
