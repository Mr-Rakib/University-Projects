package com.example.humanresourcemanagementservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
public class Employee {
    @Id
    private String id;
    private String name;
    private String programName;
    private String role;
    private float salary;
    private String password;
    @Size(min = 11, max=14)
    private String contract;

    //it will use the Employee for edit their profile
    public Employee(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
