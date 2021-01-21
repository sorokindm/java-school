package com.jschool.reha.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Entity Class to store treatment data for a patient
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
    private MedStaff doctor;

    @ManyToOne
    @JoinColumn(name="id_patient",nullable = false)
    private Patient patient;

    @Column(name="opened",nullable = false)
    private LocalDate treatmentOpened;

    @Column(name="diagnosis")
    private String diagnosis;

    @Column(name="opened_comments",nullable = false)
    private String openedComments;

    @Column(name="closed")
    private LocalDate treatmentClosed;

    @Column(name="closed_comments")
    private String closedComments;

    @OneToMany(mappedBy = "treatment")
    private List<Assignment> assignments;

}
