package com.jschool.reha.entity;

import com.jschool.reha.enums.AssignmentType;
import com.jschool.reha.enums.Timeframe;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Entity Class to store every assignment in scope of treatment
 * @author Dmitry Sorokin
 */
@Entity
@Table(name = "assignment")
@Data
public class Assignment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assignment",nullable = false)
    private int idAssignment;

    @ManyToOne
    @JoinColumn(name="id_treatment",nullable = false)
    private Treatment treatment;

    @Enumerated(EnumType.STRING)
    @Column(name = "type",columnDefinition = "enum('MEDICATION','PROCEDURE')",nullable = false)
    private AssignmentType type;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "dosage",nullable = false)
    private String dosage;

    @Column(name="pattern_quantity",nullable = false)
    private int patternQuantity;

    @Column(name="pattern_howlong",nullable = false)
    private int patternHowlong;

    @Enumerated(EnumType.STRING)
    @Column(name="pattern_timeframe", columnDefinition = "enum('MALE','FEMALE')",nullable = false)
    private Timeframe timeframe;

    @Column(name="started",nullable = false)
    private LocalDate assignmentStartDate;

    @Column(name="ended")
    private LocalDate assignmentEndDate;

    @Column(name = "ended_comments")
    private String endedComments;

    @OneToMany(mappedBy = "assignment")
    private List<MedEvent> medEvents;

}
