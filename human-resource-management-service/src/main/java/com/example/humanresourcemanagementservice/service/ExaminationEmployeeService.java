package com.example.humanresourcemanagementservice.service;

import com.example.humanresourcemanagementservice.model.Grade;
import com.example.humanresourcemanagementservice.model.RegistrationConvocation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExaminationEmployeeService {

    @Value("${grade-entries-uri}/grades")
    String gradeUri;

    @Value("${convocation-registration-uri}")
    private String uri;

    public List<Grade> viewAllStudentsGrades() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Grade>> response = restTemplate.exchange(
                gradeUri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Grade>>(){});
        List<Grade> gradeList = response.getBody();
        return gradeList;
    }

    public List<Grade> viewGradesById(Long id) {
        List<Grade> gradeList = viewAllStudentsGrades();

         return gradeList.stream()
                .filter(x -> id.equals(x.getStudentId()))
                .collect(Collectors.toList());
    }

    public Grade addGrade(Grade grade) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Grade> request = new HttpEntity<>(grade);
        ResponseEntity<Grade> response = restTemplate
                .exchange(gradeUri, HttpMethod.POST, request, Grade.class);
        Grade addedGrade = response.getBody();
        return addedGrade;
    }

    public List<RegistrationConvocation> findAllRegisterStudent() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<RegistrationConvocation>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<RegistrationConvocation>>(){});
        List<RegistrationConvocation> registrationConvocationList = response.getBody();
        return registrationConvocationList;
    }

    public RegistrationConvocation findAllRegisterStudentById(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RegistrationConvocation> response = restTemplate.exchange(
                uri+"/"+id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<RegistrationConvocation>(){});
        RegistrationConvocation registrationConvocation = response.getBody();
        return registrationConvocation;
    }
}
