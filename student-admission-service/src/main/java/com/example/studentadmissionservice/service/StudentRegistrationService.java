package com.example.studentadmissionservice.service;

import com.example.studentadmissionservice.model.CourseRegistration;
import com.example.studentadmissionservice.model.Grade;
import com.example.studentadmissionservice.model.OfferedCourses;
import com.example.studentadmissionservice.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentRegistrationService {




    @Value("${course-registration-uri}/register-courses")
    private String uri;

    @Value("${course-registration-uri}/offer-courses")
    private String offeredCourseUri;

    public CourseRegistration courseRegistration(CourseRegistration courseRegistration) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CourseRegistration> request = new HttpEntity<>(courseRegistration);
        ResponseEntity<CourseRegistration> response = restTemplate
                .exchange(uri, HttpMethod.POST, request, CourseRegistration.class);
        CourseRegistration registerCourse = response.getBody();
        return registerCourse;
    }

    public List<OfferedCourses> showAllOfferedCourses() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<OfferedCourses>> response = restTemplate.exchange(
                offeredCourseUri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OfferedCourses>>(){});
        List<OfferedCourses> courseOffersList = response.getBody();

        return courseOffersList;

    }

    public List<CourseRegistration> showAllRegisteredCourses(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CourseRegistration>> response = restTemplate.exchange(
                uri+"/"+id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CourseRegistration>>(){});
        List<CourseRegistration> courseRegistrationList = response.getBody();

        return courseRegistrationList;
    }

}
