package com.example.courseregistrationservice.controller;

import com.example.courseregistrationservice.model.CourseRegistration;
import com.example.courseregistrationservice.model.OfferedCourses;
import com.example.courseregistrationservice.service.HoleRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/student-registration")
public class StudentRegistrationController {

    @Autowired
    private HoleRegistrationService holeRegistrationService;

    @GetMapping(value = "/offer-courses")
    public ResponseEntity<List<OfferedCourses>> allOfferedCourses(){
        List<OfferedCourses> offeredCoursesList= holeRegistrationService.showAllOfferedCourses();
        return ResponseEntity.ok(offeredCoursesList);
    }


    @PostMapping(value = "/register-courses")
    public ResponseEntity<CourseRegistration> RegisterCourse(@RequestBody CourseRegistration courseRegistration){
        CourseRegistration courseRegistered = holeRegistrationService.registerCourseByStudent(courseRegistration);
        if (courseRegistered!=null)
            return ResponseEntity.created(null).body(courseRegistered);
        else return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @GetMapping(value = "/register-courses/{id}")
    public ResponseEntity<List<CourseRegistration>> allRegisteredCoursesIndividuals(@PathVariable Long id){
        List<CourseRegistration> courseRegistrationList= holeRegistrationService.callRegisteredCoursesIndividuals(id);
        return ResponseEntity.ok(courseRegistrationList);
    }

}
