package com.example.humanresourcemanagementservice.controller;


import com.example.humanresourcemanagementservice.model.CourseRegistration;
import com.example.humanresourcemanagementservice.model.OfferedCourses;
import com.example.humanresourcemanagementservice.service.CoordinatorEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/coordinator")
public class CoordinatorEmployeeController {

    @Autowired
    private CoordinatorEmployeeService coordinatorEmployeeService;

    @GetMapping(value = "/offer-courses")
    public ResponseEntity<List<OfferedCourses>> allOfferedCourses(){
        List<OfferedCourses> offeredCoursesList= coordinatorEmployeeService.showAllOfferedCourses();
        return ResponseEntity.ok(offeredCoursesList);
    }

    @PostMapping(value = "/offer-courses")
    public ResponseEntity<OfferedCourses> OfferCourse(@RequestBody OfferedCourses offeredCourse){
        OfferedCourses offeringCourse= coordinatorEmployeeService.offeredCoursesCreate(offeredCourse);
        return ResponseEntity.created(null).body(offeringCourse);
    }

    @GetMapping(value = "/register-courses")
    public ResponseEntity<List<CourseRegistration>> allRegisteredCourses(){
        List<CourseRegistration> courseRegistrationList= coordinatorEmployeeService.allRegisteredCourses();
        return ResponseEntity.ok(courseRegistrationList);
    }


    @GetMapping(value = "/register-courses/{id}")
    public ResponseEntity<List<CourseRegistration>> showAllRegisteredCourses(@PathVariable Long id) {
        List<CourseRegistration> registerCourseList = coordinatorEmployeeService.showAllRegisteredCoursesById(id);
        return ResponseEntity.ok(registerCourseList);
    }

}
