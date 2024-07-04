package com.jpapractice.spring_data_jpa_practice.repository;

import com.jpapractice.spring_data_jpa_practice.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
