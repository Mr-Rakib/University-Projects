package com.example.convocationregistrationservice.controller;

import com.example.convocationregistrationservice.model.RegistrationConvocation;
import com.example.convocationregistrationservice.service.ConvocationRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/convocation")
public class ConvocationRegistrationController {

    @Autowired
    private ConvocationRegistrationService convocationRegistrationService;

    @GetMapping(value = "/register-students")
    public ResponseEntity<List<RegistrationConvocation>> findAllRegisterStudent(){
        List<RegistrationConvocation> registrationConvocationList = convocationRegistrationService.findAllRegisterStudent();
        return ResponseEntity.ok(registrationConvocationList);
    }
    @PostMapping(value = "/register-students")
    public ResponseEntity<RegistrationConvocation> RegisterForConvocationByStudent(@RequestBody RegistrationConvocation registrationConvocation){

        RegistrationConvocation registeredStudent = convocationRegistrationService.
                                            registerForConvocationByStudent(registrationConvocation);
        if (registeredStudent != null) return ResponseEntity.created(null).body(registeredStudent);
        else return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/register-students/{id}")
    public ResponseEntity<RegistrationConvocation> findAllRegisterStudent(@PathVariable Long id){
        RegistrationConvocation registeredStudentById = convocationRegistrationService.findAllRegisterStudentById(id);
        if (registeredStudentById != null) return ResponseEntity.ok(registeredStudentById);
        else return ResponseEntity.notFound().build();
    }


}
