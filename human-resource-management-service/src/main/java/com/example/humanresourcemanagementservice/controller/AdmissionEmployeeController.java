package com.example.humanresourcemanagementservice.controller;


import com.example.humanresourcemanagementservice.model.Student;
import com.example.humanresourcemanagementservice.service.AdmissionEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admission")
public class AdmissionEmployeeController {
    @Autowired
    private AdmissionEmployeeService admissionEmployeeService;

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> allStudents(){
        List<Student> studentList = admissionEmployeeService.allStudents();
        return ResponseEntity.ok(studentList);
    }

    @PostMapping(value = "/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student ){
        Student createdStudent = admissionEmployeeService.addStudent(student);
        return ResponseEntity.created(null).body(createdStudent);
    }


    @GetMapping(value = "students/{id}")
    public ResponseEntity<Student> showProfile(@PathVariable Long id) throws Exception {
        Student studentFound = admissionEmployeeService.findStudentById(id);
        if(studentFound != null)
            return ResponseEntity.ok(studentFound);
        else
            return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "students/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        admissionEmployeeService.deleteById(id);
        return ResponseEntity.ok(id);
    }

}
