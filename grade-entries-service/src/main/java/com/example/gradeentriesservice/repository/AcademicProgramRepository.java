package com.example.gradeentriesservice.repository;

import com.example.gradeentriesservice.model.AcademicProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicProgramRepository extends JpaRepository<AcademicProgram,String> {
}
