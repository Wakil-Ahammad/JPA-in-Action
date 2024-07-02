package com.jpapractice.spring_data_jpa_practice.repository;

import com.jpapractice.spring_data_jpa_practice.entity.Gurdian;
import com.jpapractice.spring_data_jpa_practice.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("shabbir@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
//                .gurdianName("Nikhil")
//                .gurdianEmail("nikhil@gmail.com")
//                .gurdianPhone("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGurdian(){

        Gurdian gurdian = Gurdian.builder()
                .name("Nikhil")
                .email("nikhil@gmail.com")
                .phone("9999999999")
                .build();


        Student student = Student.builder()
                .firstName("Shabbir")
                .emailId("shabbir@gmail.com")
                .lastName("Dawoodi")
                .gurdian(gurdian)
                .build();

        studentRepository.save(student);
    }



    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("student list :" + studentList);
    }

    @Test
    public void findStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Shabbir");
        System.out.println("student list :" + studentList);
    }

    @Test
    public  void printgetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("shabbir@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("shabbir@gmail.com");
        System.out.println("firstName :" + firstName);
    }

    @Test
    public  void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("shabbir@gmail.com");
        System.out.println(student);
    }

    @Test
    public  void printgetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("shabbir@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailAddress(){
        studentRepository.updateStudentNameByEmailId("shabbir dawoodi", "shabbir@gmail.com");
    }


}