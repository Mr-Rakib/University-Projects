package com.example.humanresourcemanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
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


    public OfferedCourses(String courseCode, int sectionNumber, String facultyId, int courseCredit, int capacity) {
        this.semesterId=generateSemesterId();
        this.courseCode = courseCode;
        this.sectionNumber = sectionNumber;
        this.facultyId = facultyId;
        this.courseCredit = courseCredit;
        this.capacity = capacity;

    }

    public int generateSemesterId(){
        int semesterNo;
        Period age = Period.between(LocalDate.of(2002, Month.JANUARY,1), LocalDate.now());
        semesterNo = (age.getYears()*12+age.getMonths())/4;
        return semesterNo;
    }
}