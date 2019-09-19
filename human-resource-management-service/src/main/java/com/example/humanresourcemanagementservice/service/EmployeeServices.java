package com.example.humanresourcemanagementservice.service;

import com.example.humanresourcemanagementservice.exception.ResourceNotExistException;
import com.example.humanresourcemanagementservice.model.Employee;
import com.example.humanresourcemanagementservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee update(String id, Employee employee) throws ResourceNotExistException {
        if (employeeRepository.findById(id).isPresent()){
            employee.setId(id);
            return employeeRepository.save(employee);
        } else throw  new ResourceNotExistException("Employee Does Not Exist for Update");
    }
}
