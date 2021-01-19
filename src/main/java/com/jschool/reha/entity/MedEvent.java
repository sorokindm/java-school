package com.jschool.reha.entity;

import com.jschool.reha.enums.EventStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * POJO Class to store medical event data
 * @author Dmitry Sorokin
 */
@Entity
@Table(name = "med_event")
@Data
public class MedEvent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_med_event",nullable = false)
    private int idMedEvent;

    @ManyToOne
    @JoinColumn(name="id_assignment",nullable = false)
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "id_nurse",nullable=false)
    private MedStaff nurse;

    @Column(name="starts",nullable = false)
    private LocalDateTime starts;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",columnDefinition = "enum('PENDING','SCHEDULED','DONE','CANCELED')",nullable = false)
    private EventStatus status;

    @ManyToOne
    @JoinColumn(name = "id_patient",nullable=false)
    private Patient patient;

}
