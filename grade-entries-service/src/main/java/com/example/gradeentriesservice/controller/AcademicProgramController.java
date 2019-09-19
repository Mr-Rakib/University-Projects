package com.example.gradeentriesservice.controller;


import com.example.gradeentriesservice.model.AcademicProgram;
import com.example.gradeentriesservice.repository.AcademicProgramRepository;
import com.example.gradeentriesservice.service.AcademicProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/programs")
public class AcademicProgramController {


    @Autowired
    private AcademicProgramService academicProgramService;

    @GetMapping(value = "")
    public ResponseEntity<List<AcademicProgram>> allPrograms(){
        List<AcademicProgram> programsList = academicProgramService.allPrograms();
        return ResponseEntity.ok(programsList);
    }

    @PostMapping(value = "")
    public ResponseEntity<AcademicProgram> createProgram (@RequestBody AcademicProgram academicProgram ){
        AcademicProgram createdProgram =  academicProgramService.createProgram(academicProgram);
        return ResponseEntity.created(null).body(createdProgram);
    }
}
