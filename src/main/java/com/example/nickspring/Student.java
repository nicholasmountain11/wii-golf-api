package com.example.nickspring;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "STUDENT")
public class Student {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "GRADE")
    private int grade;

    @Column(name = "NAME")
    private String name;

    @Column(name = "YEAR")
    private String year;


}