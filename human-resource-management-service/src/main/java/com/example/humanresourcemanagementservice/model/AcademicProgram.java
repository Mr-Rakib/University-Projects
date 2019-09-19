package com.example.humanresourcemanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"title"})

public class AcademicProgram {

    private String title;
    private double Cgpa;
    private int totalCreditHour;
}
