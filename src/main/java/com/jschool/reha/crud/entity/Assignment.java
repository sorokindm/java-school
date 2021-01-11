package com.jschool.reha.crud.entity;

import com.jschool.reha.crud.enums.MySQLEnumType;
import com.jschool.reha.crud.enums.PrescriptionType;
import com.jschool.reha.crud.enums.Timeframe;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Dmitry Sorokin
 * POJO Class to store every assignment in scope of treatment
 */
@Entity
@Table(name = "assignment")
@TypeDef(name = "mysql_enum", typeClass = MySQLEnumType.class)
@Data
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idassignment")
    private int idAssignment;
    @ManyToOne
    @JoinColumn(name="idtreatment")
    private Treatment treatment;
    @Enumerated(EnumType.STRING)
    @Column(name = "type",columnDefinition = "enum('MEDICATION','PROCEDURE')")
    private PrescriptionType type;
    @Column(name = "name")
    private String name;
    @Column(name="pattern_quantity")
    private int patternQuantity;
    @Column(name="pattern_howlong")
    private int patternHowlong;
    @Enumerated(EnumType.STRING)
    @Column(name="pattern_timeframe", columnDefinition = "enum('MALE','FEMALE')")
    @Type(type = "mysql_enum")
    private Timeframe timeframe;
    @Column(name="started")
    java.sql.Date started;
    @Column(name="expired")
    java.sql.Date expired;
    @Column(name = "comments")
    private String comments;

    @OneToMany(mappedBy = "assignment")
    private Set<Medevent> medevents;


}
