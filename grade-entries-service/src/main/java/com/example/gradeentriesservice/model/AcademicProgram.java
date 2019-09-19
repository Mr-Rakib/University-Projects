package com.example.gradeentriesservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"title"})
@Entity
public class AcademicProgram {

    @Id
    private String title;
    private double Cgpa;
    private int totalCreditHour;
}
