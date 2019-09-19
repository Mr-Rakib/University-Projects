package com.example.humanresourcemanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
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
}