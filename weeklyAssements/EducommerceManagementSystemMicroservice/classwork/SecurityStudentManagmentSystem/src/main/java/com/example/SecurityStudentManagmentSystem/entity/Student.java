package com.example.SecurityStudentManagmentSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String course;
    private double marks;
    @Lob
    private byte[] profileImage;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private  byte[] assignmentFile;
}
