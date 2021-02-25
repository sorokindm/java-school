package com.jschool.reha.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Dto for screen rest service
 */
@Getter
@Setter
@NoArgsConstructor
public class RestMedEventDto implements Serializable {
    private int idMedEvent;

    private String patientName;

    private String patientLastName;

    private String nurseName;

    private String nurseLastName;

    private String status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime starts;

}
