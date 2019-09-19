package com.example.humanresourcemanagementservice.controller;

import com.example.humanresourcemanagementservice.exception.ResourceAlreadyExistException;
import com.example.humanresourcemanagementservice.exception.ResourceNotExistException;
import com.example.humanresourcemanagementservice.model.Employee;
import com.example.humanresourcemanagementservice.service.HumanResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/human-resource")
public class HumanResourceController {

    @Autowired
    private HumanResourceService humanResourceService;

    @PostMapping(value = "/employees")
    public ResponseEntity<Employee> insert(@RequestBody Employee employee) {

        try {
            Employee createdEmployee = humanResourceService.save(employee);
            return ResponseEntity.created(null).body(createdEmployee);
        } catch (ResourceAlreadyExistException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();}
    }


    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employeeList = humanResourceService.findAll();
        return ResponseEntity.ok(employeeList);
    }


    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable String id) throws ResourceNotExistException {
        Employee employee = humanResourceService.findById(id);
        if (employee == null)
          //  throw new ResourceNotExistException("Employee Not Found");
            return null;
        else return ResponseEntity.ok(employee);
    }

    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<String> DeleteById(@PathVariable String id) throws ResourceNotExistException {
        Boolean deleteStatus = humanResourceService.deleteById(id);
        if (deleteStatus)
            return ResponseEntity.ok(id);
            //  throw new ResourceNotExistException("Employee Not Found");
        else return null;

    }


}
