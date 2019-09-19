package com.example.gradeentriesservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@IdClass(CompositeGradeKey.class)
public class Grade {

    @Id
    private Long studentId;
    @Id
    private String courseCode;
    @Id
    private int semesterId;
    private float gpa;
    private String grade;
}