package com.jschool.reha.entity;

import com.jschool.reha.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * POJO Class to store every user data
 * @author Dmitry Sorokin
 */
@Entity
@Table(name = "user")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user",nullable = false)
    private int idPerson;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "enum('ROLE_PATIENT','ROLE_NURSE','ROLE_DOCTOR','ROLE_ADMIN')",nullable = false)
    private Role role;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name="create_time",nullable=false)
    private LocalDateTime createTime;

    @Column(name="enabled", nullable = false)
    private boolean enabled;

    @OneToOne(mappedBy="user")
    private Patient patient;

    @OneToOne(mappedBy="user")
    private MedStaff medStaff;

}
