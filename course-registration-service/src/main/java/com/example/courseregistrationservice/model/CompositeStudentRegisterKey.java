package com.example.courseregistrationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class CompositeStudentRegisterKey implements Serializable {
    private String courseCode;
    private Long studentId;
    private int semesterId;
    private int sectionNumber;
}
