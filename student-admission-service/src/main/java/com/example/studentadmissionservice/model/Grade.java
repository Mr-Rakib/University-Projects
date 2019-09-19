package com.example.studentadmissionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Grade {

    private Long studentId;
    private String courseCode;
    private float gpa;
    private String grade;
    private int semesterId;
}