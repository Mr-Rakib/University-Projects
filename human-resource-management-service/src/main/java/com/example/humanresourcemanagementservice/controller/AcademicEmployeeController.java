package com.example.humanresourcemanagementservice.controller;

import com.example.humanresourcemanagementservice.model.AcademicProgram;
import com.example.humanresourcemanagementservice.model.Course;
import com.example.humanresourcemanagementservice.service.AcademicEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/academic")
public class AcademicEmployeeController {

    @Autowired
    private AcademicEmployeeService academicEmployeeService;


    @GetMapping(value = "/programs")
    public ResponseEntity<List<AcademicProgram>> allPrograms(){
        List<AcademicProgram> programsList = academicEmployeeService.allPrograms();
        return ResponseEntity.ok(programsList);
    }

    @PostMapping(value = "/programs")
    public ResponseEntity<AcademicProgram> createProgram (@RequestBody AcademicProgram academicProgram ){
        AcademicProgram createdProgram = academicEmployeeService.createProgram(academicProgram);
        return ResponseEntity.created(null).body(createdProgram);
    }



    @PostMapping(value = "/courses")
    public ResponseEntity<Course> createCourse (@RequestBody Course course ){
        Course createdCourse = academicEmployeeService.createCourse(course);
        return ResponseEntity.created(null).body(createdCourse);
    }

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> allCourses(){
        List<Course> courseList = academicEmployeeService.allCourses();
        return ResponseEntity.ok(courseList);
    }


}
