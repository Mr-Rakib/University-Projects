package com.example.courseregistrationservice.repository;

import com.example.courseregistrationservice.model.CompositeStudentRegisterKey;
import com.example.courseregistrationservice.model.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, CompositeStudentRegisterKey> {
    List<CourseRegistration> findCourseRegistrationByStudentId(Long id);
}
