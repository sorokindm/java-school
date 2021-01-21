package com.jschool.reha.entity;

import com.jschool.reha.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entity Class to store every medical staff data
 * @author Dmitry Sorokin
 */
@Entity
@Table(name = "med_staff")
@Data
public class MedStaff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_med_staff",nullable = false)
    private int idMedStaff;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name="gender", columnDefinition = "enum('MALE','FEMALE')",nullable = false)
    private Gender gender;

    @Column(name="specialty",nullable = false)
    private String specialty;

    @OneToOne
    @JoinColumn(name="id_user",referencedColumnName = "id_user",nullable = false)
    private User user;

    @OneToMany(mappedBy="doctor")
    private List<Treatment> treatmentList;

    @OneToMany(mappedBy="nurse")
    private List<MedEvent> medEventsList;

}
