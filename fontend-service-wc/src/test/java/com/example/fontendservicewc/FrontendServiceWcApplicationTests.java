package com.example.fontendservicewc;

import com.example.fontendservicewc.model.Grade;
import com.example.fontendservicewc.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FrontendServiceWcApplicationTests {

    @Autowired
    StudentService studentService;
    @Test
    public void contextLoads() {

        List<Grade> grades = studentService.ViewAllGrade(2016000000009l);
        grades.stream().forEach(System.out::println);

    }

}
