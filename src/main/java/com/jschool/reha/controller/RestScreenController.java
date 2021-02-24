package com.jschool.reha.controller;

import com.jschool.reha.dto.RestMedEventDto;
import com.jschool.reha.service.interfaces.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest controller for screen client app
 */
@RestController
@PropertySource("classpath:mq.properties")
public class RestScreenController {

    @Autowired
    RestService restService;


    @GetMapping("/screen")
    public List<RestMedEventDto> getMedEvents() {
        return restService.getCurrentMedEvents();
    }

}
