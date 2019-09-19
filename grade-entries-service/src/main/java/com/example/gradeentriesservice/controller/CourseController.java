package com.example.gradeentriesservice.controller;

import com.example.gradeentriesservice.model.Course;
import com.example.gradeentriesservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController  {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "")
    public ResponseEntity<List<Course>> allCourses(){
        List<Course> courseList = courseService.allCourses();
        return ResponseEntity.ok(courseList);
    }

    @PostMapping(value = "")
    public ResponseEntity<Course> createCourse (@RequestBody Course course ){
        Course createdCourse = courseService.createCourse(course);
        return ResponseEntity.created(null).body(createdCourse);
    }

}
