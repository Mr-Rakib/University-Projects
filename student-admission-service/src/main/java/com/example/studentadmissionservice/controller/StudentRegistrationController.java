package com.example.studentadmissionservice.controller;
import com.example.studentadmissionservice.model.Course;
import com.example.studentadmissionservice.model.CourseRegistration;
import com.example.studentadmissionservice.model.Grade;
import com.example.studentadmissionservice.model.OfferedCourses;
import com.example.studentadmissionservice.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student/registration")
public class StudentRegistrationController {
    @Autowired
    private StudentRegistrationService studentRegistrationService;


    @GetMapping(value = "/offer-courses")
    public ResponseEntity<List<OfferedCourses>> showAllOfferedCourses() {
        List<OfferedCourses> offeredCoursesList = studentRegistrationService.showAllOfferedCourses();
        return ResponseEntity.ok(offeredCoursesList);
    }

    @PostMapping(value = "/register-courses")
    public ResponseEntity<CourseRegistration> courseRegistration(@RequestBody CourseRegistration courseRegistration) {
        CourseRegistration registeredCourse = studentRegistrationService.courseRegistration(courseRegistration);
        return ResponseEntity.created(null).body(registeredCourse);
    }



    @GetMapping(value = "/register-courses/{id}")
    public ResponseEntity<List<CourseRegistration>> showAllRegisteredCourses(@PathVariable Long id) {
        List<CourseRegistration> registerCourseList = studentRegistrationService.showAllRegisteredCourses(id);
        return ResponseEntity.ok(registerCourseList);
    }





}
