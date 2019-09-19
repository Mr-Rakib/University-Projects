package com.example.studentadmissionservice.service;

import com.example.studentadmissionservice.exception.ResourceAlreadyExistException;
import com.example.studentadmissionservice.exception.ResourceNotFoundException;
import com.example.studentadmissionservice.model.Course;
import com.example.studentadmissionservice.model.CourseRegistration;
import com.example.studentadmissionservice.model.Grade;
import com.example.studentadmissionservice.model.Student;
import com.example.studentadmissionservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {


    @Value("${grade-entries-uri}/grades")
    String gradeUri;

    @Value("${grade-entries-uri}/courses")
    private String uri;

    @Autowired
    private StudentRepository studentRepository;

    public Student findByID(long id)throws Exception {

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent())
            return optionalStudent.get();
        else throw new ResourceNotFoundException(""+id);
    }



    public Student update(long id, Student student) throws ResourceNotFoundException {
        if(studentRepository.findById(id).isPresent()){
            student.setId(id);
            return studentRepository.save(student);
        } else throw new ResourceNotFoundException(""+id);
    }

    public List<Course> showAllCourses() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Course>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Course>>(){});
        List<Course> courseList = response.getBody();
        return courseList;
    }



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
}