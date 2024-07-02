package com.jpapractice.spring_data_jpa_practice.repository;

import com.jpapractice.spring_data_jpa_practice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
}
