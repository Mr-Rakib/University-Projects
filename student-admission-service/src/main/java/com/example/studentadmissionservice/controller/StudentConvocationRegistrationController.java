package com.example.studentadmissionservice.controller;


import com.example.studentadmissionservice.model.RegistrationConvocation;
import com.example.studentadmissionservice.service.StudentConvocationRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student/convocation")
public class StudentConvocationRegistrationController {

    @Autowired
    private StudentConvocationRegistrationService studentConvocationRegistrationService;

    @PostMapping(value = "/register-students")
    public ResponseEntity<RegistrationConvocation> RegisterForConvocationByStudent(@RequestBody RegistrationConvocation registrationConvocation){

        RegistrationConvocation registeredForConvocation = studentConvocationRegistrationService.
                registerForConvocationByStudent(registrationConvocation);
        if (registeredForConvocation != null) return ResponseEntity.created(null).body(registeredForConvocation);
        else return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/register-students/{id}")
    public ResponseEntity<RegistrationConvocation> findAllRegisterStudent(@PathVariable Long id){
        RegistrationConvocation registeredStudentById = studentConvocationRegistrationService.findAllRegisterStudentById(id);
        if (registeredStudentById != null)
            return ResponseEntity.ok(registeredStudentById);
        else return ResponseEntity.notFound().build();
    }

}
