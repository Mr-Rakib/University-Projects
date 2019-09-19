package com.example.humanresourcemanagementservice.service;

import com.example.humanresourcemanagementservice.exception.ResourceAlreadyExistException;
import com.example.humanresourcemanagementservice.model.Employee;
import com.example.humanresourcemanagementservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HumanResourceService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee save(Employee employee) throws ResourceAlreadyExistException {

        if (employeeRepository.findById(employee.getId()).isPresent())
            throw new ResourceAlreadyExistException("Already Inserted");
        else return employeeRepository.save(employee);
    }


    public Employee findById(String id){
        Optional<Employee> foundedEmployee = employeeRepository.findById(id);
        if (foundedEmployee.isPresent()) return foundedEmployee.get();
        else return null;
    }

    public List<Employee> findAll() {
        return  employeeRepository.findAll();
    }

    public Boolean deleteById(String id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }else return false;
    }
}
