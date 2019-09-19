package com.example.gradeentriesservice.service;

import com.example.gradeentriesservice.exception.ResourceNotExistException;
import com.example.gradeentriesservice.model.Grade;
import com.example.gradeentriesservice.repository.CourseRepository;
import com.example.gradeentriesservice.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Grade> viewAllStudentsGrades() {
        return gradeRepository.findAll();
    }

    public Grade addGrade(Grade grade) throws ResourceNotExistException {
        if(courseRepository.findById(grade.getCourseCode()).isPresent())
        return gradeRepository.save(grade);
        else throw new ResourceNotExistException(grade.getCourseCode());
    }
}
