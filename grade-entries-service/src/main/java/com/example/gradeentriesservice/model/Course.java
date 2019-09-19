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
@EqualsAndHashCode(of = {"code"})
@Entity
public class Course {
    @Id
    private String code;
    private String title;
    private int credit;
}
