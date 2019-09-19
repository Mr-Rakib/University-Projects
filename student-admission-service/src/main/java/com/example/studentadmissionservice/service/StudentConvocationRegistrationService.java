package com.example.studentadmissionservice.service;

import com.example.studentadmissionservice.model.CourseRegistration;
import com.example.studentadmissionservice.model.OfferedCourses;
import com.example.studentadmissionservice.model.RegistrationConvocation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentConvocationRegistrationService {

    @Value("${convocation-registration-uri}")
    private String uri;

    public RegistrationConvocation registerForConvocationByStudent(RegistrationConvocation registrationConvocation) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<RegistrationConvocation> request = new HttpEntity<>(registrationConvocation);
        ResponseEntity<RegistrationConvocation> response = restTemplate
                .exchange(uri, HttpMethod.POST, request, RegistrationConvocation.class);
        RegistrationConvocation registrationConvocationResponse = response.getBody();
        return registrationConvocationResponse;
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
