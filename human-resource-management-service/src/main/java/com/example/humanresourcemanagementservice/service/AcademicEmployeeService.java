package com.example.humanresourcemanagementservice.service;
import com.example.humanresourcemanagementservice.model.AcademicProgram;
import com.example.humanresourcemanagementservice.model.Course;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AcademicEmployeeService {
    @Value("${grade-entries-uri}/courses")
    private String coursesUri;

    @Value("${grade-entries-uri}/programs")
    private String programUri;

    public AcademicProgram createProgram(AcademicProgram academicProgram){

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<AcademicProgram> request = new HttpEntity<>(academicProgram);
        ResponseEntity<AcademicProgram> response = restTemplate
                .exchange(programUri, HttpMethod.POST, request, AcademicProgram.class);
        AcademicProgram createdAcademicProgram = response.getBody();
        return createdAcademicProgram;
    }

    public Course createCourse(Course course){

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Course> request = new HttpEntity<>(course);
        ResponseEntity<Course> response = restTemplate
                .exchange(coursesUri, HttpMethod.POST, request, Course.class);
        Course createdCourse = response.getBody();
        return createdCourse;
    }

    public List<AcademicProgram> allPrograms() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<AcademicProgram>> response = restTemplate.exchange(
                programUri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AcademicProgram>>(){});
        List<AcademicProgram> academicProgramList = response.getBody();
        return academicProgramList;

    }

    public List<Course> allCourses() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Course>> response = restTemplate.exchange(
                coursesUri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Course>>(){});
        List<Course> courseList = response.getBody();
        return courseList;
    }
}
