package com.jpapractice.spring_data_jpa_practice.repository;

import com.jpapractice.spring_data_jpa_practice.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    //JPQL
    @Query("select  s from  Student  s where  s.emailId= ?1")
    Student getStudentByEmailAddress(String emailAddress);

    //JPQL
    @Query("select  s.firstName from  Student  s where  s.emailId= ?1")
    String getStudentFirstNameByEmailAddress(String emailAddress);

    // Native Query
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailAddress);

    // Native Query Named Param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailAddress);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = :firstName where email_address = :emailId",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(@Param("firstName") String firstName, @Param("emailId") String emailId);
}
