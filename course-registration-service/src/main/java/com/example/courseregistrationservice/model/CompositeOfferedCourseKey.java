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
public class CompositeOfferedCourseKey implements Serializable {
    private String courseCode;
    private int sectionNumber;
    private int semesterId;
}