package com.flc.starter;

import com.flc.bean.Klass;
import com.flc.bean.Student;
import com.flc.service.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class StarterApplicationTests {

    @Autowired
    private Student student;
    @Autowired
    private Klass klass;
    @Autowired
    private School school;

    @Test
    void contextLoads() {
        int id = student.getId();
        String name = student.getName();
        List<Student> students = new ArrayList<>();
        students.add(student);
        klass.setStudents(students);
        school.ding();
    }

}
