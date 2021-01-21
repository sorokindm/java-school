package com.jschool.reha.entity;

import com.jschool.reha.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entity Class to store every patient data
 * @author Dmitry Sorokin
 */
@Entity
@Table(name = "patient")
@Data
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient",nullable = false)
    private int idPatient;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name="gender", columnDefinition = "enum('MALE','FEMALE')",nullable = false)
    private Gender gender;

    @Column(name="id_insurance",nullable = false)
    private String idInsurance;

    @OneToOne
    @JoinColumn(name="id_user",referencedColumnName = "id_user",nullable = false)
    private User user;

    @OneToMany(mappedBy="patient")
    private List<Treatment> treatmentList;

    @OneToMany(mappedBy="patient")
    private List<MedEvent> medEventsList;

}
