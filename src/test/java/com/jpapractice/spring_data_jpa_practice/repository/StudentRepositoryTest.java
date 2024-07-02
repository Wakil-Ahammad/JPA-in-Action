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
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("Kumar")
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


}