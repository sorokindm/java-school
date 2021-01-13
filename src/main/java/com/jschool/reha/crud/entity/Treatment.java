package com.jschool.reha.crud.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Dmitry Sorokin
 * POJO Class to store treatment data for a patient
 */
@Entity
@Table(name = "treatment")
@Data
public class Treatment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_treatment",nullable = false)
    private int idTreatment;

    @ManyToOne
    @JoinColumn(name="id_doctor",nullable = false)
    private Person doctor;

    @ManyToOne
    @JoinColumn(name="id_person",nullable = false)
    private Person patient;

    @Column(name="diagnosis")
    private String diagnosis;

    @Column(name="started",nullable = false)
    LocalDate started;

    @Column(name="ended")
    LocalDate ended;

    @OneToMany(mappedBy = "treatment")
    private List<Assignment> assignments;

}
