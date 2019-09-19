package com.example.courseregistrationservice.controller;

import com.example.courseregistrationservice.model.CourseRegistration;
import com.example.courseregistrationservice.model.OfferedCourses;
import com.example.courseregistrationservice.service.HoleRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/registration")
public class CoordinatorRegistrationController {
    @Autowired
    private HoleRegistrationService holeRegistrationService;

    @GetMapping(value = "/offer-courses")
    public ResponseEntity<List<OfferedCourses>> allOfferedCourses(){
        List<OfferedCourses> offeredCoursesList= holeRegistrationService.showAllOfferedCourses();
        return ResponseEntity.ok(offeredCoursesList);
    }

    @PostMapping(value = "/offer-courses")
    public ResponseEntity<OfferedCourses> OfferCourse(@RequestBody OfferedCourses offeredCourse){
        OfferedCourses offeringCourse= holeRegistrationService.OfferCourse(offeredCourse);
        return ResponseEntity.created(null).body(offeringCourse);
    }

    @GetMapping(value = "/register-courses")
    public ResponseEntity<List<CourseRegistration>> allRegisteredCourses(){
        List<CourseRegistration> courseRegistrationList= holeRegistrationService.callRegisteredCourses();
        return ResponseEntity.ok(courseRegistrationList);
    }

    @GetMapping(value = "/register-courses/{id}")
    public ResponseEntity<List<CourseRegistration>> allRegisteredCoursesIndividuals(@PathVariable Long id){
        List<CourseRegistration> courseRegistrationList= holeRegistrationService.callRegisteredCoursesIndividuals(id);
        return ResponseEntity.ok(courseRegistrationList);
    }


}
