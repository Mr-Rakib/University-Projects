package com.example.studentadmissionservice.controller;

import com.example.studentadmissionservice.exception.ResourceNotFoundException;
import com.example.studentadmissionservice.model.Course;
import com.example.studentadmissionservice.model.CourseRegistration;
import com.example.studentadmissionservice.model.Grade;
import com.example.studentadmissionservice.model.Student;
import com.example.studentadmissionservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping(value = "/{id}/profile")
    public ResponseEntity<Student> showProfile(@PathVariable long id) throws Exception {
        Student studentFound = studentService.findByID(id);
        if(studentFound != null)
            return ResponseEntity.ok(studentFound);
        else
            return ResponseEntity.notFound().build();
        //return studentRepository.findById(id).get();
    }



    @PutMapping(value = "/{id}/edit-profile")
    public ResponseEntity<Student> updateProfile(@PathVariable long id, @RequestBody Student student) {
        try {
            Student updatedStudent = studentService.update(id, student);
            return ResponseEntity.ok(updatedStudent);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping(value = "/course-list")
    public ResponseEntity<List<Course>> showAllCourses() {
        List<Course> courseList = studentService.showAllCourses();
        return ResponseEntity.ok(courseList);
    }




    @GetMapping(value = "/all-grade/{id}")
    public ResponseEntity<List<Grade>> viewGradeById(@PathVariable Long id){
        List<Grade> individualGradeList = studentService.viewGradesById(id);
        return ResponseEntity.ok(individualGradeList);
    }





}