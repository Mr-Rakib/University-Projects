package com.example.studentadmissionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@IdClass(CompositeStudentRegisterKey.class)
public class CourseRegistration {

    @Id
    private String courseCode;
    @Id
    private Long studentId;
    @Id
    private int sectionNumber;

    private String facultyId;
    private int courseCredit;

    @Id
    private int semesterId;

    public CourseRegistration(String courseCode, Long studentId, int sectionNumber, String facultyId, int courseCredit) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.sectionNumber = sectionNumber;
        this.facultyId = facultyId;
        this.courseCredit = courseCredit;
    }
}
