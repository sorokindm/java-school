package com.jschool.reha.crud.entity;

import com.jschool.reha.crud.enums.EventStatus;
import com.jschool.reha.crud.enums.MySQLEnumType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

/**
 * @author Dmitry Sorokin
 * POJO Class to store medical event data
 */
@Entity
@Table(name = "medevent")
@TypeDef(name = "mysql_enum", typeClass = MySQLEnumType.class) //TODO 12.01.2021 matmalik: What is the purpose of this annotation?
@Data
public class Medevent {//TODO 12.01.2021 matmalik: use CamelCase please
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedevent")
    private int idMedevent;
    @ManyToOne
    @JoinColumn(name="idassignment")
    private Assignment assignment;
    @Column(name="starts")
    java.sql.Timestamp starts; //TODO 12.01.2021 matmalik: Please think about it.
    // Will it be convenient to use  java.sql.Timestamp instead of simple LocalDate/LocalTime/LocalDateTime of java.time (for example) in your code?
    @Enumerated(EnumType.STRING)
    @Column(name = "status",columnDefinition = "enum('PENDING','SCHEDULED','DONE','CANCELED')")
    private EventStatus type;
    @Column(name = "idexecutor")
    private int idExecutor;


}
