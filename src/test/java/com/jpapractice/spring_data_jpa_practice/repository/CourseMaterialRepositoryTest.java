package com.jpapractice.spring_data_jpa_practice.repository;

import com.jpapractice.spring_data_jpa_practice.entity.Course;
import com.jpapractice.spring_data_jpa_practice.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
     @Autowired
     private CourseMaterialRepository courseMaterialRepository;

     @Test
     public void saveCourseMaterial() {

         Course course =
                 Course.builder()
                         .title("DSA")
                         .credit(6)
                         .build();

         CourseMaterial courseMaterial =
         CourseMaterial.builder()
                 .url("www.google.com")
                 .course(course)
                 .build();

         courseMaterialRepository.save(courseMaterial);


     }

     @Test
     public void printAllCourseMaterial() {
         List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials: " + courseMaterials);
    }
}