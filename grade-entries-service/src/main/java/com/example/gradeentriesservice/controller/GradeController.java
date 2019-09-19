package com.example.gradeentriesservice.controller;


import com.example.gradeentriesservice.exception.ResourceNotExistException;
import com.example.gradeentriesservice.model.Grade;
import com.example.gradeentriesservice.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/grades")
public class GradeController {
    @Autowired
    private GradeService gradeService;


    @GetMapping(value = "")
    public ResponseEntity<List<Grade>> viewAllStudentsGrade(){
        List<Grade> gradeList = gradeService.viewAllStudentsGrades();
        return ResponseEntity.ok(gradeList);
    }


    @PostMapping(value = "")
    public ResponseEntity<Grade> addGrade(@RequestBody Grade grade){

        try {
            Grade individualGrade = gradeService.addGrade(grade);
            return ResponseEntity.created(null).body(individualGrade);

        } catch (ResourceNotExistException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
