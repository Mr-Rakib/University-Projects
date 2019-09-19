package com.example.humanresourcemanagementservice.service;

import com.example.humanresourcemanagementservice.model.Student;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdmissionServiceTest {

    @Autowired
    private AdmissionEmployeeService admissionEmployeeService;
    @Test
    @Ignore
    public void saveStudent() {
       /* Student student = new Student(2016000000008l,"Shohel Hasan","BSc in CSE","0156891131");

        Student student1 = admissionEmployeeService.addStudent(student);
        System.out.println(student);
        System.out.println(student1);
        assertEquals(student,student1);
        */

    }
}
