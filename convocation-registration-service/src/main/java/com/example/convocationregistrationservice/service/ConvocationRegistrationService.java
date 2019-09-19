package com.example.convocationregistrationservice.service;

import com.example.convocationregistrationservice.model.RegistrationConvocation;
import com.example.convocationregistrationservice.repository.ConvocationRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConvocationRegistrationService {
    @Autowired
    private ConvocationRegistrationRepository convocationRegistrationRepository;

    public List<RegistrationConvocation> findAllRegisterStudent() {
        return convocationRegistrationRepository.findAll();
    }

    public RegistrationConvocation registerForConvocationByStudent(RegistrationConvocation registrationConvocation) {
        boolean status = ValidationForRegistration(registrationConvocation);
        if (status)
            return convocationRegistrationRepository.save(registrationConvocation);
        else return null;
    }

    public RegistrationConvocation findAllRegisterStudentById(Long id) {
        Optional<RegistrationConvocation> studentById = convocationRegistrationRepository.findById(id);
        if (studentById.isPresent())
            return studentById.get();
        else return null;
    }

    private boolean ValidationForRegistration(RegistrationConvocation registrationConvocation) {
        Long studentId = registrationConvocation.getStudentId();

        return true;
    }
}
