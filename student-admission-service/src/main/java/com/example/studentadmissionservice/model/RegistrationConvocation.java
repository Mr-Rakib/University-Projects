package com.example.studentadmissionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"studentId"})

public class RegistrationConvocation {

    private Long studentId;
    private String programName;
    private int TotalCredit;
    private float CGPA;
    private float amountFees;
    private String referenceCodeOfPayment;



}