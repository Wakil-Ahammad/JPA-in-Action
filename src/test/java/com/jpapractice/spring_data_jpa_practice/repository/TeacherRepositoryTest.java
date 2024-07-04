package com.jpapractice.spring_data_jpa_practice.repository;

import com.jpapractice.spring_data_jpa_practice.entity.Course;
import com.jpapractice.spring_data_jpa_practice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

   @Test
   public void saveTeacher() {
       Course courseDBA = Course.builder()
               .title("DBA")
               .credit(5)
               .build();

       Course courseJAVA = Course.builder()
               .title("JAVA")
               .credit(6)
               .build();

       Teacher teacher = Teacher.builder()
               .firstName("Qutub")
               .lastName("Khan")
               //.courses(List.of(courseDBA, courseJAVA))
               .build();

       teacherRepository.save(teacher);
   }
}