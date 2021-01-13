package com.jschool.reha.crud.entity;

import com.jschool.reha.crud.dto.UserDto;
import com.jschool.reha.crud.enums.Gender;
import com.jschool.reha.crud.enums.MySQLEnumType;
import com.jschool.reha.crud.enums.Role;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Set;
//TODO 12.01.2021 matmalik: remove useless imports
/**
 * POJO Class to store every user data
 */
@Entity
@Table(name = "person")
@TypeDef(name = "mysql_enum", typeClass = MySQLEnumType.class)
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson")
    private int idPerson;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(name="gender", columnDefinition = "enum('MALE','FEMALE')")
    @Type(type = "mysql_enum")
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "enum('PATIENT','NURSE','DOCTOR','ADMIN')")
    @Type(type = "mysql_enum")
    private Role role;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name="idinsurance")
    private String idinsurance;

    @OneToMany(mappedBy="person")
    private Set<Treatment> treatmentsAsPatient; //TODO 12.01.2021 matmalik: Why Set not Collection or simple List?
    @OneToMany(mappedBy="curator")
    private Set<Treatment> treatmentsAsCurator; //TODO 12.01.2021 matmalik: same as above

}
