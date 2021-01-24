package com.jschool.reha.dto;

import com.jschool.reha.entity.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Pattern Dto
 *
 * @author Dmitry Sorokin
 */
@Getter
@Setter
@NoArgsConstructor
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
