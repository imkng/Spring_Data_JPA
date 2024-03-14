package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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


    //native Sql query will based on table in dB
    @Query(
            value = "Select * from tbl_student s where s.first_name =?1",
            nativeQuery = true
    )
    public List<Student> getStudentsBasedOnFirstName(String firstName);

    //native Sql query will based on table in dB
    @Query(
            value = "Select * from tbl_student s where s.first_name =?firstName",
            nativeQuery = true
    )
    public List<Student> getStudentsBasedOnFirstNameBasedOnParam(@Param("firstName") String firstName);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student s set s.first_name = ?1  where s.email_address =?2",
            nativeQuery = true
    )
    public int modifyStudentsFirstNameBasedOnEmail(String firstName, String emailId);
}
