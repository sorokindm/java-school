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
@Data //TODO 12.01.2021 matmalik: You are getting error (lazy init...) because of this annotation. It overrides
// toString() method so you can use simple @Getter @Setter ...  and so on annotations to prevent exception
// for more info https://projectlombok.org/features/Data
public class Assignment { //TODO 12.01.2021 matmalik: Please make it readable (separate fields)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idassignment") //TODO 12.01.2021 matmalik: what is default value of nullable in annotation @Colimn ? Please check
    private int idAssignment;
    @ManyToOne
    @JoinColumn(name="idtreatment") //TODO 12.01.2021 matmalik: Also I think its better to implement Serializable to avoid problems in future
    // https://stackoverflow.com/questions/2020904/when-and-why-jpa-entities-should-implement-the-serializable-interface
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
    java.sql.Date started; //TODO 12.01.2021 matmalik: same as in Medevent entity
    @Column(name="expired")
    java.sql.Date expired; //TODO 12.01.2021 matmalik: same as in Medevent entity
    @Column(name = "comments")
    private String comments;

    @OneToMany(mappedBy = "assignment")
    private Set<Medevent> medevents; //TODO 12.01.2021 matmalik: same as in Person entity

//TODO 12.01.2021 matmalik: remove empty line
}
