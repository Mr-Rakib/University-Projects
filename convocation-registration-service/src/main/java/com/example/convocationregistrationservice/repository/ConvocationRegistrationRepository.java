package com.example.convocationregistrationservice.repository;

import com.example.convocationregistrationservice.model.RegistrationConvocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvocationRegistrationRepository extends JpaRepository<RegistrationConvocation,Long> {
}
