package com.jschool.reha.service.implementation;

import com.jschool.reha.dao.interfaces.MedEventDAO;
import com.jschool.reha.entity.MedEvent;
import com.jschool.reha.jms.MedEventEntityToRestDtoHelper;
import com.jschool.reha.dto.RestMedEventDto;
import com.jschool.reha.service.interfaces.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestSeviceImpl implements RestService {

    @Autowired
    MedEventDAO medEventDAO;

    @Override
    public List<RestMedEventDto> getCurrentMedEvents() {
        List<MedEvent> medEvents=medEventDAO.getCurrentMedEvents();
        ArrayList<RestMedEventDto> dtos=new ArrayList<>();
        for (MedEvent medEvent:medEvents) {
            RestMedEventDto dto=MedEventEntityToRestDtoHelper.entityToDto(medEvent);
            dtos.add(dto);
        }
        return dtos;
    }
}
