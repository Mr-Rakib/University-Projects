package com.example.studentadmissionservice.model;

import lombok.*;
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
