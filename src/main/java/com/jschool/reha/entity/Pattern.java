package com.jschool.reha.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity Class to store assignment pattern
 *
 * @author Dmitry Sorokin
 */
@Entity
@Table(name = "pattern")
@Getter
@Setter
public class Pattern implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pattern", nullable = false)
    private int idPattern;

    @Column(name = "monday", nullable = false)
    private Boolean monday;

    @Column(name = "tuesday", nullable = false)
    private Boolean tuesday;

    @Column(name = "wednesday", nullable = false)
    private Boolean wednesday;

    @Column(name = "thursday", nullable = false)
    private Boolean thursday;

    @Column(name = "friday", nullable = false)
    private Boolean friday;

    @Column(name = "saturday", nullable = false)
    private Boolean saturday;

    @Column(name = "sunday", nullable = false)
    private Boolean sunday;

    @Column(name = "morning", nullable = false)
    private Boolean morning;

    @Column(name = "day", nullable = false)
    private Boolean day;

    @Column(name = "evening", nullable = false)
    private Boolean evening;

}
