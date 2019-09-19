package com.example.studentadmissionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@IdClass(CompositeOfferedCourseKey.class)
public class OfferedCourses {

    @Id
    private String courseCode;
    @Id
    private int sectionNumber;
    private String facultyId;
    private int courseCredit;
    private int capacity;
    @Id
    private int semesterId;
}
