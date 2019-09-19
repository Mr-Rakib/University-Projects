package com.example.courseregistrationservice.model;

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
        this.semesterId=generateSemesterId();
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.sectionNumber = sectionNumber;
        this.facultyId = facultyId;
        this.courseCredit = courseCredit;

    }

    public int generateSemesterId(){
        int semesterNo;
        Period age = Period.between(LocalDate.of(2002,Month.JANUARY,1), LocalDate.now());
        semesterNo = (age.getYears()*12+age.getMonths())/4;
        return semesterNo;
    }
}
