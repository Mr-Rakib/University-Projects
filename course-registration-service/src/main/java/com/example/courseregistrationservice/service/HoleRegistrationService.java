package com.example.courseregistrationservice.service;

import com.example.courseregistrationservice.model.CompositeOfferedCourseKey;
import com.example.courseregistrationservice.model.CompositeStudentRegisterKey;
import com.example.courseregistrationservice.model.CourseRegistration;
import com.example.courseregistrationservice.model.OfferedCourses;
import com.example.courseregistrationservice.repository.CourseRegistrationRepository;
import com.example.courseregistrationservice.repository.OfferedCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HoleRegistrationService {
    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    @Autowired
    private OfferedCoursesRepository offeredCoursesRepository;


    public List<OfferedCourses> showAllOfferedCourses() {
        return offeredCoursesRepository.findAll();
    }

    public OfferedCourses OfferCourse(OfferedCourses offeredCourse) {
        offeredCourse.setSemesterId(offeredCourse.generateSemesterId());
        return offeredCoursesRepository.save(offeredCourse);
    }

    public List<CourseRegistration> callRegisteredCourses() {
        return courseRegistrationRepository.findAll();
    }

    public CourseRegistration registerCourseByStudent(CourseRegistration courseRegistration) {
     /*   Optional<OfferedCourses> offeredCourses = offeredCoursesRepository.findById(new CompositeOfferedCourseKey(courseRegistration.getCourseCode(),
                courseRegistration.getSectionNumber(), courseRegistration.getSemesterId()));
    */
            courseRegistration.setSemesterId(courseRegistration.generateSemesterId());
            return courseRegistrationRepository.save(courseRegistration);

    }

    public List<CourseRegistration> callRegisteredCoursesIndividuals(Long id) {
        List<CourseRegistration> courseRegistrationList =callRegisteredCourses();
        List<CourseRegistration> filteredList = null;
        filteredList = courseRegistrationList.stream()
                .filter(x -> x.getStudentId().equals(id))
                .collect(Collectors.toList());
        return filteredList;

    }

}
