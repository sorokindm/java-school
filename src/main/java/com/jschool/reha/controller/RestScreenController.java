package com.jschool.reha.controller;

import com.jschool.reha.dto.RestMedEventDto;
import com.jschool.reha.service.interfaces.RestService;
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

    private RestService restService;

    public RestScreenController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping("/screen")
    public List<RestMedEventDto> getMedEvents() {
        return restService.getCurrentRestMedEvents();
    }

}
