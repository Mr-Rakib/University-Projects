package com.example.fontendservicewc.service;

import com.example.fontendservicewc.model.Grade;
import com.example.fontendservicewc.model.RegistrationConvocation;
import com.vaadin.flow.component.html.Label;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class StudentService {

    @Value("${student-admission-service}/all-grade")
    String gradeUri;


    @Value("${student-admission-service}/convocation/register-students")
    private String uri;

    public List<Grade> ViewAllGrade(Long id) {


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Grade>> response = restTemplate.exchange(
                gradeUri+"/"+id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Grade>>(){});
        List<Grade> gradeList = response.getBody();
        gradeList.stream().forEach(System.out::println);
        return gradeList;

    }

    public RegistrationConvocation RegisterForConvocation(RegistrationConvocation registrationConvocation) {


        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<RegistrationConvocation> request = new HttpEntity<>(registrationConvocation);
        ResponseEntity<RegistrationConvocation> response = restTemplate
                .exchange(uri, HttpMethod.POST, request, RegistrationConvocation.class);
        RegistrationConvocation registrationConvocationResponse = response.getBody();
        return registrationConvocationResponse;

    }
}
