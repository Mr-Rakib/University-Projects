package com.example.gradeentriesservice.service;

import com.example.gradeentriesservice.model.AcademicProgram;
import com.example.gradeentriesservice.repository.AcademicProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicProgramService {

    @Autowired
    private AcademicProgramRepository academicProgramRepository;

    public List<AcademicProgram> allPrograms() {
        return academicProgramRepository.findAll();
    }

    public AcademicProgram createProgram(AcademicProgram academicProgram) {
        return academicProgramRepository.save(academicProgram);
    }
}
