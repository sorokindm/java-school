package com.jschool.reha.service.implementation;

import com.jschool.reha.dao.interfaces.MedEventDAO;
import com.jschool.reha.dto.MedEventDto;
import com.jschool.reha.dto.RestMedEventDto;
import com.jschool.reha.dto.helpers.MedEventEntityDtoHelper;
import com.jschool.reha.entity.MedEvent;
import com.jschool.reha.jms.MedEventEntityToRestDtoHelper;
import com.jschool.reha.service.interfaces.RestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestSeviceImpl implements RestService {

    private static final Logger logger = LogManager.getLogger();

    MedEventDAO medEventDAO;

    public RestSeviceImpl(MedEventDAO medEventDAO) {
        this.medEventDAO = medEventDAO;
    }

    @Override
    public List<RestMedEventDto> getCurrentRestMedEvents() {
        List<MedEvent> medEvents = medEventDAO.getCurrentMedEvents();
        ArrayList<RestMedEventDto> dtos = new ArrayList<>();
        for (MedEvent medEvent : medEvents) {
            RestMedEventDto dto = MedEventEntityToRestDtoHelper.entityToDto(medEvent);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<MedEventDto> getCurrentMedEvents() {
        List<MedEvent> medEvents = medEventDAO.getCurrentMedEvents();
        ArrayList<MedEventDto> dtos = new ArrayList<>();
        for (MedEvent medEvent : medEvents) {
            MedEventDto dto = MedEventEntityDtoHelper.entityToDto(medEvent);
            dtos.add(dto);
        }
        return dtos;
    }
}
