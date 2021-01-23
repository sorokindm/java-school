package com.jschool.reha.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Pattern Dto
 *
 * @author Dmitry Sorokin
 */
@Getter
@Setter
public class PatternDto implements Serializable {

    private int idPattern;

    private Boolean monday;

    private Boolean tuesday;

    private Boolean wednesday;

    private Boolean thursday;

    private Boolean friday;

    private Boolean saturday;

    private Boolean sunday;

    private Boolean morning;

    private Boolean day;

    private Boolean evening;

}
