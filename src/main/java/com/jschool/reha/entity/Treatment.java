package com.jschool.reha.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * POJO Class to store treatment data for a patient
 * @author Dmitry Sorokin
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
    private LocalDate treatmentStartDate;

    @Column(name="ended")
    private LocalDate treatmentEndDate;

    @OneToMany(mappedBy = "treatment")
    private List<Assignment> assignments;

}
