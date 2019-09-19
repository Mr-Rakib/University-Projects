package com.example.gradeentriesservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CompositeGradeKey implements Serializable {
    private Long studentId;
    private String courseCode;
    private int semesterId;
}
