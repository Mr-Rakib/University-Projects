package com.example.humanresourcemanagementservice.service;

import com.example.humanresourcemanagementservice.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AdmissionEmployeeService {
    @Value("${student_data_uri}/admission-students")
    String uri;


    public List<Student> allStudents() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Student>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Student>>(){});
        List<Student> studentList = response.getBody();
        return studentList;


    }

    public Student  findStudentById(Long id) {


        List<Student> studentList =  allStudents();

        Student result = studentList.stream()
                                    .filter(x -> id.equals(x.getId()))
                                    .findAny()
                                    .orElse(null);
        System.out.println(id+" -> " +result);
        return result;

    }


    public Student addStudent(Student student) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Student> request = new HttpEntity<>(student);
        ResponseEntity<Student> response = restTemplate
                .exchange(uri, HttpMethod.POST, request, Student.class);
        Student createdStudent = response.getBody();
        System.out.println(createdStudent);
        return createdStudent;
    }

    public void deleteById(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        String entityUrl = uri + "/" + id;
        restTemplate.delete(entityUrl);
    }

}
