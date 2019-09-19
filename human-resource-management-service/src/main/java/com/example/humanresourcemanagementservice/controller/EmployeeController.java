package com.example.humanresourcemanagementservice.controller;

import com.example.humanresourcemanagementservice.exception.ResourceAlreadyExistException;
import com.example.humanresourcemanagementservice.exception.ResourceNotExistException;
import com.example.humanresourcemanagementservice.model.Employee;

import com.example.humanresourcemanagementservice.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/employees")

public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;


    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> update(@PathVariable String id,@RequestBody Employee employee) {

        try {
            Employee updatedEmployee = employeeServices.update(id, employee);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedEmployee);

        } catch (ResourceNotExistException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }
}
