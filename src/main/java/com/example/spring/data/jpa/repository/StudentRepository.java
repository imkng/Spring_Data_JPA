package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstname);
    public List<Student> findByFirstNameContaining(String name);

    // JPQL:- will be based on Student Class property, not student table from data base
    @Query("Select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailId(String emailId);

    @Query("Select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailId(String emailId);
}
