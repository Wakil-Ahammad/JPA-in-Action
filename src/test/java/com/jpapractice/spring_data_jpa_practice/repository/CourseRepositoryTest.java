package com.jpapractice.spring_data_jpa_practice.repository;

import com.jpapractice.spring_data_jpa_practice.entity.Course;
import com.jpapractice.spring_data_jpa_practice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses: " + courses);
    }

   @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Oshok")
                .lastName("Kumar")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(10)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}