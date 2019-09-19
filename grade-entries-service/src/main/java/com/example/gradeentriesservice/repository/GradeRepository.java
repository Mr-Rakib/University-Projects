package com.example.gradeentriesservice.repository;

import com.example.gradeentriesservice.model.CompositeGradeKey;
import com.example.gradeentriesservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, CompositeGradeKey> {
}
