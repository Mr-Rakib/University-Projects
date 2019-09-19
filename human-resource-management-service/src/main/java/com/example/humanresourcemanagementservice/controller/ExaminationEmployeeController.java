package com.example.humanresourcemanagementservice.controller;

import com.example.humanresourcemanagementservice.model.Grade;
import com.example.humanresourcemanagementservice.model.RegistrationConvocation;
import com.example.humanresourcemanagementservice.service.ExaminationEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/examination")
public class ExaminationEmployeeController {
    @Autowired
    private ExaminationEmployeeService examinationEmployeeService;

    @GetMapping(value = "/students-grade")
    public ResponseEntity<List<Grade>> viewAllStudentsGrade(){
        List<Grade> gradeList = examinationEmployeeService.viewAllStudentsGrades();
        return ResponseEntity.ok(gradeList);
    }


    @GetMapping(value = "/students-grade/{id}")
    public ResponseEntity<List<Grade>> viewGradeById(@PathVariable Long id){
        List<Grade> individualGradeList = examinationEmployeeService.viewGradesById(id);
        return ResponseEntity.ok(individualGradeList);
    }

    @PostMapping(value = "/students-grade")
    public ResponseEntity<Grade> addGrade(@RequestBody Grade grade){
        Grade individualGrade = examinationEmployeeService.addGrade(grade);
        return ResponseEntity.ok(individualGrade);
    }


    @GetMapping(value = "/convocation-register-students")
    public ResponseEntity<List<RegistrationConvocation>> findAllRegisterStudent(){
        List<RegistrationConvocation> registrationConvocationList = examinationEmployeeService.findAllRegisterStudent();
        return ResponseEntity.ok(registrationConvocationList);
    }


    @GetMapping(value = "/convocation-register-students/{id}")
    public ResponseEntity<RegistrationConvocation> findAllRegisterStudent(@PathVariable Long id){
        RegistrationConvocation registeredStudentById = examinationEmployeeService.findAllRegisterStudentById(id);
        if (registeredStudentById != null) return ResponseEntity.ok(registeredStudentById);
        else return ResponseEntity.notFound().build();
    }


}
