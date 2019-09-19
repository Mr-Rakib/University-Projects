package com.example.humanresourcemanagementservice.service;

import com.example.humanresourcemanagementservice.model.CourseRegistration;
import com.example.humanresourcemanagementservice.model.OfferedCourses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CoordinatorEmployeeService {
    @Value("${course-registration-uri}/offer-courses")
    String offerCourseUri;

    @Value("${course-registration-uri}/register-courses")
    String registerCourseUri;

    public List<OfferedCourses> showAllOfferedCourses() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<OfferedCourses>> response = restTemplate.exchange(
                offerCourseUri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OfferedCourses>>(){});
        List<OfferedCourses> courseOffersList = response.getBody();

        return courseOffersList;
    }


    public OfferedCourses offeredCoursesCreate(OfferedCourses offeredCourses){

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<OfferedCourses> request = new HttpEntity<>(offeredCourses);
        ResponseEntity<OfferedCourses> response = restTemplate
                .exchange(offerCourseUri, HttpMethod.POST, request, OfferedCourses.class);
        OfferedCourses offeredCoursesCreated = response.getBody();
        //System.out.println(offeredCoursesCreated);
        return offeredCoursesCreated;
    }

    public List<CourseRegistration> allRegisteredCourses() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CourseRegistration>> response = restTemplate.exchange(
                registerCourseUri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CourseRegistration>>(){});
        List<CourseRegistration> courseRegistrationList = response.getBody();

        return courseRegistrationList;
    }

    public List<CourseRegistration> showAllRegisteredCoursesById(Long id) {

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<CourseRegistration>> response = restTemplate.exchange(
                    registerCourseUri+"/"+id,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<CourseRegistration>>(){});
            List<CourseRegistration> courseRegistrationList = response.getBody();

            return courseRegistrationList;
        }

}
