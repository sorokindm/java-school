package com.jschool.reha.crud.entity;

import com.jschool.reha.crud.enums.EventStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Dmitry Sorokin
 * POJO Class to store medical event data
 */
@Entity
@Table(name = "med_event")
@Data
public class MedEvent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_med_event",nullable = false)
    private int idMedevent;

    @ManyToOne
    @JoinColumn(name="id_assignment",nullable = false)
    private Assignment assignment;

    @Column(name="starts",nullable = false)
    LocalDateTime starts;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",columnDefinition = "enum('PENDING','SCHEDULED','DONE','CANCELED')",nullable = false)
    private EventStatus type;

    @OneToOne
    @JoinColumn(name = "id_nurse",referencedColumnName = "id_person")
    private Person nurse;

}
