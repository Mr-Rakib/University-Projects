package com.example.humanresourcemanagementservice.repository;

import com.example.humanresourcemanagementservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

}
