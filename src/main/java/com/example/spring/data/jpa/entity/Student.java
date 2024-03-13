package com.example.spring.data.jpa.entity;

import javax.persistence.Entity;

@Entity
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianPhone;
}
