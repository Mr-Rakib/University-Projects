package com.example.studentadmissionservice.controller;


import com.example.studentadmissionservice.model.Student;
import com.example.studentadmissionservice.service.StudentAdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/admission-students")
public class StudentAdmissionController {
    @Autowired
    private StudentAdmissionService studentAdmissionService;



    @GetMapping(value = "")
    public ResponseEntity<List<Student>> FindAll(){
        List<Student> studentList = studentAdmissionService.findAll();
        return ResponseEntity.ok(studentList);
    }

    @PostMapping(value = "")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
        try {
            Student savedStudent = studentAdmissionService.save(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }

    }


}
