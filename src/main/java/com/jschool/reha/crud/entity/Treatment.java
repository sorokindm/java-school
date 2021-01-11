package com.jschool.reha.crud.entity;

import com.jschool.reha.crud.enums.MySQLEnumType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Dmitry Sorokin
 * POJO Class to store treatment data for a patient
 */
@Entity
@Table(name = "treatment")
@TypeDef(name = "mysql_enum", typeClass = MySQLEnumType.class)
@Data
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtreatment")
    private int idTreatment;
    @ManyToOne
    @JoinColumn(name="idcurator")
    private Person curator;
    @ManyToOne
    @JoinColumn(name="idperson")
    private Person person;
    @Column(name="diagnosis")
    private String diagnosis;
    @Column(name="started")
    java.sql.Date started;
    @Column(name="ended")
    java.sql.Date ended;
    @OneToMany(mappedBy = "treatment")
    private Set<Assignment> assignments;





}
