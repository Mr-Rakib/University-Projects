package com.example.courseregistrationservice.repository;

import com.example.courseregistrationservice.model.CompositeOfferedCourseKey;
import com.example.courseregistrationservice.model.OfferedCourses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferedCoursesRepository extends JpaRepository<OfferedCourses, CompositeOfferedCourseKey> {
}
