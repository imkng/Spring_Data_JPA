package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Guardian;
import com.example.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJdbcTest:- it will insert the data to db and flush it out after it gets over
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void insertStudentTest(){
        Student student = Student.builder()
                .emailId("krishna3@gmail.com")
                .firstName("krishna")
                .lastName("nand")
//                .guardianEmail("@abc@gmaik.com")
//                .guardianName("@abc")
//                .guardianPhone("9809eu9uw9e")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveWithGuardian(){
        Guardian guardian = new Guardian("@abc","@abc@gmaik.com", "9809eu9uw9e");
        Student student = Student.builder()
                .emailId("shivam3@gmail.com")
                .firstName("shivam")
                .lastName("nand")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

}