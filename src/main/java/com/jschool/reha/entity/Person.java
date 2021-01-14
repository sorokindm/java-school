package com.jschool.reha.entity;

import com.jschool.reha.enums.Gender;
import com.jschool.reha.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * POJO Class to store every user data
 * @author Dmitry Sorokin
 */
@Entity
@Table(name = "person")
@Data
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person",nullable = false)
    private int idPerson;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name="gender", columnDefinition = "enum('MALE','FEMALE')",nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "enum('ROLE_PATIENT','ROLE_NURSE','ROLE_DOCTOR','ROLE_ADMIN')",nullable = false)
    private Role role;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name="id_insurance")
    private String idInsurance;

    @OneToMany(mappedBy="patient")
    private List<Treatment> treatmentsAsPatient;

    @OneToMany(mappedBy="doctor")
    private List<Treatment> treatmentsAsDoctor;

}
