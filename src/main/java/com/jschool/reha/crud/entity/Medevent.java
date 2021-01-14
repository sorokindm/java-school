package com.jschool.reha.crud.entity;

import com.jschool.reha.crud.enums.EventStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
//TODO 13.01.2021 matmalik: Please check class name again you should rename file Medevent.java
// not in class Medevent. Also check hotkey shift+F6 how to rename in the whole file

//TODO 13.01.2021 matmalik: @author is after comment
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
    private int idMedevent; //TODO 13.01.2021 matmalik: Do we need to rename it too?

    @ManyToOne
    @JoinColumn(name="id_assignment",nullable = false)
    private Assignment assignment;

    @Column(name="starts",nullable = false)
    LocalDateTime starts; //TODO 13.01.2021 matmalik: why this field is not private?

    @Enumerated(EnumType.STRING)
    @Column(name = "status",columnDefinition = "enum('PENDING','SCHEDULED','DONE','CANCELED')",nullable = false)
    private EventStatus type;//TODO 14.01.2021 matmalik: Why name is type? not status?

    @OneToOne
    @JoinColumn(name = "id_nurse",referencedColumnName = "id_person")
    private Person nurse;

}
