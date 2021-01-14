package com.jschool.reha.crud.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
//TODO 13.01.2021 matmalik: @author is after comment
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
    private Person doctor; //TODO 13.01.2021 matmalik: lets talk about it patient=doctor on the call

    @ManyToOne
    @JoinColumn(name="id_person",nullable = false)
    private Person patient;

    @Column(name="diagnosis")
    private String diagnosis;

    @Column(name="started",nullable = false)
    LocalDate started; //TODO 13.01.2021 matmalik: why this field not private?
    //TODO 14.01.2021 matmalik: Its better to rename this field like treatmentStartDate

    @Column(name="ended")
    LocalDate ended; //TODO 13.01.2021 matmalik: why this field not private?
    //TODO 14.01.2021 matmalik: Its better to rename this field like treatmentEndDate

    @OneToMany(mappedBy = "treatment")
    private List<Assignment> assignments;

}
