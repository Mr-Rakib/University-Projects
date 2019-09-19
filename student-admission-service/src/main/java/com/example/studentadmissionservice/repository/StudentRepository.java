package com.example.studentadmissionservice.repository;

import com.example.studentadmissionservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
