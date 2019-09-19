package com.example.studentadmissionservice.service;

import com.example.studentadmissionservice.exception.ResourceAlreadyExistException;
import com.example.studentadmissionservice.exception.ResourceNotFoundException;
import com.example.studentadmissionservice.model.Student;
import com.example.studentadmissionservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAdmissionService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {

        return studentRepository.findAll();
    }

    public Student save(Student student) throws ResourceAlreadyExistException {
        if (studentRepository.findById(student.getId()).isPresent()){
            throw new ResourceAlreadyExistException(student.getName());
        }
        return studentRepository.save(student);
    }

}
