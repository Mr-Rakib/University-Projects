package com.example.gradeentriesservice.repository;

import com.example.gradeentriesservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {
}
